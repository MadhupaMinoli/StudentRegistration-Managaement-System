/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.controller.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.hib.controller.PaymentPlanController;
import lk.ijse.hib.core.PaymentPlan;
import lk.ijse.hib.dto.PaymentPlanDTO;
import lk.ijse.hib.service.PaymentPlanService;
import lk.ijse.hib.service.impl.PaymentPlanServiceImpl;

/**
 *
 * @author minoli
 */
public class PaymentPlanControllerImpl implements PaymentPlanController{

    private PaymentPlanService planService=new PaymentPlanServiceImpl();

    @Override
    public List<PaymentPlanDTO> getAll() throws Exception {
        ArrayList<PaymentPlanDTO> allplans = new ArrayList<>();
            List<PaymentPlan> allplan = planService.getAllplans();
            for (PaymentPlan plan : allplan) {
                PaymentPlanDTO dto = new PaymentPlanDTO(plan.getPlanId(),plan.getPeriod());
                
                allplans.add(dto);
            }
            return allplans;}

    @Override
    public PaymentPlanDTO search(int id) throws Exception {
        PaymentPlan plan =planService.searchPlan(id);
            PaymentPlanDTO plandto = new PaymentPlanDTO();
            plandto.setPalnId(plan.getPlanId());
            plandto.setPeriod(plan.getPeriod());
            return plandto;}

    @Override
    public boolean add() throws Exception {
        planService.add();
        return false;
}
    
}
