/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.repo.impl;

import java.io.Serializable;
import java.util.List;
import lk.ijse.hib.configuration.HibernateConfg;
import lk.ijse.hib.core.Student;
import lk.ijse.hib.repo.StudentRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author minoli
 */
public class StudentRepoImpl implements StudentRepo{
SessionFactory sessionFactory =HibernateConfg.getSessionFactory();
    @Override
    public boolean add(Student student) {
        Session openSession =sessionFactory.openSession();
        Transaction beginTransaction =openSession.beginTransaction();
        Serializable save=openSession.save(student);
        beginTransaction.commit();
        openSession.close();
        return save!= null;
        }

    @Override
    public boolean update(Student student) throws Exception {
        Session openSession=sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        openSession.update(student);
        beginTransaction.commit();
        openSession.close();
        return true;}

    @Override
    public Student search(int id) throws Exception {
        Session openSession=sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        Student getStudent =  (Student) openSession.get(Student.class, id);
        beginTransaction.commit();
        openSession.close();
        return getStudent;}

    @Override
    public boolean delete(int id) throws Exception {
        Session openSession=sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        openSession.delete(search(id));
        beginTransaction.commit();
        openSession.close();
        return true;}

    @Override
    public List<Student> getAll() throws Exception {
        Session openSession=sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        List<Student> studentList = openSession.createQuery("from Student student").list();
        beginTransaction.commit();
        openSession.close();
        return studentList;}
    
}
