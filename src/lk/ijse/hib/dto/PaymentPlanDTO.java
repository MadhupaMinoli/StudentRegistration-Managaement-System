/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.dto;

/**
 *
 * @author minoli
 */
public class PaymentPlanDTO {
    private int palnId;
    private String period;

    public PaymentPlanDTO(int palnId, String period) {
        this.palnId = palnId;
        this.period = period;
    }

    
    public PaymentPlanDTO() {
    }

    /**
     * @return the palnId
     */
    public int getPalnId() {
        return palnId;
    }

    /**
     * @param palnId the palnId to set
     */
    public void setPalnId(int palnId) {
        this.palnId = palnId;
    }

    /**
     * @return the period
     */
    public String getPeriod() {
        return period;
    }

    /**
     * @param period the period to set
     */
    public void setPeriod(String period) {
        this.period = period;
    }
}
