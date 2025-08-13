package com.example.life_insurance_main.PolicyManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class DeactivatePolicyController
{
    @javafx.fxml.FXML
    private Label errorfield;
    @javafx.fxml.FXML
    private TableColumn idTable;
    @javafx.fxml.FXML
    private TableColumn nameTable;
    @javafx.fxml.FXML
    private TableColumn primiumTable;
    @javafx.fxml.FXML
    private TableColumn coverageTable;
    @javafx.fxml.FXML
    private TextField policyIdField;
    @javafx.fxml.FXML
    private Label resultLabel;
    @javafx.fxml.FXML
    private TableView TableView;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleDeactivatePolicy(ActionEvent actionEvent) {
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


    @javafx.fxml.FXML
    public void MainButton(ActionEvent actionEvent) {
    }
}