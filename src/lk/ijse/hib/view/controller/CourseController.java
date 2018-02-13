/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.hib.view.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.util.ArrayList;
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
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hib.controller.impl.CourseControllerImpl;
import lk.ijse.hib.dto.CourseDTO;
import lk.ijse.hib.dto.StudentDTO;
import lk.ijse.hib.view.tblmodel.CourseTM;
import lk.ijse.hib.view.tblmodel.StudentTM;

/**
 * FXML Controller class
 *
 * @author minoli
 */
public class CourseController implements Initializable {

    @FXML
    private JFXButton btnDelete;
    @FXML
    private JFXButton btnAdd;
    @FXML
    private JFXButton btnUpdate;
    @FXML
    private JFXTextField txtCourseId;
    @FXML
    private JFXTextField txtCourseName;
    @FXML
    private JFXTextField txtDuration;
    @FXML
    private TableView<CourseTM> tblCourse;
    @FXML
    private JFXTextField txtFee;
    
    private CourseControllerImpl courseController = new CourseControllerImpl();
    private ObservableList<CourseTM> allcourses;
    private boolean update;
    
    
    
    public boolean loadall(){
    
        try {
            ArrayList<CourseDTO> course=(ArrayList<CourseDTO>) courseController.getAll();
            ArrayList<CourseTM> coursetm=new ArrayList<CourseTM>();
            
            course.forEach((dto) -> {
                coursetm.add(new CourseTM(dto.getCourseId(),dto.getCourseName(),dto.getDuration(),dto.getFees()));
            });
            
            allcourses =FXCollections.observableArrayList(coursetm);
            
            tblCourse.setItems(allcourses);
            return false;
        } catch (Exception ex) {
            Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        return false;
            
    
    
    }
    private void clearAllTextFileds(){
        txtCourseId.setText("");
        txtCourseName.setText("");
    txtDuration.setText("");
    txtFee.setText("");}
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
         tblCourse.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("courseId"));
        tblCourse.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("courseName"));
        tblCourse.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("duration"));
        tblCourse.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("fees"));
        
        
         loadall();
          
            
            tblCourse.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<CourseTM>() {
            @Override
            public void changed(ObservableValue<? extends CourseTM> observable, CourseTM oldValue, CourseTM newValue) {
                CourseTM course = observable.getValue();
                
                if (course == null){
                     update = false;
                    return;
                }
                update = true;
                btnDelete.setDisable(!update);
                txtCourseId.setText(String.valueOf(course.getCourseId()));
                txtCourseName.setText(course.getCourseName());
                txtDuration.setText(course.getDuration());
                txtFee.setText(String.valueOf(course.getFees()));
               
                
            }
            
        });         
            
    }    

    @FXML
    private void btnDeleteMouseClicked(ActionEvent event) {
        try {
            courseController.delete(Integer.parseInt(txtCourseId.getText()));
            loadall();
            clearAllTextFileds();
        } catch (Exception ex) {
            Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnAddMouseClicked(ActionEvent event) {
        try {
            CourseDTO courseDto=new CourseDTO();
            
            courseDto.setCourseName(txtCourseName.getText());
            courseDto.setDuration(txtDuration.getText());
            courseDto.setFees(Double.parseDouble(txtFee.getText()));
            courseController.add(courseDto);
            
            loadall();
            clearAllTextFileds();
        } catch (Exception ex) {
            Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @FXML
    private void btnUpdateMouseClicked(ActionEvent event) {
        try {
            CourseDTO courseDto=new CourseDTO(Integer.parseInt(txtCourseId.getText()),txtCourseName.getText(),txtDuration.getText(),Double.valueOf(txtFee.getText()));
            
            courseController.update(courseDto);
            loadall();
            clearAllTextFileds();
        } catch (Exception ex) {
            Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
        }
}
    
}
