package com.example.life_insurance_main.Representative;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import javax.imageio.IIOParam;
import java.io.*;
import java.util.ArrayList;

public class FeedbackController
{
    @javafx.fxml.FXML
    private TextArea feedbackInputArea;
    @javafx.fxml.FXML
    private Label confirmationLabel;
    @javafx.fxml.FXML
    private ComboBox <String> feedbackTypeBox;
    @javafx.fxml.FXML
    private TextField customerIdField;
    @javafx.fxml.FXML
    private TableColumn <Feedback, String>FeedBackTable;
    @javafx.fxml.FXML
    private TableColumn<Feedback, String> IDTable;
    @javafx.fxml.FXML
    private TableView<Feedback> TableView;
    @javafx.fxml.FXML
    private TableColumn<Feedback, String> FeedBackTypeTable;
    ArrayList<Feedback>feedbacks = new ArrayList<>();

    @javafx.fxml.FXML
    public void initialize() throws IOException {
        feedbackTypeBox.getItems().addAll("Service quality","Response time","Problem resolution");
        FeedBackTable.setCellValueFactory(new PropertyValueFactory<>("feedback"));
        IDTable.setCellValueFactory(new PropertyValueFactory<>("id"));
        FeedBackTypeTable.setCellValueFactory(new PropertyValueFactory<>("type"));


       File file = new File("feedback.bin");
       if (file.exists()) {

           FileInputStream fis = new FileInputStream(file);
           ObjectInputStream ois = new ObjectInputStream(fis);
           try {
               while(true) {
                   Feedback feedback = (Feedback)ois.readObject();
                   feedbacks.add(feedback);
               }
           } catch (EOFException eof) {
               System.out.println("end");
           } catch (ClassNotFoundException cmf) {
               System.out.println("not");
           }
           TableView.getItems().addAll(feedbacks);
       }

     }


    @javafx.fxml.FXML
    public void handleSubmitFeedback(ActionEvent actionEvent) throws IOException {
        if (customerIdField.getText().isEmpty()){
            confirmationLabel.setText("Enter your ID");
            return;
        }
        if (feedbackTypeBox.getValue() == null){
            confirmationLabel.setText("Enter your Type");
            return;
        }
        if (feedbackInputArea.getText().isEmpty()){
            confirmationLabel.setText("Enter your Feedback");
            return;
        }

        Feedback info = new Feedback(
                customerIdField.getText(),
                feedbackTypeBox.getValue().toString(),
                feedbackInputArea.getText()


        );

        File file = new File("feedback.bin");
//        FileOutputStream fis ;
        ObjectOutputStream oos;
        if(file.exists()){
            FileOutputStream fis = new FileOutputStream(file, true);
            oos = new AppendableObjectOutputStream(fis);
        }else {
            FileOutputStream fis = new FileOutputStream(file, true);
            oos = new ObjectOutputStream(fis);
        }

        oos.writeObject(info);
        oos.close();
        feedbacks.add(info);
        TableView.getItems().clear();
        TableView.getItems().addAll(feedbacks);


    }

    @javafx.fxml.FXML
    public void BackButton(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Parent root = FXMLLoader.load(getClass().getResource("Representative_Dashboard.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Representative_Dashboard");
        stage.setScene(scene);
        stage.show();

    }

    @javafx.fxml.FXML
    public void handleSubmitFeedbackList(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("Representative_feedbackList.fxml"));
        Parent root = loader.load();
        FeedbackListController controller = loader.getController();
        controller.setTableView(feedbacks);
        Stage stage = (Stage) ((Node)actionEvent.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setTitle("Feed back List");
        stage.setScene(scene);
        stage.show();
    }

    @javafx.fxml.FXML
    public void clear(ActionEvent actionEvent) {

        TableView.getItems().clear();
        feedbacks.clear();
        new File("feedback.bin").delete();
    }

}