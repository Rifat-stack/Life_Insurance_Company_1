package com.example.life_insurance_main.PolicyManager;

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

public class DefineNewRuleController
{
    @javafx.fxml.FXML
    private TableColumn<DefineNewRule, String> valueColumn;
    @javafx.fxml.FXML
    private ComboBox<String> ruleTypeBox;
    @javafx.fxml.FXML
    private Label confirmationLabel;
    @javafx.fxml.FXML
    private TextField ruleValueField;
    @javafx.fxml.FXML
    private TableColumn <DefineNewRule, String>typeColumn;
    @javafx.fxml.FXML
    private TableView <DefineNewRule>ruleTableView;
    ArrayList<DefineNewRule> defineNewRules = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() {
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        ruleTypeBox.getItems().addAll("Age Condition", "Risky Job", "Family Size Limit");
    }

    @javafx.fxml.FXML
    public void handleSaveRule(ActionEvent actionEvent) {
        DefineNewRule info = new DefineNewRule(
                ruleTypeBox.getValue(),
                ruleValueField.getText()
        );
        defineNewRules.add(info);
        ruleTableView.getItems().clear();
        for(DefineNewRule inf : defineNewRules){
            ruleTableView.getItems().addAll(inf);
        }


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