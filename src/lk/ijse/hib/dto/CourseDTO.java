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
public class CourseDTO {
    private int courseId;
    private String courseName;
    private String Duration;
    private double fees;

    public CourseDTO() {
    }

    public CourseDTO(int courseId, String courseName, String Duration, double fees) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.Duration = Duration;
        this.fees = fees;
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
     * @return the Duration
     */
    public String getDuration() {
        return Duration;
    }

    /**
     * @param Duration the Duration to set
     */
    public void setDuration(String Duration) {
        this.Duration = Duration;
    }

    /**
     * @return the fees
     */
    public double getFees() {
        return fees;
    }

    /**
     * @param fees the fees to set
     */
    public void setFees(double fees) {
        this.fees = fees;
    }
    
}
