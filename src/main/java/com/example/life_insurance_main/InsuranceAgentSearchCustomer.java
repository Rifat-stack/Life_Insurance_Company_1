package com.example.life_insurance_main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;

public class InsuranceAgentSearchCustomer
{
    @javafx.fxml.FXML
    private Label NameLabel;
    @javafx.fxml.FXML
    private Label PhoneLabel;
    @javafx.fxml.FXML
    private Label IdLabel;
    @javafx.fxml.FXML
    private TableColumn<Customer, String> IDtableCol;
    @javafx.fxml.FXML
    private Label AddressLabel;
    @javafx.fxml.FXML
    private ComboBox<String> findIDCombo;
    @javafx.fxml.FXML
    private TableColumn<Customer, String> CustomernameCol;
    @javafx.fxml.FXML
    private Label NomineneLabel;
    @javafx.fxml.FXML
    private Label EmailLabel;
    @javafx.fxml.FXML
    private TableView<Customer> CusView;

    private ObservableList<Customer> customerList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() throws IOException {
        IDtableCol.setCellValueFactory(new PropertyValueFactory<>("userId"));
        CustomernameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        File customerFile = new File("Customer.bin");
        if (!customerFile.exists()) {
            System.out.println("No customer file found!");
            return;
        }

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(customerFile));

        try {
            while (true) {
                Customer c = (Customer) ois.readObject();
                customerList.add(c);
                findIDCombo.getItems().add(c.getUserId());
            }
        } catch (IOException | ClassNotFoundException e) {
        }

        ois.close();
        CusView.setItems(customerList);


    }

    @javafx.fxml.FXML
    public void FindONAction(ActionEvent actionEvent) throws IOException {
        String selectedID = (String) findIDCombo.getValue();
        if (selectedID == null) {
            return;
        }
            File customerFile = new File("Customer.bin");
            if (!customerFile.exists()) {
                return;
            }

            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(customerFile));

            try {
                while (true) {
                    Customer c = (Customer) ois.readObject();

                    if (c.getUserId().equals(selectedID)) {
                        IdLabel.setText(c.getUserId());
                        NameLabel.setText(c.getName());
                        EmailLabel.setText(c.getEmail());
                        PhoneLabel.setText(c.getPhone());
                        AddressLabel.setText(c.getAddress());
                        NomineneLabel.setText(c.getNomineeName());
                        break;
                    }
                }
            } catch (EOFException | ClassNotFoundException e) {

            }

            ois.close();

        }

    @javafx.fxml.FXML
    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CustomerDashboard.class.getResource("InsuranceAgent/InsuranceAgentDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("CustomerDashBoard");
        stage.setScene(scene);
        stage.show();
    }
}