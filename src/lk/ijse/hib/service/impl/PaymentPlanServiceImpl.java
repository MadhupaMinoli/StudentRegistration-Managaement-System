/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.service.impl;

import java.util.List;
import lk.ijse.hib.core.PaymentPlan;
import lk.ijse.hib.repo.PaymentPlanRepo;
import lk.ijse.hib.repo.impl.PaymentPlanRepoImpl;
import lk.ijse.hib.service.PaymentPlanService;

/**
 *
 * @author minoli
 */
public class PaymentPlanServiceImpl implements PaymentPlanService{
PaymentPlanRepo planRepo =new PaymentPlanRepoImpl();
    @Override
    public List<PaymentPlan> getAllplans() throws Exception {
        return planRepo.getAll();}

    @Override
    public PaymentPlan searchPlan(int id) throws Exception {
        return planRepo.search(id);}

    @Override
    public boolean add() throws Exception {
        return planRepo.add();}
    
}
