package com.example.life_insurance_main.Representative;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class RepresentativeDashboardController
{
    @javafx.fxml.FXML
    public void initialize() {
    }


    @javafx.fxml.FXML
    public void viewPaymentHistory(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Representative_View_Payment_History.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Representative_View_Payment_History");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void feedback(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Representative_feedback.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Representative_feedback");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void registerNewCustomer(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Representative _Register_New_Customer.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Representative _Register_New_Customer");
        stage.setScene(scene);
        stage.show();
    }


    @javafx.fxml.FXML
    public void providePolicyGuidance(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Representative _Provide_Policy_Guidance.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Representative _Provide_Policy_Guidance");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void checkClaimStatus(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Representative _Check_Claim_Status.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Representative _Check_Claim_Status");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void viewCustomerProfile(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Representative_View_Customer_Profile.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Representative_View_Customer_Profile");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void submitSupportTicket(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Representative_Submit_Support_Ticket.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Representative_Submit_Support_Ticket");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void forwardQuery(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Representative _Forward_Query.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Representative _Forward_Query");
        stage.setScene(scene);
        stage.show();
    }
}