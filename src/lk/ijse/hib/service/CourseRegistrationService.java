/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.service;

import lk.ijse.hib.core.Registration;

/**
 *
 * @author minoli
 */
public interface CourseRegistrationService {
    public boolean register(Registration registration) throws Exception;
}
