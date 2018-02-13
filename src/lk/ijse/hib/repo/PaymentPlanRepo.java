/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.repo;

import java.util.List;
import lk.ijse.hib.core.PaymentPlan;

/**
 *
 * @author minoli
 */
public interface PaymentPlanRepo {
    public boolean add() throws Exception;
     public List<PaymentPlan> getAll() throws Exception;
     public PaymentPlan search(int id) throws Exception;
}
