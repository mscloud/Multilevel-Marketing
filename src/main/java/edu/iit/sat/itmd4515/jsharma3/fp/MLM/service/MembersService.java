/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.jsharma3.fp.MLM.service;

import edu.iit.sat.itmd4515.jsharma3.fp.MLM.Customer;
import edu.iit.sat.itmd4515.jsharma3.fp.MLM.Members;
import edu.iit.sat.itmd4515.jsharma3.fp.MLM.Points;
import edu.iit.sat.itmd4515.jsharma3.fp.MLM.security.User;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author Jay
 */
@Named
@Stateless
public class MembersService extends AbstractService<Members>{
    
    public MembersService() {
        super(Members.class);
    }

    @Override
    public List<Members> findAll() {
        return getEntityManager().createNamedQuery("Members.findByAll",Members.class).getResultList();
    }

    public Members findByUsername(String username) {
        return getEntityManager().createNamedQuery("Members.findByUsername",Members.class).setParameter("username", username).getSingleResult();
    }

    public void create(Members member,User user,Points point){
        
        point = getEntityManager().getReference(Points.class, point.getId());
        
        member.setPnt(point);
        point.getMembers().add(member);
          
        member.setUser(user);
        
        getEntityManager().persist(member);
    }
    
    
    public void delete(Members member,Customer customer){
        
        member = getEntityManager().getReference(Members.class, member.getId());
        customer = getEntityManager().getReference(Customer.class, customer.getId());
        
        customer.getMembers().remove(member);
        member.getCustomer().remove(customer);
        
        if(member.getCustomer().isEmpty()){
            
            getEntityManager().remove(member);
        }
    }
    
}
