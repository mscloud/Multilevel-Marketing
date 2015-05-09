/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iit.sat.itmd4515.jsharma3.fp.MLM;

import java.util.Date;
import java.util.GregorianCalendar;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Jay
 */
@MappedSuperclass
public class Entities {
 
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
  
    @Temporal (TemporalType.TIMESTAMP)
    private Date addingDate;

    @PreUpdate
    @PrePersist
    private void setAddingDate(){
        addingDate = GregorianCalendar.getInstance().getTime();
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setAddingDate(Date addingDate) {
        this.addingDate = addingDate;
    }

    
    /**
     *
     * @return
     */
    public Date getAddingDate() {
        return addingDate;
    }
 
    /**
     *
     * @return
     */
    public Long getId() {
        return id;
    }
   
}
