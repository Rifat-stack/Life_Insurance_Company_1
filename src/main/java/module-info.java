module com.example.life_insurance_main {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;

    // Allow JavaFX to use reflection on controller classes
    opens com.example.life_insurance_main to javafx.fxml;
    opens com.example.life_insurance_main.ClaimOfficer to javafx.fxml, java.base;
    opens com.example.life_insurance_main.Underwriter to javafx.fxml, java.base;
    opens com.example.life_insurance_main.PolicyManager to javafx.fxml, java.base;
    opens com.example.life_insurance_main.Representative to javafx.fxml, java.base;

    // Export packages so they can be used externally
    exports com.example.life_insurance_main;
    exports com.example.life_insurance_main.PolicyManager;
    exports com.example.life_insurance_main.Representative;

}
