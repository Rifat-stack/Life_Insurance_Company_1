package com.example.life_insurance_main;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class CustomerDashboard
{
    @javafx.fxml.FXML
    private Label NameLabel;
    @javafx.fxml.FXML
    private Label IdLabel;
    @javafx.fxml.FXML
    private Button PaymentHistoryButton;
    @javafx.fxml.FXML
    private Button SubmitClaimButton;
    @javafx.fxml.FXML
    private Button ApplyForPolicyButton;
    @javafx.fxml.FXML
    private Button SupportButton;
    @javafx.fxml.FXML
    private Button UpdateProfileButton;
    @javafx.fxml.FXML
    private Button PayPremimuButton;
    @javafx.fxml.FXML
    private Button ViewInsurancePolicyButton;
    @javafx.fxml.FXML
    private Button RequestExceptionButton;
    @javafx.fxml.FXML
    private Button SignOutButton;

    private Customer ThisCustomer;

    public void setter(Customer customer) {
        this.ThisCustomer = customer;
        NameLabel.setText(customer.getName());
        IdLabel.setText(customer.getUserId());


    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void PaymentHistroyOnMouseCLick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CustomerDashboard.class.getResource("Customer/CustomerviewpaymentHistory.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Payment History");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void UpdateProfileONMouseCLick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CustomerDashboard.class.getResource("Customer/CustomerUpdateProfile.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Update Profile");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void SignOutOnMouseClick(ActionEvent actionEvent) throws IOException {
        Alert erroralert = new Alert(Alert.AlertType.CONFIRMATION);
        erroralert.setTitle("Sign out?");
        erroralert.setContentText("Do you want to sign out");
        Optional<ButtonType> result = erroralert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK){
            FXMLLoader fxmlLoader = new FXMLLoader(CustomerDashboard.class.getResource("Login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.show();
        }

    }

    @javafx.fxml.FXML
    public void ViewPolicyOnMouseCLick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CustomerDashboard.class.getResource("Customer/CustomerViewPolicy.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("View Policy");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void PayPremiumOnMouseClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CustomerDashboard.class.getResource("Customer/CustomerPayPremium.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Pay Premium");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void ApplyForPolicyOnMouseClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CustomerDashboard.class.getResource("Customer/CustomerApplyForNewPolicy.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Apply For Policy");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void RequestExceptionONMouseClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CustomerDashboard.class.getResource("Customer/CustomerExceptionRequest.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Request Exception");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void SupportOnMouseClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CustomerDashboard.class.getResource("Customer/CustomerSupport.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Support");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void SumbitClaimOnMouseClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CustomerDashboard.class.getResource("Customer/CustomerSubmitClaim.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Submit Claim");
        stage.setScene(scene);
        stage.show();
    }
}