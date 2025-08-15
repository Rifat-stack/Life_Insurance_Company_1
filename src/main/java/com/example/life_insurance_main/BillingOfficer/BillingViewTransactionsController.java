package com.example.life_insurance_main.BillingOfficer;

import javafx.event.ActionEvent;
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
import java.util.ArrayList;

public class BillingViewTransactionsController {
    @javafx.fxml.FXML
    private TableColumn<BillingViewTransactions, String> TransIdTabelCol;
    @javafx.fxml.FXML
    private TableColumn<BillingViewTransactions, String> NameTabelCol;
    @javafx.fxml.FXML
    private TableColumn<BillingViewTransactions, LocalDate> DateTabelCol;
    @javafx.fxml.FXML
    private Button SaveHandleButton;
    @javafx.fxml.FXML
    private DatePicker DateDPicker;
    @javafx.fxml.FXML
    private TableColumn<BillingViewTransactions, String> PolicyIdTabelCol;
    @javafx.fxml.FXML
    private TableColumn<BillingViewTransactions, Double> AmountTabelCol;
    @javafx.fxml.FXML
    private TextField NmaeTextField;
    @javafx.fxml.FXML
    private TextField AmountTextField;
    @javafx.fxml.FXML
    private TableColumn<BillingViewTransactions, String> StatusTabelCol;
    @javafx.fxml.FXML
    private ComboBox<String> PaymentMethodComboBox;
    @javafx.fxml.FXML
    private TextField TransIdTextField;
    @javafx.fxml.FXML
    private TextField PolicyIdTextField;
    @javafx.fxml.FXML
    private TableView<BillingViewTransactions> TabelView;
    @javafx.fxml.FXML
    private TableColumn<BillingViewTransactions, String> ViewDetailsTabelCol;
    @FXML
    private Text errorText;

    private ArrayList<BillingViewTransactions> transactions = new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {

        TransIdTabelCol.setCellValueFactory(new PropertyValueFactory<>("transactionId"));
        NameTabelCol.setCellValueFactory(new PropertyValueFactory<>("customerName"));
        DateTabelCol.setCellValueFactory(new PropertyValueFactory<>("date"));
        PolicyIdTabelCol.setCellValueFactory(new PropertyValueFactory<>("policyId"));
        AmountTabelCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        StatusTabelCol.setCellValueFactory(new PropertyValueFactory<>("status"));
        ViewDetailsTabelCol.setCellValueFactory(new PropertyValueFactory<>("paymentMethod"));

        PaymentMethodComboBox.getItems().addAll("Credit Card", "Debit Card", "Bank Transfer", "Cash", "Check");

        TabelView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                updateDetails(newSelection);
            }
        });

        refreshTableView();
    }

    private void refreshTableView() {
        TabelView.getItems().clear();
        TabelView.getItems().addAll(transactions);
    }

    private void updateDetails(BillingViewTransactions transaction) {
        TransIdTextField.setText(transaction.getTransactionId());
        DateDPicker.setValue(transaction.getDate());
        AmountTextField.setText(String.format("%.2f", transaction.getAmount()));
        PolicyIdTextField.setText(transaction.getPolicyId());
        NmaeTextField.setText(transaction.getCustomerName());
        PaymentMethodComboBox.setValue(transaction.getPaymentMethod());
    }


    @javafx.fxml.FXML
    public void BackToHomeHandleButton(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("BillingOfficerDashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Hello!");
        stage.setScene(scene);
        stage.show();
    }


    @javafx.fxml.FXML
    public void SaveHandleButton(ActionEvent actionEvent) {
        BillingViewTransactions selectedTransaction = TabelView.getSelectionModel().getSelectedItem();
        if (selectedTransaction == null) {
            errorText.setText("Please select a transaction to save.");
            return;
        }

        try {
            // Validate and update the selected transaction
            selectedTransaction.setDate(DateDPicker.getValue());
            selectedTransaction.setAmount(Double.parseDouble(AmountTextField.getText()));
            selectedTransaction.setPolicyId(PolicyIdTextField.getText());
            selectedTransaction.setCustomerName(NmaeTextField.getText());
            selectedTransaction.setPaymentMethod(PaymentMethodComboBox.getValue());

            refreshTableView();
            errorText.setText("Transaction updated successfully.");
        } catch (NumberFormatException e) {
            errorText.setText("Invalid amount format.");
        } catch (Exception e) {
            errorText.setText("Error updating transaction.");
        }
    }
}



