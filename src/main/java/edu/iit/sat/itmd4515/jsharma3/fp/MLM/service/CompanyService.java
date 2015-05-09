/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.jsharma3.fp.MLM.service;

import edu.iit.sat.itmd4515.jsharma3.fp.MLM.Company;
import edu.iit.sat.itmd4515.jsharma3.fp.MLM.Products;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Jay
 */
@Stateless
public class CompanyService extends AbstractService<Company> {
    
    public CompanyService() {
        super(Company.class);
    }

    @Override
    public List<Company> findAll() {
        return getEntityManager().createNamedQuery("Company.findAll",Company.class).getResultList();
    }

}
