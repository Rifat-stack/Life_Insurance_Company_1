package com.example.life_insurance_main.BillingOfficer;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.HttpCookie;
import java.time.LocalDate;
import java.time.YearMonth;

public class BillingBillingReportController
{
    @FXML
    private ComboBox<String> ReportTypeComboBox;
    @FXML
    private DatePicker monthYearPicker;

    private BillingBillingReport currentReport;


    @javafx.fxml.FXML
    public void initialize() {
        ObservableList<String> reportTypes = FXCollections.observableArrayList(
                "Monthly Summary",
                "Detailed Transactions",
                "Pending Payments",
                "Late Payments"
        );
        ReportTypeComboBox.setItems(reportTypes);
        ReportTypeComboBox.getSelectionModel().selectFirst();



        monthYearPicker.setValue(LocalDate.now());
    }

    @javafx.fxml.FXML
    public void BackToHomeHandleButton(ActionEvent actionEvent)throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("BillingOfficerDashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Billing Report");
        stage.setScene(scene);
        stage.show();
    }

    public void showAlart(String message) {
        Alert a = new Alert(Alert.AlertType.WARNING);
        a.setContentText("message");
        a.showAndWait();
    }

    @javafx.fxml.FXML
    public void GenerateReportHandleButton(ActionEvent actionEvent) {
        LocalDate selectedDate = monthYearPicker.getValue();
        if (selectedDate == null) {
            showAlart("Please select a month and year.");
            return;
        }

    }
}