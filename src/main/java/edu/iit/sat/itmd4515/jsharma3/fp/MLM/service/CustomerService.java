/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.jsharma3.fp.MLM.service;

import edu.iit.sat.itmd4515.jsharma3.fp.MLM.Customer;
import edu.iit.sat.itmd4515.jsharma3.fp.MLM.Members;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Named;

/**
 *
 * @author Jay
 */
@Stateless
@Named
public class CustomerService extends AbstractService<Customer> {

    public CustomerService() {
        super(Customer.class);
    }

    
    @Override
    public List<Customer> findAll() {
        return getEntityManager().createNamedQuery("Customer.findAll",Customer.class).getResultList();
    }

    public Customer findByUsername(String username) {
        return getEntityManager().createNamedQuery("Customer.findByUsername",Customer.class).setParameter("username", username).getSingleResult();
    }
    
    public void create(Customer customer,Members member){
        
        member = getEntityManager().getReference(Members.class, member.getId());
        
        customer.setMemberref_code("abc123");
        member.getCustomer().add(customer);
        getEntityManager().persist(customer);
    }
    
    
    public void delete(Customer customer,Members member){
        
        customer = getEntityManager().getReference(Customer.class, customer.getId());
        member = getEntityManager().getReference(Members.class, member.getId());
        
        member.getCustomer().remove(customer);
        customer.getMembers().remove(member);
        
        
        if(customer.getMembers().isEmpty()){
            
            getEntityManager().remove(customer);
        }
    }
}
