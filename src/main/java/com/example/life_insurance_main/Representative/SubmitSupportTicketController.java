package com.example.life_insurance_main.Representative;

import javafx.event.ActionEvent;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class SubmitSupportTicketController
{
    @javafx.fxml.FXML
    private Label Confirmation_message;
    @javafx.fxml.FXML
    private TextArea descriptionArea;
    @javafx.fxml.FXML
    private Label ticketResultLabel;
    @javafx.fxml.FXML
    private ComboBox issueTypeBox;
    @javafx.fxml.FXML
    private TextField customerIdField;

    @javafx.fxml.FXML
    public void initialize() {
    }

    @javafx.fxml.FXML
    public void handleSubmitTicket(ActionEvent actionEvent) {
    }
}