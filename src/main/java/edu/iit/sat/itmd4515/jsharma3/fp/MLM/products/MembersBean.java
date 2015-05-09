/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.jsharma3.fp.MLM.products;

import edu.iit.sat.itmd4515.jsharma3.fp.MLM.Members;
import edu.iit.sat.itmd4515.jsharma3.fp.MLM.service.MembersService;
import edu.iit.sat.itmd4515.jsharma3.fp.MLM.web.AbstractJSFBean;
import edu.iit.sat.itmd4515.jsharma3.fp.MLM.web.LoginBean;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author Jay
 */
@Named
@RequestScoped
public class MembersBean extends AbstractJSFBean {

    private static final Logger LOG = Logger.getLogger(MembersBean.class.getName());
    private Members member;  
    private List<Members> members;
    
    @EJB MembersService membersService;
    @Inject LoginBean loginBean;
    

    public List<Members> getMembers() {
        return members;
    }
    public void setMembers(List<Members> members) {
        this.members = members;
    }
    public Members getMember() {
        return member;
    }

    public void setMember(Members member) {
        this.member = member;
    }

    
    public MembersBean() {
        super();
    }
    
   
    @PostConstruct
    protected void postContruct() {
        super.postContruct();
        member = membersService.findByUsername(loginBean.getRemoteUser());
        LOG.log(Level.INFO, "Inside MembersBean.postConstruct() with {0}", member.toString());
    }
    
    public String executeUpdate(Members members) {
        
        LOG.log(Level.INFO, "Inside MembersBean.executeUpdate() with {0}", membersService.toString());
        membersService.update(member);
        return loginBean.getPortalPathByRole("/myAccount.xhtml");
    }

    
}   
