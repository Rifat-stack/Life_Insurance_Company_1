package com.example.life_insurance_main.BillingOfficer;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;

public class BillingRefundRequestsController
{
    @javafx.fxml.FXML
    private TableColumn<BillingRefundRequest,Double> AmountTabbleCol;
    @javafx.fxml.FXML
    private TableColumn<BillingRefundRequest,String> PolicyIdTabbleCol;
    @javafx.fxml.FXML
    private TextField RefundIdTextField;
    @javafx.fxml.FXML
    private TableColumn<BillingRefundRequest,String> StatusTabbleCol;
    @javafx.fxml.FXML
    private TableColumn<BillingRefundRequest,String> ActionTabbleCol;
    @javafx.fxml.FXML
    private ComboBox <String>ProcessingOptionsComBox;
    @javafx.fxml.FXML
    private TextField CustomerTextField;
    @javafx.fxml.FXML
    private TableColumn<BillingRefundRequest,String> CustomerTabbleCol;
    @javafx.fxml.FXML
    private TableColumn<BillingRefundRequest,String> RefundIdTabbleCol;
    @javafx.fxml.FXML
    private TextField PolicyIdTextField;
    @javafx.fxml.FXML
    private TableColumn<BillingRefundRequest, LocalDate> RequestDateTabbleCol;
    @javafx.fxml.FXML
    private TableView<BillingRefundRequest> TableView;
    @FXML
    private Text errorTextField;

    private ArrayList<BillingRefundRequest> refundRequests = new ArrayList<>();


    @javafx.fxml.FXML
    public void initialize() {

        RefundIdTabbleCol.setCellValueFactory(new PropertyValueFactory<>("refundId"));
        CustomerTabbleCol.setCellValueFactory(new PropertyValueFactory<>("customerId"));
        PolicyIdTabbleCol.setCellValueFactory(new PropertyValueFactory<>("policyId"));
        RequestDateTabbleCol.setCellValueFactory(new PropertyValueFactory<>("requestDate"));
        AmountTabbleCol.setCellValueFactory(new PropertyValueFactory<>("amount"));
        StatusTabbleCol.setCellValueFactory(new PropertyValueFactory<>("status"));

        ProcessingOptionsComBox.getItems().addAll("All Requests", "Pending Only", "Approved Only", "Rejected Only");
        ProcessingOptionsComBox.getSelectionModel().selectFirst();

        refreshTableView();
    }
    private void refreshTableView() {
        TableView.getItems().clear();
        TableView.getItems().addAll(refundRequests);
    }

    @FXML
    public void RejectHandleButton(ActionEvent actionEvent) {
        BillingRefundRequest selectedRequest = TableView.getSelectionModel().getSelectedItem();
        if (selectedRequest == null) {
            showError("Please select a request to reject");
            return;
        }

        selectedRequest.setStatus("Rejected");
        refreshTableView();
        showError("Request rejected successfully");
    }



    @FXML
    public void BackToHomeHandleButton(ActionEvent actionEvent)throws IOException {
        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("BillingOfficerDashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Billing Officer Dashboard");
        stage.setScene(scene);
        stage.show();
    }


    @FXML
    public void ApproveHandleButton(ActionEvent actionEvent) {
        BillingRefundRequest selectedRequest = TableView.getSelectionModel().getSelectedItem();
        if (selectedRequest == null) {
            showError("Please select a request to approve");
            return;
        }

        selectedRequest.setStatus("Approved");
        refreshTableView();
        showError("Request approved successfully");
    }
    private void showError(String message) {
        errorTextField.setText(message);
    }


}
