import Combate.Jugador;
import Combate.SistemaCombate;
import Personajes.Personaje;
import Tienda.EnemigoIA;
import Tienda.Tienda;
import java.util.Random;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Random random = new Random();

        System.out.println("-------------------------------");
        System.out.println("-- BIENVENIDO AL AUTO BATTLE --");
        System.out.println("-------------------------------");

        System.out.print("Introduce tu nombre: ");
        String nombre = sc.nextLine();

        Jugador jugador = new Jugador(nombre);

        int rondasGanadasJugador = 0;
        int rondasGanadasIA = 0;

        boolean jugando = true;

        while (jugando) {

            System.out.println("\n========= MENÚ PRINCIPAL =========");
            System.out.println("Monedas: " + jugador.getMonedas());
            System.out.println("Personajes en equipo: " + jugador.getEquipo().size());
            System.out.println("Rondas ganadas: " + rondasGanadasJugador);
            System.out.println("1. Ir a tienda");
            System.out.println("2. Iniciar combate");
            System.out.println("3. Salir");
            System.out.print("Elige una opción: ");

            int opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1: // Tienda
                    Tienda tienda = new Tienda();
                    boolean enTienda = true;

                    while (enTienda) {
                        tienda.mostrarTienda(jugador);

                        System.out.println("Monedas: " + jugador.getMonedas());
                        System.out.println("1. Comprar");
                        System.out.println("2. Vender");
                        System.out.println("3. Roll ");
                        System.out.println("4. Salir");

                        int opcionTienda = Integer.parseInt(sc.nextLine());

                        switch (opcionTienda) {

                            case 1:
                                System.out.print("Selecciona slot: ");
                                int slot = Integer.parseInt(sc.nextLine());
                                tienda.comprarPersonaje(slot, jugador);
                                break;

                            case 2:
                                System.out.print("Selecciona personaje a vender: ");
                                int idx = Integer.parseInt(sc.nextLine());
                                tienda.venderPersonaje(idx, jugador);
                                break;

                            case 3:
                                tienda.hacerRoll();
                                break;

                            case 4:
                                enTienda = false;
                                break;
                        }
                    }
                    break;
                case 2: // Combate

                    if (jugador.getEquipo().isEmpty()) {
                        System.out.println("Necesitas  1 unidad para combatir.");
                        break;
                    }
                    // IA
                    Tienda tiendaIA = new Tienda();
                    EnemigoIA enemigo = new EnemigoIA();
                    enemigo.comprarDeTienda(tiendaIA);
                    enemigo.seleccionarEquipoCombate();

                    String[] nombresIA = {"Friday", "JARVIS", "Ultron"};
                    Jugador ia = new Jugador(nombresIA[random.nextInt(nombresIA.length)]);

                    for (Personaje p : enemigo.getEquipoCombate()) {
                        ia.agregarPersonaje(p);
                    }

                    SistemaCombate combate = new SistemaCombate();
                    combate.iniciarCombate(jugador, ia);

                    if (jugador.equipoVivo()) {
                        System.out.println("Has ganado la ronda!");
                        rondasGanadasJugador++;
                        jugador.añadirMonedas(3);
                    } else {
                        System.out.println("Has perdido la ronda.");
                        rondasGanadasIA++;
                        jugador.añadirMonedas(5);
                    }

                    jugador.restaurarEquipo();

                    System.out.println("Marcador | " + nombre + ": " + rondasGanadasJugador + " - IA: " + rondasGanadasIA);

                    if (rondasGanadasJugador == 10) {
                        System.out.println("HAS GANADO LA PARTIDA!");
                        jugando = false;
                    } else if (rondasGanadasIA == 10) {
                        System.out.println("La IA ha ganado la partida.");
                        jugando = false;
                    }

                    break;

                case 3:
                    jugando = false;
                    System.out.println("Has salido del juego.");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }

        sc.close();
    }
}