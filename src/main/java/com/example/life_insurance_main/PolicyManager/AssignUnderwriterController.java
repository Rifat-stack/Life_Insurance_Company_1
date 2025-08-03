package com.example.life_insurance_main.PolicyManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class AssignUnderwriterController
{
    @javafx.fxml.FXML
    private TableColumn  < AssingUnderwriter, String>appIdColumn;
    @javafx.fxml.FXML
    private ComboBox < String>underwriterBox;
    @javafx.fxml.FXML
    private TableView < AssingUnderwriter>assignmentTable;
    @javafx.fxml.FXML
    private TableColumn < AssingUnderwriter, String>dateColumn;
    @javafx.fxml.FXML
    private TableColumn  < AssingUnderwriter, String>underwriterColumn;
    @javafx.fxml.FXML
    private TextField applicationIdField;
    @javafx.fxml.FXML
    private Label resultLabel;
    ArrayList <AssingUnderwriter> assingUnderwriters = new ArrayList<>();
    @javafx.fxml.FXML
    private DatePicker datepicker;

    @javafx.fxml.FXML
    public void initialize() {
        underwriterBox.getItems().addAll("ALL", "Male", "Female", "TransGender");

        appIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("localdate"));
        underwriterColumn.setCellValueFactory(new  PropertyValueFactory<>("type"));


    }

    @javafx.fxml.FXML
    public void handleAssign(ActionEvent actionEvent) {

       AssingUnderwriter info = new AssingUnderwriter(
                        applicationIdField.getText(),
                        datepicker.getValue(),
                        underwriterBox.getValue()
                );
       assingUnderwriters.add(info);
        assignmentTable.getItems().clear();
        for (AssingUnderwriter inf :assingUnderwriters  ){
            assignmentTable.getItems().addAll(inf);
        }


    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("policy_Manager_Dashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("policy_Manager_Dashboard");
        stage.setScene(scene);
        stage.show();
    }


}