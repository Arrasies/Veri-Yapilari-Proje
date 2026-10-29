module com.example.sportesisiotomasyonu {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.sportesisiotomasyonu to javafx.fxml;
    exports com.example.sportesisiotomasyonu;
}