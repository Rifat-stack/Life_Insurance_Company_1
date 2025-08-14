module com.example.life_insurance_main {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.example.life_insurance_main to javafx.fxml;
    opens com.example.life_insurance_main.ClaimOfficer to javafx.fxml, java.base;
    opens com.example.life_insurance_main.Underwriter to javafx.fxml, java.base;
    opens com.example.life_insurance_main.PolicyManager to javafx.fxml;
    opens com.example.life_insurance_main.Representative to javafx.fxml;


    exports com.example.life_insurance_main.Representative;
    exports com.example.life_insurance_main;
    exports com.example.life_insurance_main.ITAdmin;
    opens com.example.life_insurance_main.ITAdmin to javafx.fxml;
    exports com.example.life_insurance_main.BillingOfficer;
    exports com.example.life_insurance_main.PolicyManager;
    opens com.example.life_insurance_main.BillingOfficer to javafx.fxml;
}