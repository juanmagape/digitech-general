package org.example.memory;

import javafx.animation.PauseTransition;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.util.Duration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class HelloController {

    @FXML
    private VBox tablero;

    private List<String> cartas = new ArrayList<>();
    private Button primeraCarta = null;
    private Button segundaCarta = null;
    private int parejasEncontradas = 0;
    private boolean bloqueado = false;

    @FXML
    public void initialize() {
        String[] valores = {
                "Hollow Knight", "Hollow Knight",
                "Silksong", "Silksong",
                "Hades", "Hades",
                "Celeste", "Celeste",
                "Elden Ring", "Elden Ring",
                "Zelda", "Zelda",
                "Minecraft", "Minecraft",
                "Portal", "Portal"
        };
        Collections.addAll(cartas, valores);
        Collections.shuffle(cartas);

        int index = 0;

        for (int fila = 0; fila < 4; fila++) {
            HBox filaHBox = new HBox();
            filaHBox.setSpacing(10);
            filaHBox.setAlignment(Pos.CENTER);

            for (int col = 0; col < 4; col++) {
                Button btn = new Button("?");

                btn.setPrefSize(160, 80);

                btn.setStyle("-fx-font-size: 13px; -fx-font-weight: bold;");

                btn.setUserData(cartas.get(index));
                btn.setOnAction(this::manejarClickCarta);

                filaHBox.getChildren().add(btn);
                index++;
            }

            tablero.getChildren().add(filaHBox);
        }
    }

    private void manejarClickCarta(ActionEvent event) {
        if (bloqueado) return;

        Button btnClicado = (Button) event.getSource();

        if (!btnClicado.getText().equals("?")) return;

        btnClicado.setText(btnClicado.getUserData().toString());

        if (primeraCarta == null) {
            primeraCarta = btnClicado;
        } else {
            segundaCarta = btnClicado;
            comprobarPareja();
        }
    }

    private void comprobarPareja() {
        bloqueado = true;

        if (primeraCarta.getText().equals(segundaCarta.getText())) {
            primeraCarta.setDisable(true);
            segundaCarta.setDisable(true);
            parejasEncontradas++;
            reiniciarTurno();

            if (parejasEncontradas == 8) {
                Alert alerta = new Alert(Alert.AlertType.INFORMATION);
                alerta.setContentText("Has encontrado todas las parejas");
                alerta.showAndWait();
            }
        } else {
            PauseTransition pausa = new PauseTransition(Duration.seconds(1));
            pausa.setOnFinished(e -> {
                primeraCarta.setText("?");
                segundaCarta.setText("?");
                reiniciarTurno();
            });
            pausa.play();
        }
    }

    private void reiniciarTurno() {
        primeraCarta = null;
        segundaCarta = null;
        bloqueado = false;
    }
}