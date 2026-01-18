import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int tablero = 3;
    static int partidas = 3;
    static int puntuacionJug1 = 0;
    static int puntuacionJug2 = 0;

    static int[][] tableroTER = new int[tablero][tablero];


    public static void main(String[] args) throws InterruptedException {
        Scanner print = new Scanner(System.in);
        boolean seguirJugando = true;

        while (seguirJugando) {

            System.out.println("============================");
            System.out.println("[1] - Jugar");
            System.out.println("[2] - Configuración");
            System.out.println("[3] - Salir");;
            System.out.println("============================");

            int opcion = print.nextInt();

            switch (opcion) {
                case 1:
                    Juego();
                    break;
                case 2:
                    Configuracion(print);
                    break;
                case 3:
                    System.out.println("============================");
                    System.out.println("Resultados:");
                    System.out.println("Jugador 1: " + puntuacionJug1);
                    System.out.println("Jugador 2: " + puntuacionJug2);
                    System.out.println("============================");

                    System.out.println("\nSaliendo del programa...");
                    seguirJugando = false;
                    break;
            }
        }
    }

    public static void Juego() {

        for (int i = 0; i < tablero; i++) {
            for (int j = 0; j < tablero; j++) {
                System.out.println("[" + tableroTER[i][j] + "]asd");
            }
        }
    }

    public static void Configuracion(Scanner print) {
        System.out.println("============================");
        System.out.println("Configuración actual");
        System.out.println("Tablero: " + tablero + "x" + tablero);
        System.out.println("Cantidad de partidas necesarias para ganar: " + partidas);
        System.out.println("============================");

        System.out.println("\nQuieres realizar algún cambio? [1 - SI | 2 - NO]");
        int opcionConfig = print.nextInt();

        if (opcionConfig == 1) {
            System.out.println("\nQue opción quiere cambiar? [1 - TABLERO | 2 - PARTIDAS PARA GANAR]");
            int opcCambio = print.nextInt();

            switch (opcCambio) {
                case 1:
                    System.out.println("\nIntroduce el número de filas para el tablero (MIN: 3):");
                    int nuevoTablero = print.nextInt();

                    if (nuevoTablero >= 3) {
                        System.out.println("\nConfiguración de tablero actualizada a: " + nuevoTablero + "x" + nuevoTablero);
                        tablero = nuevoTablero;
                    } else if (nuevoTablero == tablero) {
                        System.out.println("\nLa configuración del tablero es la misma que ya tenías.");
                    } else if (nuevoTablero < 3)  {
                        System.out.println("\nEl tablero no puede ser menor a 3");
                    }
                    break;
                case 2:
                    System.out.println("\nIntroduce el número de partidas necesarias para ganar (MIN 1):");
                    int nuevoPartidas = print.nextInt();

                    if (nuevoPartidas > 1) {
                        System.out.println("\nConfiguración de partidas actualizada a: " + nuevoPartidas + " necesarias para ganar.");
                        partidas = nuevoPartidas;
                    } else if (nuevoPartidas == partidas) {
                        System.out.println("\nNo se ha actualizado, la configuración es la misma que ya tienes.");
                    } else if (nuevoPartidas < 1) {
                        System.out.println("\nEl mínimo es 1, porfavor introduzca un número correcto");
                    }
                    break;
            }
        }
    }

}