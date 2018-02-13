/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.service;

import java.util.List;
import lk.ijse.hib.core.Student;

/**
 *
 * @author minoli
 */
public interface StudentService {
   public boolean addStudent(Student student) throws Exception;
    public boolean updateStudent(Student student) throws Exception;
    public Student searchStudent(int id) throws Exception;
    public boolean deleteStudent(int id)throws Exception;
    public List<Student> getAllStudent() throws Exception;
}
