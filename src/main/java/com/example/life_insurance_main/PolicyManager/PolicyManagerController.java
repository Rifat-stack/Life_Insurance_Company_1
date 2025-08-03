package com.example.life_insurance_main.PolicyManager;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class PolicyManagerController
{
    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void openCreatePolicy(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("PolicyManager_create_new_Policy.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("New_Policy");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void openApproveReject(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("PolicyManager_approve_reject.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Approve_reject");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void openAssignUnderwriter(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("PolicyManager_assing_underwriter.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Assing_underwriter");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void openGenerateReport(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("PolicyManager_generate_policy.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Generate_policy");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void openEditPolicy(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("PolicyManager_edit_Policy.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Edit_Policy");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void openDefineRule(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("PolicyManager_definenew_rule.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("definenew_rule");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void openDeactivatePolicy(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("PolicyManager_deactivate_policy.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Deactivate_policy");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void openApproveRenewal(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("PolicyManager_approve_renewal.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Approve_renewal");
        stage.setScene(scene);
        stage.show();
    }
}