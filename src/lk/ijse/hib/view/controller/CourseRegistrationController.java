/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import lk.ijse.hib.controller.impl.CourseControllerImpl;
import lk.ijse.hib.controller.impl.CourseRegistrationControllerImpl;
import lk.ijse.hib.controller.impl.PaymentPlanControllerImpl;
import lk.ijse.hib.controller.impl.StudentControllerImpl;
import lk.ijse.hib.dto.CourseDTO;
import lk.ijse.hib.dto.CourseRegistrationDTO;
import lk.ijse.hib.dto.PaymentPlanDTO;
import lk.ijse.hib.dto.StudentDTO;
import lk.ijse.hib.view.tblmodel.RegisteredCourseTM;

/**
 * FXML Controller class
 *
 * @author minoli
 */



public class CourseRegistrationController implements Initializable {
private final CourseControllerImpl courseController;
private final StudentControllerImpl studentController;
private final CourseRegistrationControllerImpl courseRegistrationcController;
private final ArrayList<StudentDTO> studentList;
    private final ArrayList<CourseDTO> courseList;
 
    @FXML
    private JFXComboBox<Integer> cmbStudentId;
    @FXML
    private JFXComboBox<Integer> cmbCourseId;
    @FXML
    private JFXTextField txtStudentName;
    @FXML
    private JFXTextField txtCourseName;
    @FXML
    private TableView<RegisteredCourseTM> tblCourseRegistration;
    @FXML
    private JFXTextField txtFees;
    @FXML
    private JFXTextField txtDuration;
    @FXML
    private Button btnRegister;
    private ObservableList<RegisteredCourseTM> registerDetails;
   private boolean update;
    private final PaymentPlanControllerImpl planController;
    private final ArrayList<PaymentPlanDTO> planList;
    @FXML
    private JFXComboBox<Integer> cmbPlan;
    @FXML
    private JFXTextField txtPeriod;
    @FXML
    private DatePicker txtRegistedDate;
    @FXML
    private JFXButton btnAddPlan;
    public CourseRegistrationController() throws Exception {
        
  
   
        courseController  = new CourseControllerImpl();
        studentController = new StudentControllerImpl();
        planController =new PaymentPlanControllerImpl();
        courseRegistrationcController=new CourseRegistrationControllerImpl();
        
        
        studentList=(ArrayList<StudentDTO> )studentController.getAll();
        courseList=(ArrayList<CourseDTO>) courseController.getAll();
        planList=(ArrayList<PaymentPlanDTO>) planController.getAll();
        
        
    
    }
    
     
       
   
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
  
        
       tblCourseRegistration.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("courseId"));
        tblCourseRegistration.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("courseName"));
        tblCourseRegistration.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("courseDuration"));
        tblCourseRegistration.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("paymentPlan"));
        tblCourseRegistration.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("registeredDate"));
       
        registerDetails = FXCollections.observableArrayList();
        tblCourseRegistration.setItems(registerDetails);
        
        registerDetails=tblCourseRegistration.getItems();
                
        for (StudentDTO student : studentList) {
            cmbStudentId.getItems().add(student.getStudentId());
        }
        
        for (CourseDTO course : courseList) {
            cmbCourseId.getItems().add(course.getCourseId());
        }
        for (PaymentPlanDTO plan :planList) {
            cmbPlan.getItems().add(plan.getPalnId());
        }
        
        cmbCourseId.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
                
              
           try {
               int courseID = observable.getValue();
               if (courseID == 0) {
                   txtCourseName.setText("");
                   txtDuration.setText("");
                   txtFees.setText("");
                   return;
               }
               CourseDTO course = courseController.search(courseID);
               txtCourseName.setText(course.getCourseName());
               txtFees.setText(String.valueOf(course.getFees()));
               txtDuration.setText(course.getDuration());
           } catch (Exception ex) {
               Logger.getLogger(CourseRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
           }
               
                    
                 });
        cmbStudentId.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>() {
           

            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                
                int studentId = observable.getValue();

                if (studentId == 0) {
                    txtStudentName.setText("");
                    return;
                }
                    StudentDTO student = studentController.search(studentId);
                    txtStudentName.setText(student.getStudentName());
                    
            }   
          
            
        });
        cmbPlan.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<Integer>() {
           

            @Override
            public void changed(ObservableValue<? extends Integer> observable, Integer oldValue, Integer newValue) {
                
                try {
                    int planId = observable.getValue();
                    
                    if (planId == 0) {
                        txtPeriod.setText("");
                        return;
                    }
                    PaymentPlanDTO plan = planController.search(planId);
                    txtPeriod.setText(plan.getPeriod());
                } catch (Exception ex) {
                    Logger.getLogger(CourseRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
                }
                    
            }   
          
            
        });
        
  
   
        
        
    }    

    @FXML
    private void btnRegisterMouseClicked(ActionEvent event) {
    try {
        int courseId = cmbCourseId.getSelectionModel().getSelectedItem();
        
        
        RegisteredCourseTM registerDetail = new RegisteredCourseTM(
                courseId,
                txtCourseName.getText(),
                txtDuration.getText(),
                txtPeriod.getText(),
                txtRegistedDate.getEditor().getText());
        
        registerDetails.add(registerDetail);
        tblCourseRegistration.setItems(registerDetails);
        
        CourseRegistrationDTO registerdto=new CourseRegistrationDTO(cmbStudentId.getSelectionModel().getSelectedItem(),cmbCourseId.getSelectionModel().getSelectedItem(),txtRegistedDate.getEditor().getText(),cmbPlan.getSelectionModel().getSelectedItem());
        
        
        courseRegistrationcController.Register(registerdto);
        
        cmbCourseId.getSelectionModel().clearSelection();
        cmbCourseId.requestFocus();
    } catch (Exception ex) {
        Logger.getLogger(CourseRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
    }
            
            
            
            
        
    }

    @FXML
    private void btnAddPlans(ActionEvent event) {
       
    try {
        planController.add();
    } catch (Exception ex) {
        Logger.getLogger(CourseRegistrationController.class.getName()).log(Level.SEVERE, null, ex);
    }
    }
    
}
