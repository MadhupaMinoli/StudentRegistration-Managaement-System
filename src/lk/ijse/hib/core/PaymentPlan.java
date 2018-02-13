/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.core;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author minoli
 */
@Entity
public class PaymentPlan implements Serializable{
    private int planId;
    private String period;

    private Set<Registration> registration=new HashSet<Registration>();

    /**
     * @return the planId
     */
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int getPlanId() {
        return planId;
    }

    /**
     * @param planId the planId to set
     */
    public void setPlanId(int planId) {
        this.planId = planId;
    }

    /**
     * @return the period
     */
    public String getPeriod() {
        return period;
    }

    /**
     * @param period the period to set
     */
    public void setPeriod(String period) {
        this.period = period;
    }

    /**
     * @return the registration
     */
    @OneToMany(cascade = CascadeType.ALL,mappedBy = "paymentPlan")
    
    public Set<Registration> getRegistration() {
        return registration;
    }

    /**
     * @param registration the registration to set
     */
    public void setRegistration(Set<Registration> registration) {
        this.registration = registration;
    }

    
    
    
}
