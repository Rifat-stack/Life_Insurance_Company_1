package com.example.life_insurance_main.PolicyManager;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

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
    public void Backbutton(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void handleDownload(ActionEvent actionEvent) {
    }

    @javafx.fxml.FXML
    public void MainButton(ActionEvent actionEvent) {
    }
}