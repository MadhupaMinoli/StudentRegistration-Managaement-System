/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.service.impl;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.hib.core.Student;
import lk.ijse.hib.repo.StudentRepo;
import lk.ijse.hib.repo.impl.StudentRepoImpl;
import lk.ijse.hib.service.StudentService;

/**
 *
 * @author minoli
 */
public class StudentServiceImpl implements StudentService{
 StudentRepo studentRepo = new StudentRepoImpl();
    @Override
    public boolean addStudent(Student student) {
     try {
         return studentRepo.add(student);
     } catch (Exception ex) {
         Logger.getLogger(StudentServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
     }
     return false;
        }

    @Override
    public boolean updateStudent(Student student) throws Exception {
       return studentRepo.update(student); }

    @Override
    public Student searchStudent(int id) throws Exception {
        return studentRepo.search(id);}

    @Override
    public boolean deleteStudent(int id) throws Exception {
        return studentRepo.delete(id);}

    @Override
    public List<Student> getAllStudent() throws Exception {
        return studentRepo.getAll();}
    
}
