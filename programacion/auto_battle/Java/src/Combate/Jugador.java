package Combate;

import Personajes.Personaje;

import java.util.ArrayList;

public class Jugador {

    private String nombre;
    private ArrayList<Personaje> equipo = new  ArrayList<>();
    private int personajeActual = 0;
    private int monedas = 5;

    public Jugador(String nombre) {
        this.nombre = nombre;
    }

    public boolean agregarPersonaje (Personaje personaje) {
        if (equipo.size() >= 10) {
            System.out.println("Equipo lleno!");
            return false;
        }
        equipo.add(personaje);
        return true;
    }

    public Personaje obtenerPersonajeActual() {
        return equipo.get(personajeActual);
    }

    public boolean equipoVivo() {
        return personajeActual < equipo.size();
    }

    public void siguientePersonaje() {
        personajeActual++;

        if (equipoVivo()) {
            System.out.println(obtenerPersonajeActual().getNombre() + "continua el combate!");
        } else {
            System.out.println("No quedan personajes para continuar la batalla!");
        }
    }

    public void restaurarEquipo() {
        personajeActual = 0;
        for (Personaje p : equipo) {
            p.setVida(p.getVidaMax());
        }
    }

    public void añadirMonedas(int cantidad) {
        monedas += cantidad;
    }

    public String getNombre() { return nombre;}

    public ArrayList<Personaje> getEquipo() { return equipo;}

    public int getPersonajeActual() { return personajeActual;}

    public int getMonedas() { return monedas; }
}
