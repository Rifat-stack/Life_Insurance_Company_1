package com.example.life_insurance_main;

import com.example.life_insurance_main.Representative.AppendableObjectOutputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class InsuranceAgentRegisterCustomer
{
    @javafx.fxml.FXML
    private TextField AddressText;
    @javafx.fxml.FXML
    private TextField PasswordText;
    @javafx.fxml.FXML
    private TextField NumberText;
    @javafx.fxml.FXML
    private TextField Emailtext;
    @javafx.fxml.FXML
    private TextField nameText;
    @javafx.fxml.FXML
    private Button RegButton;
    @javafx.fxml.FXML
    private TextField NomineeText;
    @javafx.fxml.FXML
    private TextField IDText;
    @javafx.fxml.FXML
    private Label natificationlabel;

    @javafx.fxml.FXML
    public void initialize() {

    }

    @javafx.fxml.FXML
    public void RegButtonOnAction(ActionEvent actionEvent) throws IOException {
        if (IDText.getText().isEmpty() ||
                nameText.getText().isEmpty() ||
                AddressText.getText().isEmpty() ||
                PasswordText.getText().isEmpty() ||
                NumberText.getText().isEmpty() ||
                Emailtext.getText().isEmpty() ||
                NomineeText.getText().isEmpty()){
            ;natificationlabel.setText("Error trying to register");

            return;
        }
        String id = IDText.getText();
        String name = nameText.getText();
        String email = Emailtext.getText();
        String phone = NumberText.getText();
        String password = PasswordText.getText();
        String nominee = NomineeText.getText();
        String address = AddressText.getText();
        Customer newCustomer = new Customer(id, name, email, phone, password, nominee, address,null,null);
        File customerFile = new File("Customer.bin");
        FileOutputStream fis;
        ObjectOutputStream oos;

        if (customerFile.exists()) {
            fis = new FileOutputStream(customerFile, true);
            oos = new AppendableObjectOutputStream(fis);
        } else {
            fis = new FileOutputStream(customerFile);
            oos = new ObjectOutputStream(fis);
        }
        oos.writeObject(newCustomer);
        oos.close();



    }

    @javafx.fxml.FXML
    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CustomerDashboard.class.getResource("InsuranceAgent/InsuranceAgentDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("CustomerDashBoard");
        stage.setScene(scene);
        stage.show();
    }
}