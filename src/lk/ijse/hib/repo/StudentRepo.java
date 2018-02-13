/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.repo;

import java.util.List;
import lk.ijse.hib.core.Student;

/**
 *
 * @author minoli
 */
public interface StudentRepo {
    public boolean add(Student student) throws Exception;
    public boolean update(Student student) throws Exception;
    public Student search(int id) throws Exception;
    public boolean delete(int id)throws Exception;
    public List<Student> getAll() throws Exception;
}
