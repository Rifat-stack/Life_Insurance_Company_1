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
    private TableColumn <RegisterNewCustomer, String>emailtable;
    @javafx.fxml.FXML
    private TextField addressField;
    @javafx.fxml.FXML
    private DatePicker dobPicker;
    @javafx.fxml.FXML
    private RadioButton transeradio;
    @javafx.fxml.FXML
    private TableColumn<RegisterNewCustomer, String> addresstable;
    @javafx.fxml.FXML
    private TableColumn<RegisterNewCustomer, String> phonetable;
    @javafx.fxml.FXML
    private RadioButton maleradio;
    @javafx.fxml.FXML
    private TableColumn<RegisterNewCustomer, String> BirthTable;
    @javafx.fxml.FXML
    private TableColumn <RegisterNewCustomer, String>gandertable;
    @javafx.fxml.FXML
    private RadioButton femaleradio;
    @javafx.fxml.FXML
    private ComboBox genderBox;

    @javafx.fxml.FXML
    public void initialize() {
        ToggleGroup tg1 = new ToggleGroup();
        maleradio.setToggleGroup(tg1);
        femaleradio.setToggleGroup(tg1);
        transeradio.setToggleGroup(tg1);

        idtable.setCellValueFactory(new PropertyValueFactory<>("id"));
       emailtable.setCellValueFactory(new PropertyValueFactory<>("email"));
        nametable.setCellValueFactory(new PropertyValueFactory<>("name"));
        addresstable.setCellValueFactory(new PropertyValueFactory<>("address"));
        phonetable.setCellValueFactory(new PropertyValueFactory<>("phone"));
        BirthTable.setCellValueFactory(new PropertyValueFactory<>("date"));
        gandertable.setCellValueFactory(new PropertyValueFactory<>("gander"));

    }

    @javafx.fxml.FXML
    public void handleRegister(ActionEvent actionEvent) {
        if (nameField.getText().isEmpty()){
            Showmessage.setText("Enter your Name");
            return;
        }
        if (customerIdField.getText().isEmpty()){
            Showmessage.setText("Enter your Id");
            return;
        } if (phoneField.getText().isEmpty()){
            Showmessage.setText("Enter your phone Number");
            return;
        } if (addressField.getText().isEmpty()){
            Showmessage.setText("Enter your address");
            return;
        } if (dobPicker.getValue() == null){
            Showmessage.setText("Enter your Date of Birth");
            return;
        }
        for (RegisterNewCustomer info : registerNewCustomers){
        if(customerIdField.getText().equals(info.getId())){
            Showmessage.setText("Enter a Unique ID");
            return;
        }}
        for (RegisterNewCustomer info : registerNewCustomers){
            if(phoneField.getText().equals(info.getPhone())){
                Showmessage.setText("Enter a Unique Phone Number");
                return;
            }}
        for (RegisterNewCustomer info : registerNewCustomers){
            if(emailField.getText().equals(info.getEmail())){
                Showmessage.setText("Enter a Unique email");
                return;
            }}

        try {
            Integer.parseInt(phoneField.getText());
        } catch (NumberFormatException e) {
            Showmessage.setText("Phone number must be a number.");
            return;
        }
        try {
            Integer.parseInt(customerIdField.getText());
        } catch (NumberFormatException e) {
            Showmessage.setText("ID must be a number.");
            return;
        }




        String gander ="";
        if (maleradio.isSelected()){
            gander = "male";
        } else if (femaleradio.isSelected()) {
            gander = "female";
        }else if (transeradio.isSelected()) {
            gander = "Transgender";
        } else {
            Showmessage.setText("Please select a gender.");
            return;
        }

        RegisterNewCustomer info = new RegisterNewCustomer(
                customerIdField.getText(),
                nameField.getText(),
                phoneField.getText(),
                emailField.getText(),
                gander,
                addressField.getText(),
                dobPicker.getValue()

        );

        registerNewCustomers.add(info);
        TavleView.getItems().clear();
        for (RegisterNewCustomer inf : registerNewCustomers){
            TavleView.getItems().addAll(inf);
        }


        customerIdField.clear();
        nameField.clear();
        phoneField.clear();
        emailField.clear();
        addressField.clear();
        dobPicker.setValue(null);
        maleradio.setSelected(false);
        femaleradio.setSelected(false);
        transeradio.setSelected(false);
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