module com.example.nevnapok_gui {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.nevnapok_gui to javafx.fxml;
    exports com.example.nevnapok_gui;
}