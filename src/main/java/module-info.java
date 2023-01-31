module com.example.tableviewwithdynamicobjects {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tableviewwithdynamicobjects to javafx.fxml;
    exports com.example.tableviewwithdynamicobjects;
}