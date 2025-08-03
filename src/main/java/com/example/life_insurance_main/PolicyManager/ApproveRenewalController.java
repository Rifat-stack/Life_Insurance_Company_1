package com.example.life_insurance_main.PolicyManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ApproveRenewalController
{
    @javafx.fxml.FXML
    private TableColumn colExpiryDate;
    @javafx.fxml.FXML
    private TableView renewalTable;
    @javafx.fxml.FXML
    private TableColumn colCustomerName;
    @javafx.fxml.FXML
    private TableColumn colPolicyName;
    @javafx.fxml.FXML
    private ComboBox decisionBox;
    @javafx.fxml.FXML
    private TableColumn colRequestDate;
    @javafx.fxml.FXML
    private TableColumn colRequestId;
    @javafx.fxml.FXML
    private TextField requestIdField;
    @javafx.fxml.FXML
    private Label resultLabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleSubmit(ActionEvent actionEvent) {
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