package com.example.life_insurance_main.BillingOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class BillingViewPaymentHistoryController
{
    @javafx.fxml.FXML
    private TextField CustomerIdTextField;
    @javafx.fxml.FXML
    private TableColumn<BillingViewPendingPaymentHistory,String> StatusTabelCol;
    @javafx.fxml.FXML
    private TableColumn<BillingViewPendingPaymentHistory,String> IdTabelCol;
    @javafx.fxml.FXML
    private TableColumn<BillingViewPendingPaymentHistory,String> CustomerTabelCol;
    @javafx.fxml.FXML
    private TableColumn<BillingViewPendingPaymentHistory, LocalDate> DateTabelCol;
    @javafx.fxml.FXML
    private TextField PolicyIdTextField;
    @javafx.fxml.FXML
    private TableColumn<BillingViewPendingPaymentHistory,String> PolicyTabelCol;
    @javafx.fxml.FXML
    private TableColumn<BillingViewPendingPaymentHistory,Double> AmountTabelCol;
    @javafx.fxml.FXML
    private TableView<BillingViewPendingPaymentHistory> TableView;
    @javafx.fxml.FXML
    private DatePicker DataRangeDatePicker;

    private ArrayList<BillingViewPendingPaymentHistory> paymentHistory = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        IdTabelCol.setCellValueFactory(new PropertyValueFactory<>("transactionId"));
        CustomerTabelCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        DateTabelCol.setCellValueFactory(new PropertyValueFactory<>("transactionDate"));
        PolicyTabelCol.setCellValueFactory(new PropertyValueFactory<>("policyId"));
        AmountTabelCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        StatusTabelCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        refreshTableView();
    }

    private void refreshTableView() {
        TableView.getItems().clear();
        TableView.getItems().addAll(paymentHistory);
    }



    @javafx.fxml.FXML
    public void BackToHomeHandleButton(ActionEvent actionEvent)throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("BillingOfficerDashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void ExportControlHandleButton(ActionEvent actionEvent) {

    }
}