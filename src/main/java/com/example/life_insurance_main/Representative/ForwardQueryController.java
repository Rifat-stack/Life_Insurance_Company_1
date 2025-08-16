package com.example.life_insurance_main.Representative;

import com.example.life_insurance_main.PolicyManager.EditPolicyController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class ForwardQueryController
{
    @javafx.fxml.FXML
    private TextArea queryField;
    @javafx.fxml.FXML
    private Label confirmationLabel;
    @javafx.fxml.FXML
    private TextField customerIdField;
    ArrayList<ForwordQuery> forwordQueries = new ArrayList<>();
    @javafx.fxml.FXML
    private TableView <ForwordQuery>TableView;
    @javafx.fxml.FXML
    private TableColumn<ForwordQuery, String> idtable;
    @javafx.fxml.FXML
    private TableColumn<ForwordQuery, String> querytable;

    @javafx.fxml.FXML
    public void initialize() throws IOException {
        querytable.setCellValueFactory(new PropertyValueFactory<>("query"));
        idtable.setCellValueFactory(new PropertyValueFactory<>("id"));


        File file = new File("query.bin");
if (file.exists()){
    FileInputStream fis = new FileInputStream(file);
    ObjectInputStream ois = new ObjectInputStream(fis);
    try {
        while (true){
            ForwordQuery forwordQuery = (ForwordQuery) ois.readObject();
            forwordQueries.add(forwordQuery);
        }
    } catch ( EOFException eof) {
        System.out.println("End");
    }catch (ClassNotFoundException cmf){
        System.out.println("not");

    }
    TableView.getItems().addAll(forwordQueries);
}

    }

    @javafx.fxml.FXML
    public void handleForward(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/life_insurance_main/PolicyManager/PolicyManager_edit_Policy.fxml"));
        Parent root = loader.load();
        EditPolicyController controller = loader.getController();
        controller.setQuireytable(forwordQueries);
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("EditPolicyController");
        stage.setScene(scene);
        stage.show();
    }


    @javafx.fxml.FXML
    public void backButton(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Representative_Dashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Representative_Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void AddButton(ActionEvent actionEvent) throws IOException {
        if (customerIdField.getText().isEmpty()){
            confirmationLabel.setText("Enter your ID");
            return;
        }
        if (queryField.getText().isEmpty()){
            confirmationLabel.setText("Enter your query");
            return;
        }


        ForwordQuery info = new ForwordQuery(
                customerIdField.getText(),
                queryField.getText()

        );

        File file = new File("query.bin");
        ObjectOutputStream oos;
        if (file.exists()){
            FileOutputStream fis = new FileOutputStream(file, true);
            oos = new AppendableObjectOutputStream(fis);

        }else{
            FileOutputStream fis = new FileOutputStream(file, true);
            oos = new ObjectOutputStream(fis);

        }
        oos.writeObject(info);
        oos.close();
        forwordQueries.add(info);
        TableView.getItems().clear();
        TableView.getItems().addAll(forwordQueries);
    }
}