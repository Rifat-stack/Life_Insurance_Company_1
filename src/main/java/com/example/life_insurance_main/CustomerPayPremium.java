package com.example.life_insurance_main;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class CustomerPayPremium
{
    @javafx.fxml.FXML
    private Label IDfiled;
    @javafx.fxml.FXML
    private Label AmountFiled;
    @javafx.fxml.FXML
    private ComboBox policyIdSelCombo;
    @javafx.fxml.FXML
    private TableColumn PolicyIdCol;
    @javafx.fxml.FXML
    private TableColumn LastdatetoPayCol;
    @javafx.fxml.FXML
    private Button SubmitPaymentButton;
    @javafx.fxml.FXML
    private Label AmountshowLabel;
    @javafx.fxml.FXML
    private TableView PayTabelView;
    @javafx.fxml.FXML
    private TableColumn PaymentFreqCol;
    @javafx.fxml.FXML
    private TableColumn DueAmountCol;
    @javafx.fxml.FXML
    private Label PolicyIDShowlabel;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void BackOnMouseClick(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CustomerDashboard.class.getResource("Customer/CustomerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("CustomerDashBoard");
        stage.setScene(scene);
        stage.show();

    }
}