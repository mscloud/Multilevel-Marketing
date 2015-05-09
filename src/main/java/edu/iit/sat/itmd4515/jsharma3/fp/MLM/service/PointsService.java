/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.jsharma3.fp.MLM.service;

import edu.iit.sat.itmd4515.jsharma3.fp.MLM.Points;
import java.util.List;
import javax.ejb.Stateless;

/**
 *
 * @author Jay
 */
@Stateless
public class PointsService extends AbstractService<Points> {
    
    public PointsService() {
        super(Points.class);
    }

    @Override
    public List<Points> findAll() {
        return getEntityManager().createNamedQuery("Points.findAll",Points.class).getResultList();
    }
}