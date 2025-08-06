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
    private TableColumn  <AssignUnderwriter, String>appIdColumn;
    @javafx.fxml.FXML
    private ComboBox < String>underwriterBox;
    @javafx.fxml.FXML
    private TableView <AssignUnderwriter>assignmentTable;
    @javafx.fxml.FXML
    private TableColumn <AssignUnderwriter, String>dateColumn;
    @javafx.fxml.FXML
    private TableColumn  <AssignUnderwriter, String>underwriterColumn;
    @javafx.fxml.FXML
    private TextField applicationIdField;
    @javafx.fxml.FXML
    private Label resultLabel;
    ArrayList <AssignUnderwriter> assingUnderwriters = new ArrayList<>();
    @javafx.fxml.FXML
    private DatePicker datepicker;

    @javafx.fxml.FXML
    public void initialize() {
        underwriterBox.getItems().addAll(
                "Financial Underwriter",
                "Senior Underwriter",
                "Junior Underwriter");

        appIdColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
        dateColumn.setCellValueFactory(new PropertyValueFactory<>("localdate"));
        underwriterColumn.setCellValueFactory(new  PropertyValueFactory<>("type"));


    }

    @javafx.fxml.FXML
    public void handleAssign(ActionEvent actionEvent) {
        if (applicationIdField.getText().isEmpty()) {
            resultLabel.setText("Application ID is required.");
            return;
        }

        if (datepicker.getValue() == null) {
            resultLabel.setText(" Please select a date.");
            return;
        }

        if (underwriterBox.getValue() == null) {
            resultLabel.setText("Please select an underwriter.");
            return;
        }

        for (AssignUnderwriter info: assingUnderwriters){
            if(applicationIdField.getText().equals(info.getId())){
                resultLabel.setText("Take a unique ID");
                return;
            }}



       AssignUnderwriter info = new AssignUnderwriter(
                        applicationIdField.getText(),
                        datepicker.getValue(),
                        underwriterBox.getValue()
                );
       assingUnderwriters.add(info);
        assignmentTable.getItems().clear();
        for (AssignUnderwriter inf :assingUnderwriters  ){
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