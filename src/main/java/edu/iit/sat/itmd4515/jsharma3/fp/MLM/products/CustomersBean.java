/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.jsharma3.fp.MLM.products;

import edu.iit.sat.itmd4515.jsharma3.fp.MLM.Customer;
import edu.iit.sat.itmd4515.jsharma3.fp.MLM.Members;
import edu.iit.sat.itmd4515.jsharma3.fp.MLM.service.CustomerService;
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
public class CustomersBean extends AbstractJSFBean {

    private static final Logger LOG = Logger.getLogger(CustomersBean.class.getName());
    private Customer customer;
    private List<Customer> customers;

    /**
     * Get the value of customers
     *
     * @return the value of customers
     */
    public List<Customer> getCustomer() {
        return customers;
    }

    /**
     * Set the value of customers
     *
     * @param customers new value of customers
     */
    public void setCustomer(List<Customer> customers) {
        this.customers = customers;
    }

    @EJB CustomerService customersService;
    @Inject LoginBean loginBean;
    
    /**
     *
     * @return
     */
    public Customer getCustomers() {
        return customer;
    }

    public void setCustomers(Customer customer) {
        this.customer = customer;
    }

    
    public CustomersBean() {
        super();
    }
    
    
    @PostConstruct
    protected void postContruct() {
        super.postContruct();
        customer = customersService.findByUsername(loginBean.getRemoteUser());
        LOG.log(Level.INFO, "Inside CustomersBean.postConstruct() with {0}", customer.toString());
     }
    
    public String executeUpdate(Customer customer) {
        
        LOG.log(Level.INFO, "Inside CustomersBean.executeUpdate() with {0}", customersService.toString());
        customersService.update(customer);
        return loginBean.getPortalPathByRole("/allCustomer.xhtml");
    }

     
}
