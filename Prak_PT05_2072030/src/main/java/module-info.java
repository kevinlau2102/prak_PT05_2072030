module com.example.prak_pt04_2072030 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.prak_pt05_2072030 to javafx.fxml;
    exports com.example.prak_pt05_2072030;
    exports com.example.prak_pt05_2072030.Utility;
    opens com.example.prak_pt05_2072030.Utility to javafx.fxml;
    exports com.example.prak_pt05_2072030.Model;
    opens com.example.prak_pt05_2072030.Model to javafx.fxml;
    exports com.example.prak_pt05_2072030.Dao;
    opens com.example.prak_pt05_2072030.Dao to javafx.fxml;
    exports com.example.prak_pt05_2072030.Controller;
    opens com.example.prak_pt05_2072030.Controller to javafx.fxml;
}