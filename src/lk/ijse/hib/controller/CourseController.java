/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.controller;

import java.util.List;
import lk.ijse.hib.dto.CourseDTO;

/**
 *
 * @author minoli
 */
public interface CourseController {
   public boolean add(CourseDTO dto) throws Exception;
   public boolean update(CourseDTO dto) throws Exception;
   public CourseDTO search(int id) throws Exception;
   public boolean delete(int id) throws Exception;
   public List<CourseDTO> getAll()throws Exception;
}
