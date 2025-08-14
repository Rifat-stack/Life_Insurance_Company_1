package com.example.life_insurance_main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.time.LocalDate;

public class LoginController {
    @javafx.fxml.FXML
    private TextField IdTextField;
    @javafx.fxml.FXML
    private TextField PasswordTextField;

    ObservableList<Customer> customerObservableList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() {
        Customer customer1 = new Customer("1111111111", "Rifat", "admin1@gmail.com", "0000000000", "12222");
        customerObservableList.add(customer1);

    }

    @javafx.fxml.FXML
    public void LoginOnAction(ActionEvent actionEvent) throws IOException {
        String id, password;
        boolean flag = true;

        Alert erroralert = new Alert(Alert.AlertType.ERROR);

        id = IdTextField.getText();
        password = PasswordTextField.getText();

        if (id.isBlank()) {
            flag = false;
            erroralert.setTitle("ID Error");
            erroralert.setContentText("User ID can not be blank.");
            erroralert.showAndWait();
        }

        if (password.isBlank()) {
            flag = false;
            erroralert.setTitle("Password Error");
            erroralert.setContentText("Password can not be blank.");
            erroralert.showAndWait();
        }
        if (flag) {
            if (id.length() == 10) {
                for (Customer customer : customerObservableList) {
                    if (customer.login(id, password)) {
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("CustomerDashboard.fxml"));
                        Parent root = fxmlLoader.load();

                        CustomerDashboard customerDashboard = fxmlLoader.getController();
                        CustomerDashboard.setter(customer);

                        Scene scene = new Scene(root);
                        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.setTitle("Customer Dashboard");
                        stage.show();
                        return; // stop after successful login//
                    } else if (id.length() == 8) {
                        //            login as an Insurance Agent
                    } else if (id.length() == 7) {
                        //            login as an UnderWriter
                    } else if (id.length() == 6) {
                        //            login as a Claim Officer
                    } else if (id.length() == 4) {
                        //            login as a policy manager
                    } else if (id.length() == 9) {
                        //            login as a Customer Service representative
                    } else if (id.length() == 5) {
                        //            login as a Billing Officer
                    } else if (id.length() == 3) {
                        //            login as an IT Admin
                    } else {
                        erroralert.setTitle("User ID Error");
                        erroralert.setContentText("User ID type does not exist.");
                        erroralert.showAndWait();
                    }
                }
            }
        }
    }
}