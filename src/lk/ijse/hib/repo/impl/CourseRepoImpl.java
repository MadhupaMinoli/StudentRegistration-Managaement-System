/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.repo.impl;

import java.io.Serializable;
import java.util.List;
import lk.ijse.hib.configuration.HibernateConfg;
import lk.ijse.hib.core.Course;
import lk.ijse.hib.repo.CourseRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author minoli
 */
public class CourseRepoImpl implements CourseRepo{
    
SessionFactory sessionFactory =HibernateConfg.getSessionFactory();

    @Override
    public boolean add(Course course) throws Exception {
        Session openSession =sessionFactory.openSession();
        Transaction beginTransaction =openSession.beginTransaction();
        Serializable save=openSession.save(course);
        beginTransaction.commit();
        openSession.close();
        return save!= null;}

    @Override
    public boolean update(Course course) throws Exception {
         Session openSession=sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        openSession.update(course);
        beginTransaction.commit();
        openSession.close();
        return true;}

    @Override
    public Course search(int id) throws Exception {
        Session openSession=sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        Course getCourse =  (Course) openSession.get(Course.class, id);
        beginTransaction.commit();
        openSession.close();
        return getCourse;}

    @Override
    public boolean delete(int id) throws Exception {
        Session openSession=sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        openSession.delete(search(id));
        beginTransaction.commit();
        openSession.close();
        return true;}

    @Override
    public List<Course> getAll() throws Exception {
        Session openSession=sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        List<Course> courseList = openSession.createQuery("from Course course").list();
        beginTransaction.commit();
        openSession.close();
        return courseList;}
    
}
