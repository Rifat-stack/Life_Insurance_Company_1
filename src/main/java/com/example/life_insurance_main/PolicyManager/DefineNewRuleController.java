package com.example.life_insurance_main.PolicyManager;

import com.example.life_insurance_main.Representative.AppendableObjectOutputStream;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
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
    public void initialize() throws IOException {
        typeColumn.setCellValueFactory(new PropertyValueFactory<>("type"));
        valueColumn.setCellValueFactory(new PropertyValueFactory<>("value"));
        ruleTypeBox.getItems().addAll("Age Condition", "Risky Job", "Family Size Limit");

        File file = new File("DefineRule.bin");
        if (file.exists()){
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);
            try {
                while (true){
                    DefineNewRule defineNewRule = (DefineNewRule)ois.readObject();
                    defineNewRules.add(defineNewRule);
                }
            } catch (IOException e) {
                System.out.println("END");
            } catch (ClassNotFoundException cmf) {
System.out.println("NOT");            }
        }
        ruleTableView.getItems().addAll(defineNewRules);
    }

    @javafx.fxml.FXML
    public void handleSaveRule(ActionEvent actionEvent) throws IOException {

        if(ruleTypeBox.getValue() == null ){
            confirmationLabel.setText("Select a Type");
            return;
        }
        if(ruleValueField.getText().isEmpty() ){
            confirmationLabel.setText("Please Mention your Info in the textfield");
            return;
        }
        if (ruleTypeBox.getValue().equals("Age Condition") || ruleTypeBox.getValue().equals("Family Size Limit")){
            try{Integer.parseInt(ruleValueField.getText());
            }catch (NumberFormatException e){
                confirmationLabel.setText("Value must be an integer for Rule Type box");
                return;
            }

        } /*else if (ruleTypeBox.getValue().equals("Risky Job")) {
            try{Integer.parseInt(String.valueOf(ruleValueField));
            }catch (NumberFormatException e){
                confirmationLabel.setText("Value must be an String for Rule Type box");
                return;
            }
        }*/


        DefineNewRule info = new DefineNewRule(
                ruleTypeBox.getValue(),
                ruleValueField.getText()
        );
        File file = new File("DefineRule.bin");
        ObjectOutputStream oos;
        if (file.exists()){
            FileOutputStream fis = new FileOutputStream(file, true);
            oos = new AppendableObjectOutputStream(fis);
        }else {
            FileOutputStream fis = new FileOutputStream(file, true);
            oos = new ObjectOutputStream(fis);
        }
        oos.writeObject(info);
        oos.close();

        defineNewRules.add(info);
        ruleTableView.getItems().clear();
        for(DefineNewRule inf : defineNewRules){
            ruleTableView.getItems().addAll(inf);
        }
        ruleTypeBox.setValue(null);
        ruleValueField.clear();

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