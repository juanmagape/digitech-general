module org.example.memory {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.memory to javafx.fxml;
    exports org.example.memory;
}