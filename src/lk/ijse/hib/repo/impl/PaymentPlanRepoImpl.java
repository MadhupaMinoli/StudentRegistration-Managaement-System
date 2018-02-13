/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.repo.impl;

import java.util.List;
import lk.ijse.hib.configuration.HibernateConfg;
import lk.ijse.hib.core.PaymentPlan;
import lk.ijse.hib.repo.PaymentPlanRepo;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

/**
 *
 * @author minoli
 */
public class PaymentPlanRepoImpl implements PaymentPlanRepo{

    
SessionFactory sessionFactory =HibernateConfg.getSessionFactory();

    @Override
    public List<PaymentPlan> getAll() throws Exception {
        Session openSession=sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        List<PaymentPlan> planList = openSession.createQuery("from PaymentPlan plan").list();
        beginTransaction.commit();
        openSession.close();
        return planList;
    }

    @Override
    public PaymentPlan search(int id) throws Exception {
       Session openSession=sessionFactory.openSession();
        Transaction beginTransaction = openSession.beginTransaction();
        PaymentPlan getPlan = (PaymentPlan) openSession.get(PaymentPlan.class, id);
        beginTransaction.commit();
        openSession.close();
        return getPlan;}

    @Override
    public boolean add() throws Exception {
        
    SessionFactory sessionFactory=HibernateConfg.getSessionFactory();
    Session openSession=sessionFactory.openSession();
    Transaction beginTransaction =openSession.beginTransaction();
    
    PaymentPlan newPlan1 = new PaymentPlan();
    newPlan1.setPlanId(1);
    newPlan1.setPeriod("3 Months");
    
    PaymentPlan newPlan2 = new PaymentPlan();
    newPlan2.setPlanId(2);
    newPlan2.setPeriod("6 Months");
    
    
    PaymentPlan newPlan3 = new PaymentPlan();
    newPlan3.setPlanId(3);
    newPlan3.setPeriod("12 Months");
    
    openSession.save(newPlan1);
    openSession.save(newPlan2);
    openSession.save(newPlan3);
    
    beginTransaction.commit();
    openSession.close();
    return false;
}
    
}
