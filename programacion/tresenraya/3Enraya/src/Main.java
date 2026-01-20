import java.util.Scanner;

public class Main {
    static int tablero = 3;
    static int partidas = 3;
    static int puntuacionJug1 = 0;
    static int puntuacionJug2 = 0;
    static int[][] tableroTER;

    public static void main(String[] args) throws InterruptedException {

        Scanner print = new Scanner(System.in);
        boolean seguirJugando = true;

        while(seguirJugando) {

            System.out.println("============================");
            System.out.println("[1] - Jugar");
            System.out.println("[2] - Configuración");
            System.out.println("[3] - Salir");
            System.out.println("============================");

            int opcion = print.nextInt();

            switch (opcion) {
                case 1:
                    Juego(print);
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
            }
        }
    }

    public static void Tablero() {
        System.out.println();
        for (int i = 0; i < tablero; i++) {
            for (int j = 0; j < tablero; j++) {
                String simbolo = " ";
                if (tableroTER[i][j] == 1) {
                    simbolo = "X";
                } else if (tableroTER[i][j] == 2) {
                    simbolo = "O";
                }

                System.out.print("[" + simbolo + "]");
            }
            System.out.println();
        }
    }

    public static void Juego(Scanner print) {
        puntuacionJug1 = 0;
        puntuacionJug2 = 0;

        while (puntuacionJug1 < partidas && puntuacionJug2 < partidas) {
            System.out.println("\nMARCADOR: JUGADOR 1: " + puntuacionJug1 + " | JUGADOR 2: " + puntuacionJug2);
            PartidaIndividual(print);
        }

        System.out.println("\n=======================================");
        if (puntuacionJug1 == partidas) {
            System.out.println("Ha ganado el jugador 1");
        } else {
            System.out.println("Ha ganado el jugador 2");
        }
        System.out.println("=======================================\n");
    }

    public static void PartidaIndividual(Scanner print) {
        tableroTER = new int[tablero][tablero];
        int turno = 1;
        boolean partidaTerminada = false;
        int movimientosTotales = 0;
        int maxMovimientos = tablero * tablero;

        while (partidaTerminada == false) {
            Tablero();

            if (turno == 1) {
                System.out.println("Turno del jugador: " + turno + " [X]");
            } else if (turno == 2) {
                System.out.println("Turno del jugador: " + turno + " [O]");
            }

            boolean coordenadasPendientes = true;

            while (coordenadasPendientes) {
                System.out.println("Introduce la fila: ");
                int filaIn = print.nextInt();
                System.out.println("Introduce la columna: ");
                int columnaIn = print.nextInt();

                int columna = columnaIn - 1;
                int fila = filaIn - 1;

                if (filaIn > tablero || columnaIn > tablero || columnaIn < 0 || filaIn < 0) {
                    System.out.println("Posición incorrecta, prueba de nuevo.");
                } else if (tableroTER[fila][columna] != 0) {
                    System.out.println("La casilla ya esta ocupada");
                } else {
                    tableroTER[fila][columna] = turno;
                    coordenadasPendientes = false;
                    movimientosTotales = movimientosTotales + 1;
                }
            }

            if (comprobarVic(turno)) {
                Tablero();
                System.out.println("\nPunto para el Jugador " + turno);
                if (turno == 1) {
                    puntuacionJug1 = puntuacionJug1 + 1;
                } else {
                    puntuacionJug2 = puntuacionJug2 + 1;
                }
                partidaTerminada = true;
            } else if (movimientosTotales == maxMovimientos) {
                Tablero();
                System.out.println("\nEmpate.");
                partidaTerminada = true;
            } else {
                if (turno == 1) {
                    turno = 2;
                } else {
                    turno = 1;
                }
            }
        }
    }

    public static boolean comprobarVic(int jugador) {
        boolean haGanado = false;

        for (int i = 0; i < tablero; i++) {
            boolean linea = true;
            for (int j = 0; j < tablero; j++) {
                if (tableroTER[i][j] != jugador) {
                    linea = false;
                }
            }
            if (linea) {
                haGanado = true;
            }
        }

        for (int j = 0; j < tablero; j++) {
            boolean linea = true;
            for (int i = 0; i < tablero; i++) {
                if (tableroTER[i][j] != jugador) {
                    linea = false;
                }
            }
            if (linea == true) {
                haGanado = true;
            }
        }

        boolean diagonal1 = true;
        for (int i = 0; i < tablero; i++) {
            if (tableroTER[i][i] != jugador) {
                diagonal1 = false;
            }
        }
        if (diagonal1 == true) {
            haGanado = true;
        }

        boolean diagonal2 = true;
        for (int i = 0; i < tablero; i++) {
            if (tableroTER[i][tablero - 1 - i] != jugador) {
                diagonal2 = false;
            }
        }
        if (diagonal2 == true) {
            haGanado = true;
        }
        return haGanado;
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
                        tablero = nuevoTablero;
                    }
                    break;
                case 2:
                    System.out.println("\nIntroduce el número de partidas necesarias para ganar (MIN 1):");
                    int nuevoPartidas = print.nextInt();
                    if (nuevoPartidas >= 1) {
                        partidas = nuevoPartidas;
                    }
                    break;
            }
        }
    }
}