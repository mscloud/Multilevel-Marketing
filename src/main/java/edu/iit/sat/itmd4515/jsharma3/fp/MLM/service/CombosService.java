/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.jsharma3.fp.MLM.service;

import edu.iit.sat.itmd4515.jsharma3.fp.MLM.Combos;
import edu.iit.sat.itmd4515.jsharma3.fp.MLM.Products;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Jay
 */
@Stateless
public class CombosService extends AbstractService<Combos> {
    
    public CombosService() {
        super(Combos.class);
    }

    @Override
    public List<Combos> findAll() {
        return getEntityManager().createNamedQuery("Combos.findAll",Combos.class).getResultList();
    }

   public void create(Combos combos,Products products){
        combos = getEntityManager().getReference(Combos.class, combos.getId());
        
        products.getCombos().add(combos);
        
        getEntityManager().persist(combos);
    }
    
    
    public void delete(Combos combos,Products products){
        
        combos = getEntityManager().getReference(Combos.class, combos.getId());
        products = getEntityManager().getReference(Products.class, products.getId());
        
        
        products.getCombos().remove(combos);
        combos.getProducts().remove(products);
        
        
        if(combos.getProducts().isEmpty()){
            
            getEntityManager().remove(combos);
        }
    }
}
