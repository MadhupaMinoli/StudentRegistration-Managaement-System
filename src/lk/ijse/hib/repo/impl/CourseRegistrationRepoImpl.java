/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.repo.impl;

import java.io.Serializable;
import lk.ijse.hib.configuration.HibernateConfg;
import lk.ijse.hib.core.Registration;
import lk.ijse.hib.repo.CourseRegistrationRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author minoli
 */
public class CourseRegistrationRepoImpl implements CourseRegistrationRepo{
    
    
SessionFactory sessionFactory =HibernateConfg.getSessionFactory();
    @Override
    public boolean register(Registration register) throws Exception {
        Session openSession = sessionFactory.openSession();
        Transaction transaction = openSession.beginTransaction();
        openSession.save(register);
        transaction.commit();
        openSession.close();
    return false;
        
    

    
}}
