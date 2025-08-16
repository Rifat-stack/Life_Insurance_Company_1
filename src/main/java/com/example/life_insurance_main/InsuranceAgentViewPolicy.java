package com.example.life_insurance_main;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.*;

public class InsuranceAgentViewPolicy
{
    @javafx.fxml.FXML
    private TableColumn<Policy,String> PolicyIDCol;
    @javafx.fxml.FXML
    private TableColumn<Policy,String> PolciyTitleCol;
    @javafx.fxml.FXML
    private TableView<Policy> Tableview;
    @javafx.fxml.FXML
    private TableColumn PolcietypeCol;

    private ObservableList<Policy> policyList = FXCollections.observableArrayList();

    @javafx.fxml.FXML
    public void initialize() throws IOException {
        File policyFile = new File("Policy.bin");
        if (!policyFile.exists()) {
            System.out.println("Policy file not found!");
            return;
        }

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(policyFile));
        while (true) {
            try {
                Policy p = (Policy) ois.readObject();
                policyList.add(p);
            } catch (EOFException eof) {
                break;

            } catch (ClassNotFoundException e) {
                throw new RuntimeException(e);
            }
            PolicyIDCol.setCellValueFactory(new PropertyValueFactory<>("policyId"));
            PolciyTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
            Tableview.setItems(policyList);
    }


    }

    @javafx.fxml.FXML
    public void BackONAction(ActionEvent actionEvent) throws IOException {

        FXMLLoader fxmlLoader = new FXMLLoader(CustomerDashboard.class.getResource("InsuranceAgent/InsuranceAgentDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("CustomerDashBoard");
        stage.setScene(scene);
        stage.show();
    }
}