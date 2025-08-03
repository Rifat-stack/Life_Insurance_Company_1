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

public class createnewpolicyController
{
    @javafx.fxml.FXML
    private TextField policyNameField;
    @javafx.fxml.FXML
    private Label ShowMessages;
    @javafx.fxml.FXML
    private TextField coverageField;
    @javafx.fxml.FXML
    private TextField policyIdField;
    @javafx.fxml.FXML
    private TextField premiumField;
    @javafx.fxml.FXML
    private DatePicker datepickerfield;
    @javafx.fxml.FXML
    private TableColumn <CreateNewPolicy, String> PolicyNameTable;
    @javafx.fxml.FXML
    private TableColumn <CreateNewPolicy, String> PolicyidTable;
    @javafx.fxml.FXML
    private TableColumn <CreateNewPolicy, Integer>PremiumTable;
    @javafx.fxml.FXML
    private TableColumn  <CreateNewPolicy, Integer>ValidateTable;
    @javafx.fxml.FXML
    private TableView<CreateNewPolicy> TableView;
    @javafx.fxml.FXML
    private TableColumn <CreateNewPolicy, Integer>CoverageTable;
ArrayList<CreateNewPolicy> createNewPolicies = new ArrayList<>();
    @javafx.fxml.FXML
    public void initialize() {
        CoverageTable.setCellValueFactory(new PropertyValueFactory<>("Coverage"));
        ValidateTable.setCellValueFactory(new PropertyValueFactory<>("Validate"));
        PremiumTable.setCellValueFactory(new PropertyValueFactory<>("Premium"));
        PolicyidTable.setCellValueFactory(new PropertyValueFactory<>("id"));
        PolicyNameTable.setCellValueFactory(new  PropertyValueFactory<>("name"));

    }


    @javafx.fxml.FXML
    public void SavePolicyButton(ActionEvent actionEvent) {
        CreateNewPolicy info = new CreateNewPolicy(
                policyNameField.getText(),
                policyIdField.getText(),
                Integer.parseInt(premiumField.getText()),
                Integer.parseInt(coverageField.getText()),
                datepickerfield.getValue()
        );
        createNewPolicies.add(info);
        TableView.getItems().clear();
        for ( CreateNewPolicy inf : createNewPolicies){
            TableView.getItems().addAll(inf);

        }

    }
//
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