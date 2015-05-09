/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.jsharma3.fp.MLM;

import edu.iit.sat.itmd4515.jsharma3.fp.MLM.security.User;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;

/**
 *
 * @author Jay
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Members.findById", query = "select m from Members m where m.id = :id "),
    @NamedQuery(name = "Members.findByAll", query = "select m from Members m "),
    @NamedQuery(name = "Members.findByReferance", query = "select m from Members m where m.referance_code = :referance_code "),
    @NamedQuery(name = "Members.findByUsername", query = "select m from Members m where m.user.userName = :username")})

public class Members extends Person implements Serializable{

    @OneToOne
    @JoinColumn(name = "Points")
    private Points pnt;
   
    @OneToOne
    private User user;

    public User getUser() {
        return user;
    }

    /**
     * Set the value of user
     *
     * @param user new value of user
     */
    public void setUser(User user) {
        this.user = user;
    }

    
    @ManyToMany(mappedBy = "member", cascade = CascadeType.PERSIST)
    private List<Customer> customer = new ArrayList<>();
    
    /**
     *
     * @return
     */
    public List<Customer> getCustomer() {
        return customer;
    }
    
    /**
     *
     * @return
     */
    public Points getPnt() {
        return pnt;
    }

    /**
     *
     * @param pnt
     */
    public void setPnt(Points pnt) {
        this.pnt = pnt;
    }
    
    /**
     *
     * @return
     */    
    private String referance_code;

    /**
     *
     * @return
     */
    public String getReferance_code() {
        return referance_code;
    }

    /**
     *
     * @param referance_code
     */
    public void setReferance_code(String referance_code) {
        this.referance_code = referance_code;
    }

    /**
     *
     */
    
    public Members() {
    }

    public Members(String referance_code, String firstName, String lastName, String email, Date birthDate) {
        super(firstName, lastName, email, birthDate);
        this.referance_code = referance_code;
    }

    public Members(String firstName, String lastName, String email, Date birthDate) {
        super(firstName, lastName, email, birthDate);
    }
    
    
}
