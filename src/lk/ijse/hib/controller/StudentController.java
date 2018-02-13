/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.controller;

import java.util.List;
import lk.ijse.hib.dto.StudentDTO;

/**
 *
 * @author minoli
 */
public interface StudentController {
   public boolean add(StudentDTO dto) throws Exception;
   public boolean update(StudentDTO dto) throws Exception;
   public StudentDTO search(int id) throws Exception;
   public boolean delete(int id) throws Exception;
   public List<StudentDTO> getAll()throws Exception;
}
