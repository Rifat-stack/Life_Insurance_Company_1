package com.example.life_insurance_main.PolicyManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;

import java.io.IOException;

public class GeneratePolicyReportController
{
    @javafx.fxml.FXML
    private TableView reportTable;
    @javafx.fxml.FXML
    private Label summaryLabel;
    @javafx.fxml.FXML
    private TableColumn startDateColumn;
    @javafx.fxml.FXML
    private TableColumn customerNameColumn;
    @javafx.fxml.FXML
    private TableColumn statusColumn;
    @javafx.fxml.FXML
    private TableColumn premiumColumn;
    @javafx.fxml.FXML
    private ComboBox reportTypeBox;
    @javafx.fxml.FXML
    private TableColumn policyIdColumn;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleGenerate(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void Backbutton(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("policy_Manager_Dashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("policy_Manager_Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void handleDownload(ActionEvent actionEvent) {
    }


    @javafx.fxml.FXML
    public void MainButton(ActionEvent actionEvent) {
    }
}