package com.example.life_insurance_main.Representative;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.List;

public class FeedbackListController {

    @FXML
    private TableColumn<Feedback, String> IDTable;

    @FXML
    private TableColumn<Feedback, String> FeedBackTypeTable;

    @FXML
    private TableColumn<Feedback, String> FeedBackTable;

    @FXML
    private TableView<Feedback> TableView;

    private List<Feedback> feedbackList;

    @FXML
    public void initialize() {
        IDTable.setCellValueFactory(new PropertyValueFactory<>("id"));
        FeedBackTypeTable.setCellValueFactory(new PropertyValueFactory<>("type"));
        FeedBackTable.setCellValueFactory(new PropertyValueFactory<>("feedback"));
    }

    public void setTableView(List<Feedback> feedback) {
        this.feedbackList = feedback;
        TableView.getItems().setAll(feedback);
    }

    @FXML
    public void handleDelete() throws IOException {
        Feedback selected = TableView.getSelectionModel().getSelectedItem();
        if (selected != null) {
            TableView.getItems().remove(selected);
            feedbackList.remove(selected);
            saveFeedbackList();
        } else {
            System.out.println("No feedback selected to delete");
        }
    }

    public void saveFeedbackList() throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("feedback.bin"))) {
            for (Feedback f : feedbackList) {
                oos.writeObject(f);
            }
        }
    }
}
