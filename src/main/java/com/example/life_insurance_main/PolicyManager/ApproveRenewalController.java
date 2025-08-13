package com.example.life_insurance_main.PolicyManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;

public class ApproveRenewalController
{
    @javafx.fxml.FXML
    private TableView<ApproveRenewal> renewalTable;
    @javafx.fxml.FXML
    private TableColumn <ApproveRenewal, String>colCustomerName;
    @javafx.fxml.FXML
    private ComboBox<String> decisionBox;
    @javafx.fxml.FXML
    private TableColumn <ApproveRenewal, String>colRequestId;
    @javafx.fxml.FXML
    private Label resultLabel;
    private ObservableList<ApproveRenewal>approveRenewals;
    @javafx.fxml.FXML
    private TableColumn <ApproveRenewal, String> datetable;
    @javafx.fxml.FXML
    private TableColumn <ApproveRenewal, String>policynametable;
    @javafx.fxml.FXML
    private TableColumn<ApproveRenewal, String> reqtable;

    @javafx.fxml.FXML
    public void initialize() {
        datetable.setCellValueFactory(new PropertyValueFactory<>("date"));
        colCustomerName.setCellValueFactory(new PropertyValueFactory<>("name"));
        policynametable.setCellValueFactory(new PropertyValueFactory<>("policyname"));
        reqtable.setCellValueFactory(new PropertyValueFactory<>("req"));
        colRequestId.setCellValueFactory(new PropertyValueFactory<>("id"));

approveRenewals= FXCollections.observableArrayList(
        new ApproveRenewal("R001", "John Doe", "2025-09-15", "Life Secure", "Renewal Request"),
        new ApproveRenewal("R002", "Alice Smith", "2025-10-01", "Health Protect", "Renewal Request"),
        new ApproveRenewal("R003", "Bob Johnson", "2025-11-12", "Wealth Builder", "Renewal Request"),
        new ApproveRenewal("R004", "Carol White", "2025-12-05", "Health Protect", "Renewal Request"),
        new ApproveRenewal("R005", "John", "025-09-25", "Life Secure", "Renewal Request")

);
        renewalTable.getItems().addAll(approveRenewals);
        decisionBox.setItems(FXCollections.observableArrayList("Approve", "Reject", "Pending"));
    }

    @javafx.fxml.FXML
    public void handleSubmit(ActionEvent actionEvent) {
        ApproveRenewal selected = renewalTable.getSelectionModel().getSelectedItem();
       if(selected != null){ selected.setReq(decisionBox.getValue());  // update the request/decision field
        renewalTable.refresh();
    }else{
        resultLabel.setText("Please select a row and a decision first.");
    }}

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("policy_Manager_Dashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("policy_Manager_Dashboard");
        stage.setScene(scene);
        stage.show();
    }


}