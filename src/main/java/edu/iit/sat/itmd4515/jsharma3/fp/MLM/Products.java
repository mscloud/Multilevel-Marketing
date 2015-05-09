/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.jsharma3.fp.MLM;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;

/**
 *
 * @author Jay
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Products.findById", query = "select p from Products p where p.id = :id "),
    @NamedQuery(name = "Products.findAll", query = "select p from Products p "),
    @NamedQuery(name = "Products.findByName", query = "select p from Products p where p.product_name = :product_name ")
})
public class Products extends Entities implements Serializable {

    @ManyToOne
    @JoinColumn(name = "Company_ID")
    private Company company;
    
    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(name = "combo_item",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "combo_id"))
    private List<Combos> combo = new ArrayList<>();
    
    
    /**
     *
     */
    public Products() {
    }
    
    private String product_name;

    /**
     *
     * @return
     */
    public String getProduct_name() {
        return product_name;
    }

    /**
     *
     * @param product_name
     */
    public void setProduct_name(String product_name) {
        this.product_name = product_name;
    }
    
    private String product_price;

    /**
     *
     * @return
     */
    public String getProduct_price() {
        return product_price;
    }

    /**
     *
     * @param product_price
     */
    public void setProduct_price(String product_price) {
        this.product_price = product_price;
    }
    
    private String product_type;

    /**
     *
     * @return
     */
    public String getProduct_type() {
        return product_type;
    }

    /**
     *
     * @param product_type
     */
    public void setProduct_type(String product_type) {
        this.product_type = product_type;
    }

    private String product_weight;

    /**
     *
     * @return
     */
    public String getProduct_weight() {
        return product_weight;
    }

    /**
     *
     * @param product_weight
     */
    public void setProduct_weight(String product_weight) {
        this.product_weight = product_weight;
    }

    private String product_availibility;

    /**
     *
     * @return
     */
    public String getProduct_availibility() {
        return product_availibility;
    }

    /**
     *
     * @param product_availibility
     */
    public void setProduct_availibility(String product_availibility) {
        this.product_availibility = product_availibility;
    }
    
    /**
     *
     * @return
     */
    public Company getCompany() {
        return company;
    }

    /**
     *
     * @param company
     */
    public void setCompany(Company company) {
        this.company = company;
    }

    /**
     *
     * @return
     */
    public List<Combos> getCombos() {
        return combo;
    }

    public Products(String product_name, String product_price, String product_type, String product_weight, String product_availibility) {
        this.product_name = product_name;
        this.product_price = product_price;
        this.product_type = product_type;
        this.product_weight = product_weight;
        this.product_availibility = product_availibility;
    }

   


}
