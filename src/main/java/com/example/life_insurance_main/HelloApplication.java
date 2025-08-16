package com.example.life_insurance_main;

import com.example.life_insurance_main.Representative.AppendableObjectOutputStream;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Login.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Login Page");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) throws IOException {
        File customerfile = new File("Customer.bin");
        FileOutputStream fis;
        ObjectOutputStream oos;
        if (customerfile.exists()) {
            fis = new FileOutputStream(customerfile, true);
            oos = new AppendableObjectOutputStream(fis);
        }
        else {
            fis = new FileOutputStream(customerfile,true);
            oos = new ObjectOutputStream(fis);
        }
        //Customer C1 = new Customer("1111111111","Rifat Abdullah Khan","rifatak2000@gmail.com","01723940222","12345","Ads","Uttara",null,null);
        //Customer C2 = new Customer("2222222222","Arif Hossain","arifh92@gmail.com","01876543210","pass678","Nusrat","Banani",null,null);
        //Customer C3 = new Customer("3333333333","Maliha Rahman","maliha.r23@yahoo.com","01611223344","qwerty99","Fahim","Dhanmondi",null,null);
        //Customer C4 = new Customer("4444444444","Tanvir Ahmed","tanvir.ahmed@outlook.com","01955667788","hello123","Shakila","Mirpur",null,null);
        //Customer C5 = new Customer("5555555555","Samira Karim","samira.karim@mail.com","01599887766","secure01","Rafsan","Gulshan",null,null);
        //oos.writeObject(C1);oos.writeObject(C2);oos.writeObject(C3);oos.writeObject(C4);oos.writeObject(C5);
        oos.close();
        //List<Customer> activeCustomerOF11111111 = new ArrayList<>();
        //activeCustomerOF11111111.add(C1);
        File Insurancefile = new File("InsuranceAgent.bin");
        FileOutputStream file2;
        ObjectOutputStream out2;
        if (Insurancefile.exists()) {
            file2 = new FileOutputStream(Insurancefile, true);
            out2 = new AppendableObjectOutputStream(file2);
        }
        else {
            file2 = new FileOutputStream(Insurancefile, true);
            out2 = new ObjectOutputStream(file2);
        }
        //InsuranceAgent I1 = new InsuranceAgent("11111111",  "Arif Hossain",  "arif.hossain01@gmail.com",  "01711223344",  "pass1234",  "LIC-1001", "Banani, Dhaka",  "North Zone", "5%", 20000,activeCustomerOF11111111);
        //InsuranceAgent I2 = new InsuranceAgent("22222222",  "Maliha Rahman", "maliha.r23@yahoo.com",      "01899887766",  "securePass9","LIC-2034", "Dhanmondi, Dhaka","South Zone","7%", 0, null);
        //InsuranceAgent I3 = new InsuranceAgent("33333333",  "Tanvir Ahmed",  "tanvir.a92@outlook.com",    "01633445577",  "qwerty78",   "LIC-3345", "Mirpur, Dhaka",   "Central Zone","6%", 0, null);
        //InsuranceAgent I4 = new InsuranceAgent("44444444",  "Samira Karim",  "samira.karim@mail.com",     "01944556677",  "helloWorld!","LIC-5566", "Gulshan, Dhaka", "East Zone",  "8%", 0, null);
        //out2.writeObject(I1);out2.writeObject(I2);out2.writeObject(I3);out2.writeObject(I4);
        //out2.close();
        File policyFile = new File("Policy.bin");
        FileOutputStream file3;
        ObjectOutputStream out3;

        if (policyFile.exists()) {
            file3 = new FileOutputStream(policyFile, true);
            out3 = new AppendableObjectOutputStream(file3);
        } else {
            file3 = new FileOutputStream(policyFile, true);
            out3 = new ObjectOutputStream(file3);
        }

        //Policy P1 = new Policy("P001", "Life Cover Basic", "Life", 50000, 10, 5.5, LocalDate.of(2033, 5, 20), "Active");
        //Policy P2 = new Policy("P002", "Health Shield", "Health", 20000, 5, 3.2, LocalDate.of(2029, 11, 15), "Active");
        //Policy P3 = new Policy("P003", "Retirement Plan", "Pension", 100000, 20, 4.0, LocalDate.of(2045, 1, 1), "Active");
        //Policy P4 = new Policy("P004", "Premium Life Cover", "Life", 75000, 15, 6.0, LocalDate.of(2040, 8, 10), "Active");
        //out3.writeObject(P1);out3.writeObject(P2);out3.writeObject(P3);out3.writeObject(P4);

        out3.close();



        launch();
    }





}