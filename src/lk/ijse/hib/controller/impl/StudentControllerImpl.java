/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.controller.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.hib.configuration.HibernateConfg;
import lk.ijse.hib.controller.StudentController;
import lk.ijse.hib.core.Student;
import lk.ijse.hib.dto.StudentDTO;
import lk.ijse.hib.service.StudentService;
import lk.ijse.hib.service.impl.StudentServiceImpl;


/**
 *
 * @author minoli
 */
public class StudentControllerImpl implements StudentController{
    StudentService studentService = new StudentServiceImpl();
    @Override
    public boolean add(StudentDTO dto) {
        try {
            Student student =new Student();
            student.setStudentId(dto.getStudentId());
            student.setStudentName(dto.getStudentName());
            student.setDateOfBirth(dto.getDateOfBirth());
            
            return studentService.addStudent(student);
        } catch (Exception ex) {
            Logger.getLogger(StudentControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
    }

    @Override
    public boolean update(StudentDTO dto) {
        try {
            Student student =new Student();
            student.setStudentId(dto.getStudentId());
            student.setStudentName(dto.getStudentName());
            student.setDateOfBirth(dto.getDateOfBirth()); studentService.updateStudent(student);
        } catch (Exception ex) {
            Logger.getLogger(StudentControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
 }

    @Override
    public StudentDTO search(int id) {
        try {
            Student student =studentService.searchStudent(id);
            StudentDTO studentdto = new StudentDTO();
            studentdto.setStudentId(student.getStudentId());
            studentdto.setStudentName(student.getStudentName());
            studentdto.setDateOfBirth(student.getDateOfBirth());
            return studentdto;
        } catch (Exception ex) {
            Logger.getLogger(StudentControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
}

    @Override
    public boolean delete(int id) {
        try {
            return studentService.deleteStudent(id);
        } catch (Exception ex) {
            Logger.getLogger(StudentControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
}

    @Override
    public List<StudentDTO> getAll() {
        try {
            ArrayList<StudentDTO> allStudents = new ArrayList<>();
            List<Student> allStudent = studentService.getAllStudent();
            for (Student student : allStudent) {
                StudentDTO dto = new StudentDTO(student.getStudentId(),student.getStudentName(),student.getDateOfBirth());
                
                allStudents.add(dto);
            }
            return allStudents;
        } catch (Exception ex) {
            Logger.getLogger(StudentControllerImpl.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
}
    
}
