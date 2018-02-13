/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.dto;

/**
 *
 * @author minoli
 */
public class CourseRegistrationDTO {
    private int studentId;
    private int courseId;
    private String registeredDate;
    private int paymentPlanId;

    public CourseRegistrationDTO(int studentId, int courseId, String registeredDate, int paymentPlanId) {
        this.studentId = studentId;
        this.courseId = courseId;
        this.registeredDate = registeredDate;
        this.paymentPlanId = paymentPlanId;
    }

    public CourseRegistrationDTO() {
    }

    /**
     * @return the studentId
     */
    public int getStudentId() {
        return studentId;
    }

    /**
     * @param studentId the studentId to set
     */
    public void setStudentId(int studentId) {
        this.studentId = studentId;
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
     * @return the paymentPlanId
     */
    public int getPaymentPlanId() {
        return paymentPlanId;
    }

    /**
     * @param paymentPlanId the paymentPlanId to set
     */
    public void setPaymentPlanId(int paymentPlanId) {
        this.paymentPlanId = paymentPlanId;
    }
}
