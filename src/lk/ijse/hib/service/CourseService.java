/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.service;

import java.util.List;
import lk.ijse.hib.core.Course;

/**
 *
 * @author minoli
 */
public interface CourseService {
    public boolean addCourse(Course course) throws Exception;
    public boolean updateCourse(Course course) throws Exception;
    public Course searchCourse(int id) throws Exception;
    public boolean deleteCourse(int id)throws Exception;
    public List<Course> getAllCourse() throws Exception;
}
