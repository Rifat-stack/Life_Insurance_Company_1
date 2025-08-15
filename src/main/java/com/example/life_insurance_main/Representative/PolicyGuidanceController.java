package com.example.life_insurance_main.Representative;

import com.example.life_insurance_main.PolicyManager.CreateNewPolicy;
import com.example.life_insurance_main.PolicyManager.createnewpolicyController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class PolicyGuidanceController
{
    @javafx.fxml.FXML
    private Label policyLabel;
    @javafx.fxml.FXML
    private TableColumn <CreateNewPolicy,String>featuresColumn;
    @javafx.fxml.FXML
    private TableColumn<CreateNewPolicy,String> policyNameColumn;
    @javafx.fxml.FXML
    private TableView <CreateNewPolicy>recommendationTable;
    @javafx.fxml.FXML
    private TextField customerIdField;
    @javafx.fxml.FXML
    private TableColumn <CreateNewPolicy,String> priceColumn;
    @javafx.fxml.FXML
    private ComboBox <String> needsbox;

    @javafx.fxml.FXML
    public void initialize() {
        policyNameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));
        priceColumn.setCellValueFactory(new PropertyValueFactory<>("price"));
        featuresColumn.setCellValueFactory(new PropertyValueFactory<>("Premium"));

        for (CreateNewPolicy policy : createnewpolicyController.createNewPolicies){
            needsbox.getItems().addAll(policy.getName());
        }
    }

    @javafx.fxml.FXML
    public void handleSearch(ActionEvent actionEvent) {
        recommendationTable.getItems().clear();
        for(CreateNewPolicy info : createnewpolicyController.createNewPolicies){
            if(customerIdField.getText().equals(info.getId()) ||customerIdField.getText().equals(info.getName()) ){
                recommendationTable.getItems().add(info);
                break;
            }
        }
    }

    @javafx.fxml.FXML
    public void handleBack(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Representative_Dashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Representative_Dashboard");
        stage.setScene(scene);
        stage.show();
    }


}