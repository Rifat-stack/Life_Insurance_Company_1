package com.example.life_insurance_main.PolicyManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
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
    private TableColumn  <CreateNewPolicy, LocalDate>ValidateTable;
    @javafx.fxml.FXML
    private TableView<CreateNewPolicy> TableView;
    @javafx.fxml.FXML
    private TableColumn <CreateNewPolicy, Integer>CoverageTable;
//ArrayList<CreateNewPolicy> createNewPolicies = new ArrayList<>();

private ObservableList<CreateNewPolicy> createNewPolicies = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    public void initialize() {
        CoverageTable.setCellValueFactory(new PropertyValueFactory<>("Coverage"));
        ValidateTable.setCellValueFactory(new PropertyValueFactory<>("date"));
        PremiumTable.setCellValueFactory(new PropertyValueFactory<>("Premium"));
        PolicyidTable.setCellValueFactory(new PropertyValueFactory<>("id"));
        PolicyNameTable.setCellValueFactory(new  PropertyValueFactory<>("name"));


    }


    @FXML
    public void SavePolicyButton(ActionEvent actionEvent) {
        if (policyNameField.getText().isEmpty()) {
            ShowMessages.setText("Enter Your Name");
            return;
        }
        if (coverageField.getText().isEmpty()) {
            ShowMessages.setText("Enter Your Coverage Value");
            return;
        }
        if (policyIdField.getText().isEmpty()) {
            ShowMessages.setText("Enter Your ID");
            return;
        }
        if (premiumField.getText().isEmpty()) {
            ShowMessages.setText("Enter Your Premium");
            return;
        }
       if (datepickerfield.getValue() == null){
            ShowMessages.setText("Enter Your Policy Date");
           return;
       }

        try {
             Integer.parseInt(premiumField.getText());
        } catch (NumberFormatException e) {
            ShowMessages.setText("Premium must be a number.");
            return;
        }

        try {
            Integer.parseInt(coverageField.getText());
        } catch (NumberFormatException e) {
            ShowMessages.setText("Coverage must be a number.");
            return;
        }


     for (CreateNewPolicy info: createNewPolicies){
       if(policyIdField.getText().equals(info.getId())){
           ShowMessages.setText("Take a unique ID");
           return;
       }}

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


        policyNameField.clear();
        coverageField.clear();
        policyIdField.clear();
        premiumField.clear();
        datepickerfield.setValue(null);

    }

        @FXML
        public void backButton(ActionEvent actionEvent) throws IOException {
            Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
            Parent root = FXMLLoader.load(getClass().getResource("policy_Manager_Dashboard.fxml"));
            Scene scene = new Scene(root);
            stage.setTitle("policy_Manager_Dashboard");
            stage.setScene(scene);
            stage.show();
        }


    @FXML
    public void deactivepagebutton(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("PolicyManager_deactivate_policy.fxml"));
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = loader.load();
        DeactivatePolicyController controller = loader .getController();
        controller.setInfo(createNewPolicies);
        Scene scene = new Scene(root);
        stage.setTitle("Deactive_Polic");
        stage.setScene(scene);
        stage.show();
    }
}