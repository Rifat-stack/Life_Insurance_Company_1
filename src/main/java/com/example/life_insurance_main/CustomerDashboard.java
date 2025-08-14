package com.example.life_insurance_main;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;

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

    public static void setter(Customer customer) {

    }

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void PaymentHistroyOnMouseCLick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CustomerDashboard.class.getResource("CustomerviewpaymentHistory.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Payment History");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void UpdateProfileONMouseCLick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CustomerDashboard.class.getResource("CustomerUpdateProfile.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Update Profile");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void SignOutOnMouseClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CustomerDashboard.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Login");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void ViewPolicyOnMouseCLick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CustomerDashboard.class.getResource("CustomerViewPolicy.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("View Policy");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void PayPremiumOnMouseClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CustomerDashboard.class.getResource("CustomerPayPremium.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Pay Premium");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void ApplyForPolicyOnMouseClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CustomerDashboard.class.getResource("CustomerApplyForNewPolicy.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Apply For Policy");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void RequestExceptionONMouseClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CustomerDashboard.class.getResource("CustomerExceptionRequest.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Request Exception");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void SupportOnMouseClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CustomerDashboard.class.getResource("CustomerSupport.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Support");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void SumbitClaimOnMouseClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CustomerDashboard.class.getResource("CustomerSubmitClaim.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Submit Claim");
        stage.setScene(scene);
        stage.show();
    }
}