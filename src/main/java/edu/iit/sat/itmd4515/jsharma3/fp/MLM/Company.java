/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.jsharma3.fp.MLM;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

/**
 *
 * @author Jay
 */
@Entity
@NamedQueries({
    @NamedQuery(name = "Company.findById", query = "select cm from Company cm where cm.id = :id "),
    @NamedQuery(name = "Company.findByAll", query = "select cm from Company cm "),
    @NamedQuery(name = "Company.findByName", query = "select cm from Company cm where cm.name = :name")
})
public class Company extends Entities implements Serializable{
    
    @OneToMany(mappedBy = "company")
    private List<Products> products = new ArrayList<>();

    private String name;
    private String productName;

    public Company() {
    }

   
    /**
     *
     * @return
     */
    public String getName() {
        return name;
    }

    /**
     *
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }
    

    /**
     *
     */

    
    /**
     *
     * @return
     */
    public List<Products> getProducts() {
        return products;
    }
    
    /**
     *
     * @return
     */
    public String getProductName() {
        return productName;
    }

    /**
     *
     * @param productName
     */
    public void setProductName(String productName) {
        this.productName = productName;
    }

    private String productType;

    /**
     *
     * @return
     */
    public String getProductType() {
        return productType;
    }

    /**
     *
     * @param productType
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

   
    public Company(String name, String productName, String productType) {
        this.name = name;
        this.productName = productName;
        this.productType = productType;
    }
    

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder(super.toString());
        sb.append("\n\t");
        sb.append("Product{type=").append(productType).append('}');
        return sb.toString();
    }
}
