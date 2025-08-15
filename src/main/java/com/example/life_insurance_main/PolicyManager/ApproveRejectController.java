package com.example.life_insurance_main.PolicyManager;

import javafx.collections.FXCollections;
import javafx.collections.ObservableArray;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class ApproveRejectController
{
    @FXML
    private TableView<ApproveandReject> ARInfoTable;
    @FXML
    private TextField applicationIdField;
    @FXML
    private Label statusLabel;
    @FXML
    private TableColumn<ApproveandReject,String> ARNameTable;
    @FXML
    private TableColumn<ApproveandReject,String> id;
    @FXML
    private TableColumn <ApproveandReject,String>ARPolicyNameTable;
    @FXML
    private TableColumn<ApproveandReject,String> ARPrimiumTable;
    @FXML
    private TableColumn <ApproveandReject,String>ARCoverageTable;
    @FXML
    private TableColumn <ApproveandReject,String>statusColumn;
    private ObservableList<ApproveandReject> approbeandrejects;



    @javafx.fxml.FXML
    public void initialize() {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        ARNameTable.setCellValueFactory(new PropertyValueFactory<>("policyHolder"));
        ARPolicyNameTable.setCellValueFactory(new PropertyValueFactory<>("policyName"));
        ARCoverageTable.setCellValueFactory(new PropertyValueFactory<>("coverage"));
        ARPrimiumTable.setCellValueFactory(new PropertyValueFactory<>("premium"));
        statusColumn.setCellValueFactory(new PropertyValueFactory<>("status"));


        approbeandrejects = FXCollections.observableArrayList(
                new ApproveandReject("A001", "John Doe", "Life Cover", "100k", "5000"),
                new ApproveandReject("A002", "Jane Smith", "Health Cover", "50k", "3000"),
                new ApproveandReject("A003", "Alice Brown", "Life Cover", "200k", "8000")
        );

        ARInfoTable.setItems(approbeandrejects);


    }

    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("policy_Manager_Dashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("policy_Manager_Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void handleReject(ActionEvent actionEvent) {
        ApproveandReject select = ARInfoTable.getSelectionModel().getSelectedItem();
        if (select != null){
            select.setStatus("Reject");
            ARInfoTable.refresh();
            statusLabel.setText("Showing all applications.");

        } else {
            statusLabel.setText("Select an application first.");
        }
    }

    @javafx.fxml.FXML
    public void handleApprove(ActionEvent actionEvent) {
        ApproveandReject select = ARInfoTable.getSelectionModel().getSelectedItem();
        if (select != null){
            select.setStatus("Approve");
            ARInfoTable.refresh();
            statusLabel.setText("Showing all applications.");

        } else {
            statusLabel.setText("Select an application first.");
        }
    }

    @javafx.fxml.FXML
    public void Searchbutton(ActionEvent actionEvent) {
        for (ApproveandReject info : approbeandrejects){
            ARInfoTable.getItems().clear();

            if (applicationIdField.getText().equals(info.getId())){
                ARInfoTable.getItems().add(info);


            }
        }
    }


}