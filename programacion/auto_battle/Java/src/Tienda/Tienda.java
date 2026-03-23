package Tienda;

import Combate.Jugador;
import Personajes.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tienda {

    private static final int numeroSlots = 5;

    private List<Personaje> slotsPersonajes;
    private Random random;

    public Tienda() {
        this.slotsPersonajes = new ArrayList<>();
        this.random = new Random();
        hacerRoll();
    }

    public void hacerRoll() {
        System.out.println("\n================ Rolleando personajes ================");
        slotsPersonajes.clear();

        for (int i = 0; i < numeroSlots; i++) {
            int seleccion = random.nextInt(24);

            Personaje nuevoPersonaje;
            switch (seleccion) {
                case 0:  nuevoPersonaje = new Bob(); break;
                case 1:  nuevoPersonaje = new CapibaraDeCombate(); break;
                case 2:  nuevoPersonaje = new Castor(); break;
                case 3:  nuevoPersonaje = new Dersh(); break;
                case 4:  nuevoPersonaje = new Jeffrey(); break;
                case 5:  nuevoPersonaje = new KokaLoka(); break;
                case 6:  nuevoPersonaje = new LeonKennedih(); break;
                case 7:  nuevoPersonaje = new Mambo(); break;
                case 8:  nuevoPersonaje = new Meowl(); break;
                case 9:  nuevoPersonaje = new MiBombo(); break;
                case 10: nuevoPersonaje = new Mordecai(); break;
                case 11: nuevoPersonaje = new Papaleta(); break;
                case 12: nuevoPersonaje = new Patricio(); break;
                case 13: nuevoPersonaje = new bigYahu(); break;
                case 14: nuevoPersonaje = new CarlosKirk(); break;
                case 15: nuevoPersonaje = new fih(); break;
                case 16: nuevoPersonaje = new furryDeku(); break;
                case 17: nuevoPersonaje = new Morf(); break;
                case 18: nuevoPersonaje = new Osaka(); break;
                case 19: nuevoPersonaje = new PerroMetralleta(); break;
                case 20: nuevoPersonaje = new Piccolo(); break;
                case 21: nuevoPersonaje = new Rigby(); break;
                case 22: nuevoPersonaje = new Trump(); break;
                case 23: nuevoPersonaje = new Unemployed(); break;
                default: nuevoPersonaje = new Castor(); break;
            }
            slotsPersonajes.add(nuevoPersonaje);
        }
    }

    public void mostrarTienda(Jugador jugador) {
        System.out.println("\n================ ESTADO DE LA TIENDA ================");
        System.out.println("Personajes en Venta:");
        for (int i = 0; i < slotsPersonajes.size(); i++) {
            Personaje p = slotsPersonajes.get(i);
            if (p != null) {
                System.out.println("[" + i + "] " + p.getNombre() + " (Vida: " + p.getVida() + "/" + p.getVidaMax() + ")");
            } else {
                System.out.println("[" + i + "] [VACÍO]");
            }
        }
        System.out.println("====================================================");
        System.out.println("\nTu Equipo Actual:");
        if (jugador.getEquipo().isEmpty()) {
            System.out.println("  (El equipo está vacío)");
        } else {
            for (int i = 0; i < jugador.getEquipo().size(); i++) {
                System.out.println("  [" + i + "] " + jugador.getEquipo().get(i).getNombre());
            }
        }
        System.out.println("====================================================");
    }

    public void comprarPersonaje(int indiceSlot, Jugador jugador) {
        if (indiceSlot < 0 || indiceSlot >= slotsPersonajes.size()) {
            System.out.println("Índice de tienda inválido.");
            return;
        }

        Personaje personajeAComprar = slotsPersonajes.get(indiceSlot);

        if (personajeAComprar == null) {
            System.out.println("Ese slot está vacío.");
            return;
        }

        if (jugador.getEquipo().size() >= 10) {
            System.out.println("Equipo lleno (máx 10).");
            return;
        }

        if (jugador.getMonedas() <= 0) {
            System.out.println("No tienes monedas.");
            return;
        }

        slotsPersonajes.set(indiceSlot, null);
        jugador.agregarPersonaje(personajeAComprar);
        jugador.añadirMonedas(-1);

        System.out.println("¡Has reclutado a " + personajeAComprar.getNombre() + "!");
    }

    public void venderPersonaje(int indiceEquipo, Jugador jugador) {
        if (indiceEquipo < 0 || indiceEquipo >= jugador.getEquipo().size()) {
            System.out.println("Índice de equipo inválido.");
            return;
        }

        Personaje personajeVendido = jugador.getEquipo().get(indiceEquipo);
        jugador.getEquipo().remove(indiceEquipo);
        jugador.añadirMonedas(1);

        System.out.println("\nHas vendido a " + personajeVendido.getNombre() + ".");
    }

    public List<Personaje> getSlotsPersonajes() {
        return this.slotsPersonajes;
    }
}