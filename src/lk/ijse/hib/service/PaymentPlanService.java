/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.service;

import java.util.List;
import lk.ijse.hib.core.PaymentPlan;

/**
 *
 * @author minoli
 */
public interface PaymentPlanService {
   public PaymentPlan searchPlan(int id) throws Exception;
    public List<PaymentPlan> getAllplans() throws Exception; 
    public boolean add() throws Exception;
}
