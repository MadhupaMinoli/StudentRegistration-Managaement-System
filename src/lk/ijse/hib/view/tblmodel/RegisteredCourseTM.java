/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.view.tblmodel;

/**
 *
 * @author minoli
 */
public class RegisteredCourseTM {
    private int courseId;
    private String courseName;
    private String courseDuration;
    private String paymentPlan;
    private String registeredDate;

    public RegisteredCourseTM(int courseId, String courseName, String courseDuration, String paymentPlan, String registeredDate) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.courseDuration = courseDuration;
        this.paymentPlan = paymentPlan;
        this.registeredDate = registeredDate;
    }

    
   
   

    public RegisteredCourseTM() {
    }

    /**
     * @return the courseId
     */
    public int getCourseId() {
        return courseId;
    }

    /**
     * @param courseId the courseId to set
     */
    public void setCourseId(int courseId) {
        this.courseId = courseId;
    }

    /**
     * @return the courseName
     */
    public String getCourseName() {
        return courseName;
    }

    /**
     * @param courseName the courseName to set
     */
    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    /**
     * @return the courseDuration
     */
    public String getCourseDuration() {
        return courseDuration;
    }

    /**
     * @param courseDuration the courseDuration to set
     */
    public void setCourseDuration(String courseDuration) {
        this.courseDuration = courseDuration;
    }

    /**
     * @return the paymentPlan
     */
    public String getPaymentPlan() {
        return paymentPlan;
    }

    /**
     * @param paymentPlan the paymentPlan to set
     */
    public void setPaymentPlan(String paymentPlan) {
        this.paymentPlan = paymentPlan;
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
    
}
