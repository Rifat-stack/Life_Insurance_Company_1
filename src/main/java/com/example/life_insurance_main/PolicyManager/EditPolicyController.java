package com.example.life_insurance_main.PolicyManager;

import com.example.life_insurance_main.Representative.ForwordQuery;
import com.example.life_insurance_main.Representative.SubmitSupport;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.List;

public class EditPolicyController
{
    @javafx.fxml.FXML
    private TableColumn PolicyId1Table;
    @javafx.fxml.FXML
    private TableColumn PolicyId2Table;
    @javafx.fxml.FXML
    private TableColumn PremiumTable;
    @javafx.fxml.FXML
    private TableColumn CoverageTable;
    @javafx.fxml.FXML
    private Label resultLabel;
    @javafx.fxml.FXML
    private TableView TableView1;
    @javafx.fxml.FXML
    private TableColumn quireytable;
    @javafx.fxml.FXML
    private TableView QuireyTable;
    @javafx.fxml.FXML
    private TableColumn <SubmitSupport, String>stypetable;
    @javafx.fxml.FXML
    private TableColumn <SubmitSupport, String>sdestable;
    @javafx.fxml.FXML
    private TableColumn<SubmitSupport, String> sidtable;
    @javafx.fxml.FXML
    private TableView <SubmitSupport>supporttable;

    @javafx.fxml.FXML
    public void initialize() {
        quireytable.setCellValueFactory(new PropertyValueFactory<>("query"));
        PolicyId2Table.setCellValueFactory(new PropertyValueFactory<>("id"));

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

    @Deprecated
    public void handleUpdatePolicy(ActionEvent actionEvent) {
    }

    @Deprecated
    public void handleUpdateSystem(ActionEvent actionEvent) {
    }
public void setQuireytable(List<ForwordQuery> forwordQueries){
        QuireyTable.getItems().setAll(forwordQueries);
}
public void setsupport(List <SubmitSupport> submitSupports){
    supporttable.getItems().setAll(submitSupports);
}



    @javafx.fxml.FXML
    public void quireybackButton(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Representative _Forward_Query.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Representative _Forward_Query");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void supportbackButton(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Representative_Submit_Support_Ticket.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Representative_Submit_Support_Ticket");
        stage.setScene(scene);
        stage.show();
    }
}