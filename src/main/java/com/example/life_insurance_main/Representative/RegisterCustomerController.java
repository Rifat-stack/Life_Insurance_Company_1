package com.example.life_insurance_main.Representative;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;

public class RegisterCustomerController
{
    @javafx.fxml.FXML
    private Label Showmessage;
    @javafx.fxml.FXML
    private TextField nameField;
    @javafx.fxml.FXML
    private TextField customerIdField;
    @javafx.fxml.FXML
    private Label statusLabel;
    @javafx.fxml.FXML
    private TextField phoneField;
    @javafx.fxml.FXML
    private TableColumn <RegisterNewCustomer, String>nametable;
    @javafx.fxml.FXML
    private TableView<RegisterNewCustomer> TavleView;
    @javafx.fxml.FXML
    private TableColumn<RegisterNewCustomer, String> idtable;
    ArrayList<RegisterNewCustomer> registerNewCustomers = new ArrayList<>();
    @javafx.fxml.FXML
    private TextField emailField;
    @javafx.fxml.FXML
    private TableColumn emailtable;
    @javafx.fxml.FXML
    private TextField addressField;
    @javafx.fxml.FXML
    private DatePicker dobPicker;
    @javafx.fxml.FXML
    private ComboBox genderBox;
    @javafx.fxml.FXML
    private RadioButton transeradio;
    @javafx.fxml.FXML
    private TableColumn addresstable;
    @javafx.fxml.FXML
    private TableColumn phonetable;
    @javafx.fxml.FXML
    private RadioButton maleradio;
    @javafx.fxml.FXML
    private TableColumn BirthTable;
    @javafx.fxml.FXML
    private TableColumn gandertable;
    @javafx.fxml.FXML
    private RadioButton femaleradio;

    @javafx.fxml.FXML
    public void initialize() {
        idtable.setCellValueFactory(new PropertyValueFactory<>("id"));
//        numbertable.setCellValueFactory(new PropertyValueFactory<>("phone"));
        nametable.setCellValueFactory(new PropertyValueFactory<>("name"));
    }

    @javafx.fxml.FXML
    public void handleRegister(ActionEvent actionEvent) {
        RegisterNewCustomer info = new RegisterNewCustomer(
                customerIdField.getText(),
                nameField.getText(),
                phoneField.getText()

        );
        registerNewCustomers.add(info);
        TavleView.getItems().clear();
        for (RegisterNewCustomer inf : registerNewCustomers){
            TavleView.getItems().addAll(inf);
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
}