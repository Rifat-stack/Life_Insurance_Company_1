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
import java.time.LocalDate;

public class CustomerViewPolicy
{
    @javafx.fxml.FXML
    private TableColumn<Policy, String> PolicyIDCol;
    @javafx.fxml.FXML
    private Label CovarageLabel;
    @javafx.fxml.FXML
    private TableView<Policy> PolicyTable;
    @javafx.fxml.FXML
    private Label TermLabel;
    @javafx.fxml.FXML
    private Label Amount;
    @javafx.fxml.FXML
    private ComboBox POlicyIDCOmbo;
    @javafx.fxml.FXML
    private Label PolicyIDlabel;
    @javafx.fxml.FXML
    private Label renewlStatus;
    @javafx.fxml.FXML
    private TableColumn<Policy, String> PolicyTitleCol;
    @javafx.fxml.FXML
    private Label PremiumRateLabel;

    private ObservableList<Policy> policyList = FXCollections.observableArrayList();
    @javafx.fxml.FXML
    private TableColumn<Policy,String> ExpiryCCol;
    @javafx.fxml.FXML
    private Label ExpiryLabel;


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
            PolicyTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
            ExpiryCCol.setCellValueFactory(new PropertyValueFactory<>("expiryDate"));
            PolicyTable.setItems(policyList);
            for (Policy p : policyList) {
                POlicyIDCOmbo.getItems().add(p.getPolicyId());


        }
    }

}

    @javafx.fxml.FXML
    public void Onactionshowdetails(ActionEvent actionEvent) {
        String selectedID = (String) POlicyIDCOmbo.getValue();
        if (selectedID == null) return;

        for (Policy p : policyList) {
            if (p.getPolicyId().equals(selectedID)) {
                PolicyIDlabel.setText(p.getPolicyId());
                PolicyTitleCol.setText(p.getTitle());
                CovarageLabel.setText(p.getCoverageType());
                TermLabel.setText(String.valueOf(p.getTermYears()));
                Amount.setText(String.valueOf(p.getCoverageAmount()));
                PremiumRateLabel.setText(String.valueOf(p.getPremiumRate()));
                renewlStatus.setText(p.getRenewalStatus());
                ExpiryLabel.setText(p.getExpiryDate().toString());
                break;
            }
        }
    }

    @javafx.fxml.FXML
    public void BackOnAction(ActionEvent actionEvent) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(CustomerDashboard.class.getResource("Customer/CustomerDashboard.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        Stage stage = (Stage)((Node) actionEvent.getSource()).getScene().getWindow();
        stage.setTitle("CustomerDashBoard");
        stage.setScene(scene);
        stage.show();
    }
}