package org.example.aplicaciondeltiempo;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class Controlador {

    @FXML
    private TextField textoCiudad;

    @FXML
    private Label errorCiudad;
    @FXML
    private Label buscandoCiudad;
    @FXML
    private Label datosCiudad;

    @FXML
    public void BuscarTiempo() {
        String ciudad = textoCiudad.getText().trim();

        errorCiudad.setText("");
        buscandoCiudad.setText("");
        datosCiudad.setText("");

        if (ciudad.isEmpty()) {
            errorCiudad.setText("Por favor, ingrese una ciudad.");
            return;
        }

        buscandoCiudad.setText("Buscando el tiempo para " + ciudad + "...");

        // ENVOLVEMOS LA LLAMADA A LA API EN UN TRY-CATCH
        try {
            Tiempo tiempo = new ApiTiempo().servicioApi(ciudad);

            String datos = "Ciudad: " + ciudad.toUpperCase() + "\n" +
                    "Temperatura: " + tiempo.getTemperatura() + " °C\n" +
                    "Humedad: " + tiempo.getHumedad() + " %\n" +
                    "Viento: " + tiempo.getViento() + " km/h\n" +
                    "Código del clima: " + tiempo.getWeatherCode();

            datosCiudad.setText(datos);
            buscandoCiudad.setText("");

        } catch (Exception e) {
            buscandoCiudad.setText("");
            errorCiudad.setText("No  se pudo obtener el tiempo");
        }
    }
}
