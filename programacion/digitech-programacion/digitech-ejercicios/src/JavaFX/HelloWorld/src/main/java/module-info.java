module org.example.helloworld {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.helloworld to javafx.fxml;
    exports org.example.helloworld;
}