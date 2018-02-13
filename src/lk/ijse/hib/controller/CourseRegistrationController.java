/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.controller;

import lk.ijse.hib.dto.CourseRegistrationDTO;

/**
 *
 * @author minoli
 */
public interface CourseRegistrationController {
    public boolean Register(CourseRegistrationDTO registerdto)throws Exception;
}
