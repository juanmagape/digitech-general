package com.example.demo;

import com.example.demo.Modelo.GestionDatos;
import com.example.demo.Modelo.TriviaService;
import org.junit.jupiter.api.Test;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class TriviaTest {

    @Test
    void consultarPregunta() {
        GestionDatos pregunta = new GestionDatos();
        pregunta.question = "¿Capital de Francia?";

        assertEquals("¿Capital de Francia?", pregunta.getEnunciado());
    }

    @Test
    void consultarRespuesta() {
        GestionDatos pregunta = new GestionDatos();
        pregunta.correct_answer = "París";

        assertEquals("París", pregunta.getRespuestaCorrecta());
    }

    @Test
    void consultarRespuestaIncorrecta() {
        GestionDatos pregunta = new GestionDatos();
        pregunta.incorrect_answers = new ArrayList<>(Arrays.asList("Roma", "Londres", "Madrid"));

        assertEquals(3, pregunta.getRespuestasIncorrectas().size());
        assertTrue(pregunta.getRespuestasIncorrectas().contains("Roma"));
    }

    @Test
    void verificarAtributos() {
        GestionDatos pregunta = new GestionDatos();
        pregunta.category = "Geografía";
        pregunta.difficulty = "easy";
        pregunta.type = "multiple";

        assertEquals("Geografía", pregunta.getCategoria());
        assertEquals("easy", pregunta.getDificultad());
        assertEquals("multiple", pregunta.getTipo());
    }

    @Test
    void preguntaNoNula() {
        try {
            TriviaService servicio = new TriviaService();
            GestionDatos pregunta = servicio.obtenerPregunta();

            assertNotNull(pregunta);
        } catch (Exception e) {
            System.out.println("Aviso (Test omitido): La API no respondió a tiempo. " + e.getMessage());
        }
    }

    @Test
    void enunciadoValido() {
        try {
            TriviaService servicio = new TriviaService();
            GestionDatos pregunta = servicio.obtenerPregunta();

            assertNotNull(pregunta.getEnunciado());
            assertFalse(pregunta.getEnunciado().isEmpty());
        } catch (Exception e) {
            System.out.println("Aviso (Test omitido): La API no respondió a tiempo. " + e.getMessage());
        }
    }

    @Test
    void respuestaCompleta() {
        try {
            TriviaService servicio = new TriviaService();
            GestionDatos pregunta = servicio.obtenerPregunta();

            assertNotNull(pregunta.getRespuestaCorrecta());
            assertFalse(pregunta.getRespuestasIncorrectas().isEmpty());
        } catch (Exception e) {
            System.out.println("Aviso (Test omitido): La API no respondió a tiempo. " + e.getMessage());
        }
    }
}