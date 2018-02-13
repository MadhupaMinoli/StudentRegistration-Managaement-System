/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.service.impl;

import java.util.List;
import lk.ijse.hib.core.Course;
import lk.ijse.hib.repo.CourseRepo;
import lk.ijse.hib.repo.impl.CourseRepoImpl;
import lk.ijse.hib.service.CourseService;

/**
 *
 * @author minoli
 */
public class CourseServiceImpl implements CourseService{
    CourseRepo courseRepo =new CourseRepoImpl();

    @Override
    public boolean addCourse(Course course) throws Exception {
        return courseRepo.add(course);}

    @Override
    public boolean updateCourse(Course course) throws Exception {
        return courseRepo.update(course);}

    @Override
    public Course searchCourse(int id) throws Exception {
        return courseRepo.search(id);}

    @Override
    public boolean deleteCourse(int id) throws Exception {
        return courseRepo.delete(id);}

    @Override
    public List<Course> getAllCourse() throws Exception {
         return courseRepo.getAll();}
    
}
