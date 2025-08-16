package com.example.life_insurance_main;

import com.example.life_insurance_main.PolicyManager.PolicyManagerController;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.*;
import java.util.ArrayList;

public class LoginController {
    @javafx.fxml.FXML
    private TextField IdTextField;
    @javafx.fxml.FXML
    private TextField PasswordTextField;


    ArrayList<Customer> customerList = new ArrayList<>();
    ArrayList<InsuranceAgent> insuranceAgentList = new ArrayList<>();
//  ObservableList<PolicyManagerController> policyManagers = FXCollections.observableArrayList();


    @javafx.fxml.FXML
    public void initialize() throws IOException {
        File customerfile = new File("Customer.bin");
        if (!customerfile.exists()){
            return;
        }
        FileInputStream fis = new FileInputStream(customerfile);
        ObjectInputStream ois = new ObjectInputStream(fis);
        try {
            while(true) {
                Customer customer = (Customer) ois.readObject();
                customerList.add(customer);
            }
        }
        catch (EOFException eof){
            System.out.println("s");
        }
        catch (ClassNotFoundException cnf){
            System.out.println("s;");
        }
        File Insurancefile = new File("InsuranceAgent.bin");
        if (!Insurancefile.exists()){
            return;
        }
        FileInputStream file2 = new FileInputStream(Insurancefile);
        ObjectInputStream out2 = new ObjectInputStream(file2);
        try {
            while(true) {
                InsuranceAgent insuranceagent = (InsuranceAgent) out2.readObject();
                insuranceAgentList.add(insuranceagent);
            }
        }
        catch (EOFException eof){
            System.out.println("s");
        }
        catch (ClassNotFoundException cnf){
            System.out.println("s;");
        }

//        PolicyManagerController policy = new PolicyManagerController()
    }

    @javafx.fxml.FXML
    public void LoginOnAction(ActionEvent actionEvent) throws IOException {
        String id, password;
        boolean flag = true;

        Alert erroralert = new Alert(Alert.AlertType.ERROR);

        id = IdTextField.getText();
        password = PasswordTextField.getText();

        if (id.isBlank()) {
            flag = false;
            erroralert.setTitle("ID Error");
            erroralert.setContentText("User ID can not be blank.");
            erroralert.showAndWait();
        }

        if (password.isBlank()) {
            flag = false;
            erroralert.setTitle("Password Error");
            erroralert.setContentText("Password can not be blank.");
            erroralert.showAndWait();
        }
        if (flag) {
            if (id.length() == 10) {
                for (Customer customer : customerList) {
                    if (customer.login(id, password)) {
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Customer/CustomerDashboard.fxml"));
                        Parent root = fxmlLoader.load();
                        CustomerDashboard customerDashboard = fxmlLoader.getController();
                        customerDashboard.setter(customer);

                        Scene scene = new Scene(root);
                        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.setTitle("Customer Dashboard");
                        stage.show();
                        return;
                    }
                }
            }
            else if (id.length() == 8) {
                for (InsuranceAgent insuranceagent : insuranceAgentList) {
                    if (insuranceagent.login(id, password)) {
                        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("InsuranceAgent/InsuranceAgentDashboard.fxml"));
                        Parent root = fxmlLoader.load();
                        InsuranceAgentDashboard insuranceAgentDashboard = fxmlLoader.getController();
                        insuranceAgentDashboard.setter(insuranceagent);

                        Scene scene = new Scene(root);
                        Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                        stage.setScene(scene);
                        stage.setTitle("Insurance Agent Dashboard");
                        stage.show();
                        return;
                    }
                }
            }
            else if (id.length() == 7) {
                //            login as an UnderWriter
            }
            else if (id.length() == 6) {
                //            login as a Claim Officer
            }
            else if (id.length() == 4) {
                if ("user5".equals(PasswordTextField.getText())) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/life_insurance_main/PolicyManager/policy_Manager_Dashboard.fxml"));
                    Scene scene = new Scene(loader.load());
                    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.setTitle("Policy Manager Dashboard");
                    stage.show();
                }else if ("user6".equals(PasswordTextField.getText())) {
                    FXMLLoader loader = new FXMLLoader(getClass().getResource("/com/example/life_insurance_main/Representative/Representative_Dashboard.fxml"));
                    Scene scene = new Scene(loader.load());
                    Stage stage = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
                    stage.setScene(scene);
                    stage.setTitle("Representative Dashboard");
                    stage.show();
                }

            }
            else if (id.length() == 5) {
                //            login as a Billing Officer
            }
            else if (id.length() == 3) {
                //            login as an IT Admin
            }
            else {
                erroralert.setTitle("User ID Error");
                erroralert.setContentText("User ID type does not exist.");
                erroralert.showAndWait();
            }

        }
    }
}
