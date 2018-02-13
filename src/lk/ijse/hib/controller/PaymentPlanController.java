/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.controller;

import java.util.List;
import lk.ijse.hib.dto.PaymentPlanDTO;

/**
 *
 * @author minoli
 */
public interface PaymentPlanController {
    
   public PaymentPlanDTO search(int id) throws Exception;
   public List<PaymentPlanDTO> getAll()throws Exception;
   public boolean add() throws Exception;
}
