package com.example.life_insurance_main.PolicyManager;

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
import java.time.LocalDate;

public class DeactivatePolicyController
{
    @javafx.fxml.FXML
    private Label errorfield;
    @javafx.fxml.FXML
    private TableColumn<CreateNewPolicy, String> nameTable;
    @javafx.fxml.FXML
    private TableColumn <CreateNewPolicy, String>primiumTable;
    @javafx.fxml.FXML
    private TableView <CreateNewPolicy>TableView;
    @javafx.fxml.FXML
    private TableColumn<CreateNewPolicy, String> idtable;
    @javafx.fxml.FXML
    private TableColumn<CreateNewPolicy, String> statustable;
    @javafx.fxml.FXML
    private TableColumn<CreateNewPolicy, LocalDate> datetable;
    private ObservableList<CreateNewPolicy> policies;
    @javafx.fxml.FXML
    private DatePicker todate;
    @javafx.fxml.FXML
    private DatePicker fromdate;


    @javafx.fxml.FXML
    public void initialize() {
        primiumTable.setCellValueFactory(new PropertyValueFactory<>("Premium"));
        nameTable.setCellValueFactory(new PropertyValueFactory<>("name"));
        idtable.setCellValueFactory(new PropertyValueFactory<>("id"));
        statustable.setCellValueFactory(new PropertyValueFactory<>("status"));
        datetable.setCellValueFactory(new PropertyValueFactory<>("date"));


    }

    @javafx.fxml.FXML
    public void handleDeactivatePolicy(ActionEvent actionEvent) {
CreateNewPolicy selected = TableView.getSelectionModel().getSelectedItem();
            if( selected != null){
                selected.setStatus("Deactivate");
                TableView.refresh();

            }else {
                System.out.println("Select a policy to deactivate first.");

            }
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

public void setInfo(ObservableList<CreateNewPolicy> policies){
        this.policies = policies;
    TableView.getItems().setAll(policies);
}
//    @Deprecated
//    public void MainButton(ActionEvent actionEvent) throws IOException {
//        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
//        Parent root = FXMLLoader.load(getClass().getResource("policy_Manager_Dashboard.fxml"));
//        Scene scene = new Scene(root);
//        stage.setTitle("policy_Manager_Dashboard");
//        stage.setScene(scene);
//        stage.show();
//    }

    @javafx.fxml.FXML
    public void backtoCreatePolicy(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("PolicyManager_create_new_Policy.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("PolicyManager_create_new_Policy");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void searchbutton(ActionEvent actionEvent) {
        if (fromdate.getValue() == null){
            errorfield.setText("Please Enter Date from");

        }
        if (todate.getValue() == null){
            errorfield.setText("Please Select last date");
        }
        for (CreateNewPolicy date : policies){
            if(date.getDate().isEqual(fromdate.getValue()) || date.getDate().isAfter(fromdate.getValue()) &&
            date.getDate().isEqual(todate.getValue()) || date.getDate().isBefore(todate.getValue())){
                TableView.getItems().clear();
                TableView.getItems().addAll(policies);
            }
        }
    }
}