/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.jsharma3.fp.MLM.service;


import edu.iit.sat.itmd4515.jsharma3.fp.MLM.Combos;
import edu.iit.sat.itmd4515.jsharma3.fp.MLM.Company;
import edu.iit.sat.itmd4515.jsharma3.fp.MLM.Products;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Jay
 */
@Stateless
public class ProductsService extends AbstractService<Products> {
    
    public ProductsService() {
        super(Products.class);
    }

    @Override
    public List<Products> findAll() {
        return getEntityManager().createNamedQuery("Products.findAll",Products.class).getResultList();
    }


    public void create(Products products,Company company){
        company = getEntityManager().getReference(Company.class, company.getId());
        
        products.setCompany(company);
        company.getProducts().add(products);
        
        getEntityManager().persist(products);
    }
    
    
    public void delete(Products products,Combos combos){
        
        products = getEntityManager().getReference(Products.class, products.getId());
        combos = getEntityManager().getReference(Combos.class, combos.getId());
        
        combos.getProducts().remove(products);
        products.getCombos().remove(combos);
        
        if(products.getCombos().isEmpty()){
            
            products.getCompany().getProducts().remove(products);
            products.setCompany(null);
            
            getEntityManager().remove(products);
        }
    }
}
