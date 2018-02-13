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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import lk.ijse.hib.controller.impl.StudentControllerImpl;
import lk.ijse.hib.dto.StudentDTO;
import lk.ijse.hib.view.tblmodel.StudentTM;

/**
 * FXML Controller class
 *
 * @author minoli
 */
public class StudentRegistrationController implements Initializable {

    @FXML
    private JFXTextField txtStudentId;

    @FXML
    private JFXTextField txtStudentName;

    @FXML
    private JFXTextField txtDOB;

    @FXML
    private JFXButton btnAdd;

    @FXML
    private JFXButton btnDelete;

    @FXML
    private JFXButton btnUpdate;
    private ObservableList<StudentTM> allstudents;
    @FXML
    private TableView<StudentTM> tblStudent;

    StudentControllerImpl studentController =new StudentControllerImpl();
    private boolean update;

    
    public boolean loadall(){
    
    ArrayList<StudentDTO> student=(ArrayList<StudentDTO>) studentController.getAll();
            ArrayList<StudentTM> studenttm=new ArrayList<StudentTM>();
            
            student.forEach((dto) -> {
                studenttm.add(new StudentTM(dto.getStudentId(),dto.getStudentName(),dto.getDateOfBirth()));
            });
            
            allstudents =FXCollections.observableArrayList(studenttm);
            
            tblStudent.setItems(allstudents);
        return false;
            
    
    
    }
    private void clearAllTextFileds(){
        txtStudentId.setText("");
        txtStudentName.setText("");
        txtDOB.setText("");
    }


    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        tblStudent.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("studentId"));
        tblStudent.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("studentName"));
        tblStudent.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("dateOfBirth"));
        
        
         loadall();
          
            
            tblStudent.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<StudentTM>() {
            @Override
            public void changed(ObservableValue<? extends StudentTM> observable, StudentTM oldValue, StudentTM newValue) {
                StudentTM student = observable.getValue();
                
                if (student == null){
                     update = false;
                    return;
                }
                update = true;
                btnDelete.setDisable(!update);
                txtStudentId.setText(String.valueOf(student.getStudentId()));
                txtStudentName.setText(student.getStudentName());
               
                txtDOB.setText(student.getDateOfBirth());
            }
            
        });         
            
        
    }    
    @FXML
    void btnAddMouseClicked(ActionEvent event) {
        StudentDTO studentDto=new StudentDTO();
        
        studentDto.setStudentName(txtStudentName.getText());
        studentDto.setDateOfBirth(txtDOB.getText());
        studentController.add(studentDto);
        
      loadall();
      clearAllTextFileds();
       
    }

    @FXML
    void btnDeleteMouseClicked(ActionEvent event) {
        studentController.delete(Integer.parseInt(txtStudentId.getText()));
        loadall();
        clearAllTextFileds();
        
    }

    @FXML
    void btnUpdateMouseClicked(ActionEvent event) {
        StudentDTO studentDto=new StudentDTO(Integer.parseInt(txtStudentId.getText()),txtStudentName.getText(),txtDOB.getText());
        
        studentController.update(studentDto);
        loadall();
        clearAllTextFileds();

    }
    
}
