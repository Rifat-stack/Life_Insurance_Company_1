package com.example.life_insurance_main.Representative;

import com.example.life_insurance_main.PolicyManager.EditPolicyController;
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
    private TableColumn <SubmitSupport, String> typetable;
    @javafx.fxml.FXML
    private TableColumn <SubmitSupport, String> destable;
    @javafx.fxml.FXML
    private TableView <SubmitSupport> tableview;
    @javafx.fxml.FXML
    private TableColumn  <SubmitSupport, String>idable;
    ArrayList<SubmitSupport> submitSupports = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() throws IOException {
        issueTypeBox.getItems().addAll("Service quality","Response time","Problem resolution");
        typetable.setCellValueFactory(new PropertyValueFactory<>("text"));
        destable.setCellValueFactory(new PropertyValueFactory<>("type"));
        idable.setCellValueFactory(new PropertyValueFactory<>("id"));

        File file = new File("supportTicket.bin");
        if (file.exists()){
            FileInputStream fis = new FileInputStream(file);
            ObjectInputStream ois = new ObjectInputStream(fis);


            try{
                while (true){
                    SubmitSupport submitSupport = (SubmitSupport)ois.readObject();
                    submitSupports.add(submitSupport);
                }
            } catch (EOFException eof) {
                System.out.println("End");

            }catch (ClassNotFoundException cmf){
                System.out.println("not");
            }
            tableview.getItems().addAll(submitSupports);

        }

    }

    @javafx.fxml.FXML
    public void handleSubmitTicket(ActionEvent actionEvent) throws IOException {
        SubmitSupport submitSupport = new SubmitSupport(
                customerIdField.getText(),
                issueTypeBox.getValue().toString(),
                descriptionArea.getText()

        );
        File file = new File("supportTicket.bin");
        ObjectOutputStream oos;
        if (file.exists()){
            FileOutputStream fis = new FileOutputStream(file, true);
            oos = new AppendableObjectOutputStream(fis);
        }else {
            FileOutputStream fis = new FileOutputStream(file, true);
            oos = new ObjectOutputStream(fis);
        }
        oos.writeObject(submitSupport);
        oos.close();
        submitSupports.add(submitSupport);
        tableview.getItems().clear();
        tableview.getItems().addAll(submitSupports);
    }


    @javafx.fxml.FXML
    public void Backbutton(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Representative_Dashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Representative_Dashboard");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void Forwordtopolicymanager(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        FXMLLoader loader =  new FXMLLoader(getClass().getResource("/com/example/life_insurance_main/PolicyManager/PolicyManager_edit_Policy.fxml"));
        Parent root = loader.load();
        EditPolicyController controller = loader.getController();
        controller.setsupport(submitSupports);
        Scene scene = new Scene(root);
        stage.setTitle("PolicyManager_edit_Policy");
        stage.setScene(scene);
        stage.show();
    }
}