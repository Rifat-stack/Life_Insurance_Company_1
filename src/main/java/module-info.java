module com.example.life_insurance_main {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.life_insurance_main to javafx.fxml;
    opens com.example.life_insurance_main.ClaimOfficer to javafx.fxml, java.base;
    opens com.example.life_insurance_main.Underwriter to javafx.fxml, java.base;

    exports com.example.life_insurance_main;
}