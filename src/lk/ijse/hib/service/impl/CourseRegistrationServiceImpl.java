/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.service.impl;

import lk.ijse.hib.core.Registration;
import lk.ijse.hib.repo.CourseRegistrationRepo;
import lk.ijse.hib.repo.impl.CourseRegistrationRepoImpl;
import lk.ijse.hib.service.CourseRegistrationService;

/**
 *
 * @author minoli
 */
public class CourseRegistrationServiceImpl implements CourseRegistrationService{
    CourseRegistrationRepo registerRepo = new CourseRegistrationRepoImpl();
    @Override
    public boolean register(Registration registration) throws Exception {
        return registerRepo.register(registration);}
    
}
