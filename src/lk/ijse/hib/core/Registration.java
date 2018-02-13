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
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

/**
 *
 * @author minoli
 */
@Entity
public class Registration implements Serializable {

    
    private RegisteredId registerId;

    private String registeredDate;

    
    private Course course;
    
    
    private Student student;

    

    
    private Set<Payments> payments = new HashSet<Payments>();
    
    private PaymentPlan paymentPlan;

    /**
     * @return the registerId
     */
    @EmbeddedId
    public RegisteredId getRegisterId() {
        return registerId;
    }

    /**
     * @param registerId the registerId to set
     */
    public void setRegisterId(RegisteredId registerId) {
        this.registerId = registerId;
    }

    /**
     * @return the registeredDate
     */
    public String getRegisteredDate() {
        return registeredDate;
    }

    /**
     * @param registeredDate the registeredDate to set
     */
    public void setRegisteredDate(String registeredDate) {
        this.registeredDate = registeredDate;
    }

    /**
     * @return the student
     */
    
    @MapsId("studentId")
    @ManyToOne(cascade = CascadeType.ALL)
    public Student getStudent() {
        return student;
    }

    /**
     * @param student the student to set
     */
    public void setStudent(Student student) {
        this.student = student;
    }

    /**
     * @return the course
     */
    @MapsId("courseId")
    @ManyToOne(cascade = CascadeType.ALL)
    public Course getCourse() {
        return course;
    }

    /**
     * @param course the course to set
     */
    public void setCourse(Course course) {
        this.course = course;
    }

    /**
     * @return the payments
     */
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "registration")
    public Set<Payments> getPayments() {
        return payments;
    }

    /**
     * @param payments the payments to set
     */
    public void setPayments(Set<Payments> payments) {
        this.payments = payments;
    }

    /**
     * @return the paymentPlan
     */
    
    @ManyToOne(cascade = CascadeType.ALL)
    public PaymentPlan getPaymentPlan() {
        return paymentPlan;
    }

    /**
     * @param paymentPlan the paymentPlan to set
     */
    public void setPaymentPlan(PaymentPlan paymentPlan) {
        this.paymentPlan = paymentPlan;
    }

   

}
