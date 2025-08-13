package com.example.life_insurance_main.Representative;

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

public class PolicyGuidanceController
{
    @javafx.fxml.FXML
    private TextField needsField;
    @javafx.fxml.FXML
    private Label policyLabel;
    @javafx.fxml.FXML
    private TableColumn featuresColumn;
    @javafx.fxml.FXML
    private TableColumn policyNameColumn;
    @javafx.fxml.FXML
    private TableView recommendationTable;
    @javafx.fxml.FXML
    private TextField customerIdField;
    @javafx.fxml.FXML
    private TableColumn priceColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleSearch(ActionEvent actionEvent) {
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