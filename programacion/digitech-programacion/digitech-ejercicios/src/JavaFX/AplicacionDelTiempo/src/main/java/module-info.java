module org.example.aplicaciondeltiempo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.net.http;
    requires org.json;


    opens org.example.aplicaciondeltiempo to javafx.fxml;
    exports org.example.aplicaciondeltiempo;
}