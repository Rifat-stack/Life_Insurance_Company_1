module com.example.life_insurance_main {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.life_insurance_main to javafx.fxml;
    exports com.example.life_insurance_main;
}