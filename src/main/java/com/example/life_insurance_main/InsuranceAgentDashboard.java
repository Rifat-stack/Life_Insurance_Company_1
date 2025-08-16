package com.example.life_insurance_main;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

public class InsuranceAgentDashboard
{
    @javafx.fxml.FXML
    private Label NameLabel;
    @javafx.fxml.FXML
    private Label AgentLabel;
    private InsuranceAgent ThisAgent;

    @javafx.fxml.FXML
    public void initialize() {

    }

    public void setter(InsuranceAgent insuranceagent) {
        this.ThisAgent = insuranceagent;
        NameLabel.setText(insuranceagent.getName());
        AgentLabel.setText(insuranceagent.getUserId());

    }

    @javafx.fxml.FXML
    public void PerformanceSummaryOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InsuranceAgent.class.getResource("InsuranceAgent/InsuranceAgentPerformanceSummary.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("PerformanceSummary");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void SignOutONAction(ActionEvent actionEvent) throws IOException {
        Alert erroralert = new Alert(Alert.AlertType.CONFIRMATION);
        erroralert.setTitle("Sign out?");
        erroralert.setContentText("Do you want to sign out");
        Optional<ButtonType> result = erroralert.showAndWait();
        if (result.isPresent() && result.get() == ButtonType.OK) {
            FXMLLoader fxmlLoader = new FXMLLoader(InsuranceAgent.class.getResource("Login.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
            stage.setTitle("Login");
            stage.setScene(scene);
            stage.show();
        }

    }

    @javafx.fxml.FXML
    public void ExpiringPoliciesOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InsuranceAgent.class.getResource("InsuranceAgent/InsuranceAgentMonitorPolicy.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("ExpiringPolicies");
        stage.setScene(scene);
        stage.show();
    }

    @Deprecated
    public void ApplicationStatusOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InsuranceAgent.class.getResource("InsuranceAgent/InsuranceAgentCheckStatusOFApplication.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("ApplicationStatus");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void ExceptionRequestOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InsuranceAgent.class.getResource("InsuranceAgent/InsuranceAgentRequestException.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("ExceptionRequest");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void PolicyListOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InsuranceAgent.class.getResource("InsuranceAgent/InsuranceAgentViewPolicy.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("PolicyList");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void SearchForCustomerOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InsuranceAgent.class.getResource("InsuranceAgent/InsuranceAgentSearchCustomer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("SearchForCustomer");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void RegisterNewCustomerOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InsuranceAgent.class.getResource("InsuranceAgent/InsuranceAgentRegisterCustomer.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("Payment History");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void CommisionEarningsOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(InsuranceAgent.class.getResource("InsuranceAgent/InsuranceAgentViewCommisions.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("CommisionEarnings");
        stage.setScene(scene);
        stage.show();
    }
}