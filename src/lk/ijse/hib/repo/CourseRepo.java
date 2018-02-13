/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.repo;

import java.util.List;
import lk.ijse.hib.core.Course;



/**
 *
 * @author minoli
 */
public interface CourseRepo {
    public boolean add(Course course) throws Exception;
    public boolean update(Course course) throws Exception;
    public Course search(int id) throws Exception;
    public boolean delete(int id)throws Exception;
    public List<Course> getAll() throws Exception;
}
