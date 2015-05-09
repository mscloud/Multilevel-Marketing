/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.jsharma3.fp.MLM.products;

import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;
import edu.iit.sat.itmd4515.jsharma3.fp.MLM.Products;
import edu.iit.sat.itmd4515.jsharma3.fp.MLM.service.ProductsService;
import edu.iit.sat.itmd4515.jsharma3.fp.MLM.web.AbstractJSFBean;
import edu.iit.sat.itmd4515.jsharma3.fp.MLM.web.LoginBean;
import java.util.List;
import java.util.Properties;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.websocket.Session;
import static jdk.nashorn.internal.codegen.Compiler.LOG;
import sun.rmi.transport.Transport;
import java.util.Properties;
import java.util.Timer;
import javax.ejb.EJBException;
import javax.ejb.Timeout;

/**
 *
 * @author Jay
 */
@Named
@RequestScoped
public class ProductsBean extends AbstractJSFBean {

    private Products products;
    private List<Products> product;
    @EJB ProductsService productsService;
    @Inject LoginBean loginBean;
    
    public ProductsBean() {
    }
 
    @Timeout
    public void timeout(Timer timer) {
        System.out.println("TimerBean: timeout occurred");
    }
    
    
    @PostConstruct
    private void postConstruct(){
        super.postContruct();
        products = new Products();
        product = productsService.findAll();
        refreshProducts();
    }
    
    public Products getProducts() {
        return products;
    }
    public void setProducts(Products products) {
        this.products = products;
    }
    public List<Products> getProduct() {
        return product;
    }
    public void setProduct(List<Products> product) {
        this.product = product;
    }
    
    private void refreshProducts() {
        
        product = productsService.findAll();
    }

    
    public String doCreate() {
        
        products = new Products();
        refreshProducts();
        return loginBean.getPortalPathByRole("/newProducts.xhtml");
    }
    
    public String doDelete(Products products) {
        LOG.info("The product to delete is " + products.toString());
        productsService.delete(products);
        refreshProducts();
        return loginBean.getPortalPathByRole("/allProductandCombos.xhtml");
    }
    
    public String doUpdate(Products products) {
        this.products = products;
        LOG.info("The product to update is " + products.toString());
        refreshProducts();
        return loginBean.getPortalPathByRole("/newProducts.xhtml");
    }

    public String goToOrder(){
        return loginBean.getPortalPathByRole("/order.xhtml");
    } 

    public String goToOut(){
        facesContext.getMessages("Order Successfully");
        return loginBean.getPortalPathByRole("/welcome.xhtml");
    } 
    
    

    public String executeSave() {
        if (this.products.getId() != null) {
            LOG.info("Executing update on " + this.products.toString());
            productsService.update(products);
            refreshProducts();
            return loginBean.getPortalPathByRole("/allProductandCombos.xhtml");
        } else {
            LOG.info("Creating " + this.products.toString());
            // TODO - fix create!  It is creating a new station
            productsService.create(products);
            refreshProducts();
            return loginBean.getPortalPathByRole("/allProductandCombos.xhtml");
        }
    }
}


    

