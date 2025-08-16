package com.example.life_insurance_main.BillingOfficer;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;

public class BillingViewPendingPaymentsController
{
    @javafx.fxml.FXML
    private TableColumn<BillingViewPendingPayments,Integer> DaysOverdueTabelCol;
    @javafx.fxml.FXML
    private TableColumn<BillingViewPendingPayments,String> CoustomerNameTabelCol;
    @javafx.fxml.FXML
    private TableColumn<BillingViewPendingPayments,String> BillIdTabelCol;
    @javafx.fxml.FXML
    private TableColumn<BillingViewPendingPayments, LocalDate> DueDateTabelCol;
    @javafx.fxml.FXML
    private TableColumn<BillingViewPendingPayments,String> ActionTabelCol;
    @javafx.fxml.FXML
    private TableColumn<BillingViewPendingPayments,String> PolicyIdTabelCol;
    @javafx.fxml.FXML
    private TableView<BillingViewPendingPayments> TabelView;
    @javafx.fxml.FXML
    private TableColumn<BillingViewPendingPayments,Double> AmountTabelCol;
    @javafx.fxml.FXML
    private Label CustomerNameTextField;
    @javafx.fxml.FXML
    private TextField AmountDueTextField;
    @javafx.fxml.FXML
    private TextField TotalPayableTextField;
    @javafx.fxml.FXML
    private TextField BillIdTextField;
    @javafx.fxml.FXML
    private DatePicker DaysOverdueDPicker;
    @javafx.fxml.FXML
    private TextField PolicyIdTextField;
    @javafx.fxml.FXML
    private DatePicker DueDateDPicker;
    @FXML
    private Text errorText;



    private ArrayList<BillingViewPendingPayments> pendingPayments = new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {

        BillIdTabelCol.setCellValueFactory(new PropertyValueFactory<>("billId"));
        CoustomerNameTabelCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        DueDateTabelCol.setCellValueFactory(new PropertyValueFactory<>("dueDate"));
        AmountTabelCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        DaysOverdueTabelCol.setCellValueFactory(new PropertyValueFactory<>("daysOverdue"));
        PolicyIdTabelCol.setCellValueFactory(new PropertyValueFactory<>("policyId"));


        TabelView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                updateDetails(newSelection);
            }
        });

        refreshTableView();
    }

    private void refreshTableView() {
        TabelView.getItems().clear();
        TabelView.getItems().addAll(pendingPayments);
    }

    private void updateDetails(BillingViewPendingPayments payment) {
        BillIdTextField.setText(payment.getBillId());
        CustomerNameTextField.setText(payment.getCustomerName());
        PolicyIdTextField.setText(payment.getPolicyId());
        DueDateDPicker.setValue(payment.getDueDate());
        DaysOverdueDPicker.setValue(LocalDate.now().minusDays(payment.getDaysOverdue()));
        AmountDueTextField.setText(String.format("%.2f", payment.getAmount()));
        TotalPayableTextField.setText(String.format("%.2f", payment.getAmount() * 1.05)); // Adding 5% late fee
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
    public void SendReminderHandleButton(Event event) {
        BillingViewPendingPayments selectedPayment = TabelView.getSelectionModel().getSelectedItem();
        if (selectedPayment == null) {
            errorText.setText("Please select a payment to send reminder.");
            return;
        }

        errorText.setText("Reminder sent for bill: " + selectedPayment.getBillId());
    }

}