package Combate;

import Personajes.Personaje;

import java.util.Random;

public class SistemaCombate {

    public void iniciarCombate (Jugador j1, Jugador j2){

        Random random = new Random();

        System.out.println("==================================");
        System.out.println("        INICIA EL COMBATE         ");
        System.out.println("==================================");
        System.out.println(j1.getNombre() + " VS  " + j2.getNombre());

        Jugador atacante;
        Jugador defensor;
        if (random.nextBoolean()) {
            atacante = j1;
            defensor = j2;
        } else {
            atacante = j2;
            defensor = j1;
        }

        Personaje pAtacante = atacante.obtenerPersonajeActual();
        Personaje pDefensor = defensor.obtenerPersonajeActual();

        System.out.println("Atacante: " + pAtacante.getNombre());
        System.out.println("Defensor: " + pDefensor.getNombre());

        int turno = 0;

        while (j1.equipoVivo() && j2.equipoVivo()) {

            System.out.println("------------TURNO " + turno++ + "-------------");

            turnoDeCombate(atacante, defensor);

            Jugador temporal = atacante;
            atacante = defensor;
            defensor = temporal;

            System.out.println();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
            }
        }

        Jugador ganador;
        if (j1.equipoVivo()) {
            ganador = j1;
        } else {
            ganador = j2;
        }

        System.out.println("===============================================");
        System.out.println(ganador.getNombre() + " HA GANADO EL COMBATE!");
        System.out.println("===============================================");


    }

    private void turnoDeCombate(Jugador atacante, Jugador defensor) {
        Personaje atq =  atacante.obtenerPersonajeActual();
        Personaje def = defensor.obtenerPersonajeActual();

        int dmg = atq.ataque();
        boolean defiende = def.defensa();
        if (defiende) {
            System.out.println(def.getNombre() + " ha bloqueado el ataque!");
        } else {
            def.setVida(Math.max(0, def.getVida() - dmg));

            System.out.println(def.getNombre() + " ha recibido daño!");
            System.out.println("Vida restante: " +  def.getVida());

            if (def.getVida() <= 0) {
                def.setVida(0);
                System.out.println(def.getNombre() + " ha caído en combate!");
                defensor.siguientePersonaje();

                if (defensor.equipoVivo()) {
                    System.out.println(defensor.obtenerPersonajeActual().getNombre() + "continuará la pelea!");

                }
            }
        }
    }
}
