/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.controller.impl;

import lk.ijse.hib.controller.CourseRegistrationController;
import lk.ijse.hib.core.RegisteredId;
import lk.ijse.hib.core.Registration;
import lk.ijse.hib.dto.CourseRegistrationDTO;
import lk.ijse.hib.service.CourseRegistrationService;
import lk.ijse.hib.service.CourseService;
import lk.ijse.hib.service.PaymentPlanService;
import lk.ijse.hib.service.StudentService;
import lk.ijse.hib.service.impl.CourseRegistrationServiceImpl;
import lk.ijse.hib.service.impl.CourseServiceImpl;
import lk.ijse.hib.service.impl.PaymentPlanServiceImpl;
import lk.ijse.hib.service.impl.StudentServiceImpl;

/**
 *
 * @author minoli
 */
public class CourseRegistrationControllerImpl implements CourseRegistrationController{
CourseService courseService =new CourseServiceImpl();
StudentService studentService =new StudentServiceImpl();
PaymentPlanService planService =new PaymentPlanServiceImpl();
CourseRegistrationService registerService = new CourseRegistrationServiceImpl();


    @Override
    public boolean Register(CourseRegistrationDTO registerdto) throws Exception {
        Registration registration = new Registration();
             registration.setCourse(courseService.searchCourse(registerdto.getCourseId()));
             registration.setStudent(studentService.searchStudent(registerdto.getStudentId()));
             registration.setRegisteredDate(registerdto.getRegisteredDate());
             registration.setPaymentPlan(planService.searchPlan(registerdto.getPaymentPlanId()));
              RegisteredId registeredId = new RegisteredId();
                registeredId.setCourseId(registerdto.getCourseId());
                registeredId.setStudentId(registerdto.getStudentId());
             registration.setRegisterId(registeredId);
                
              registerService.register(registration);  
                
                return false;
}
    
}
