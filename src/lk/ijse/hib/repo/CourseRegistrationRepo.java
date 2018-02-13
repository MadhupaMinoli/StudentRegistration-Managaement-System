/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.repo;

import lk.ijse.hib.core.Registration;

/**
 *
 * @author minoli
 */
public interface CourseRegistrationRepo {
    public boolean register(Registration register) throws Exception;
}
