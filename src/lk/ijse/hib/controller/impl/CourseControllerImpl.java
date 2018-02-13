/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.controller.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.hib.controller.CourseController;
import lk.ijse.hib.core.Course;
import lk.ijse.hib.core.Student;
import lk.ijse.hib.dto.CourseDTO;
import lk.ijse.hib.dto.StudentDTO;
import lk.ijse.hib.service.CourseService;
import lk.ijse.hib.service.impl.CourseServiceImpl;

/**
 *
 * @author minoli
 */
public class CourseControllerImpl implements CourseController{
CourseService courseService = new CourseServiceImpl();
    @Override
    public boolean add(CourseDTO dto) throws Exception {
        Course course =new Course();
            course.setCourseId(dto.getCourseId());
            course.setCourseName(dto.getCourseName());
            course.setDuration(dto.getDuration());
            course.setFee(dto.getFees());
            
            return courseService.addCourse(course);}

    @Override
    public boolean update(CourseDTO dto) throws Exception {
        Course course =new Course();
            course.setCourseId(dto.getCourseId());
            course.setCourseName(dto.getCourseName());
            course.setDuration(dto.getDuration());
            course.setFee(dto.getFees());
            return courseService.updateCourse(course);}

    @Override
    public CourseDTO search(int id) throws Exception {
        Course course =courseService.searchCourse(id);
            CourseDTO coursedto = new CourseDTO();
            coursedto.setCourseId(course.getCourseId());
            coursedto.setCourseName(course.getCourseName());
            coursedto.setDuration(course.getDuration());
            coursedto.setFees(course.getFee());
            return coursedto;}

    @Override
    public boolean delete(int id) throws Exception {
        return courseService.deleteCourse(id);}

    @Override
    public List<CourseDTO> getAll() throws Exception {
        ArrayList<CourseDTO> allcourses = new ArrayList<>();
            List<Course> allcourse = courseService.getAllCourse();
            for (Course course : allcourse) {
                CourseDTO dto = new CourseDTO(course.getCourseId(),course.getCourseName(),course.getDuration(),course.getFee());
                
                allcourses.add(dto);
            }
            return allcourses;}
    
}
