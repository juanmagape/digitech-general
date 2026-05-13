import java.util.Scanner;

public class TresEnRaya {

    private final int tamano = 3;
    private int[][] tablero;
    private int turnoActual;
    private int movimientosTotales;
    private Scanner scanner;

    public TresEnRaya() {
        tablero = new int[tamano][tamano];
        turnoActual = 1;
        movimientosTotales = 0;
        scanner = new Scanner(System.in);
    }

    public void iniciarJuego() {
        boolean juegoTerminado = false;
        System.out.println("=== TRES EN RAYA ===");

        while (!juegoTerminado) {
            mostrarTablero();

            int jugadorQueMovio = turnoActual;
            procesarEntradaJugador();

            if (comprobarVictoria(jugadorQueMovio)) {
                mostrarTablero();
                String simbolo = (jugadorQueMovio == 1) ? "X" : "O";
                System.out.println("Ha ganado el Jugador " + jugadorQueMovio + " [" + simbolo + "].");
                juegoTerminado = true;
            } else if (esEmpate()) {
                mostrarTablero();
                System.out.println("Empate - El tablero está lleno.");
                juegoTerminado = true;
            }
        }
        System.out.println("=== FIN DEL JUEGO ===");
        scanner.close();
    }

    private void mostrarTablero() {
        System.out.println();
        for (int i = 0; i < tamano; i++) {
            for (int j = 0; j < tamano; j++) {
                String simbolo = " ";
                if (tablero[i][j] == 1) {
                    simbolo = "X";
                } else if (tablero[i][j] == 2) {
                    simbolo = "O";
                }
                System.out.print("[" + simbolo + "]");
            }
            System.out.println();
        }
        System.out.println();
    }

    private void procesarEntradaJugador() {
        boolean movimientoValido = false;
        String simbolo = (turnoActual == 1) ? "X" : "O";

        while (!movimientoValido) {
            System.out.println("Turno del Jugador " + turnoActual + " [" + simbolo + "]");
            System.out.print("Introduce la fila (1-3): ");
            int fila = scanner.nextInt() - 1;

            System.out.print("Introduce la columna (1-3): ");
            int columna = scanner.nextInt() - 1;

            if (!realizarMovimiento(fila, columna)) {
                System.out.println("Movimiento inválido. Posición incorrecta o casilla ocupada.");
            } else {
                movimientoValido = true;
            }
        }
    }

    public boolean realizarMovimiento(int fila, int columna) {
        if (fila < 0 || fila >= tamano || columna < 0 || columna >= tamano) {
            return false;
        }
        if (tablero[fila][columna] != 0) {
            return false;
        }

        tablero[fila][columna] = turnoActual;
        movimientosTotales++;
        cambiarTurno();
        return true;
    }

    private void cambiarTurno() {
        turnoActual = (turnoActual == 1) ? 2 : 1;
    }

    public boolean comprobarVictoria(int jugador) {
        for (int i = 0; i < tamano; i++) {
            if ((tablero[i][0] == jugador && tablero[i][1] == jugador && tablero[i][2] == jugador) ||
                    (tablero[0][i] == jugador && tablero[1][i] == jugador && tablero[2][i] == jugador)) {
                return true;
            }
        }

        if ((tablero[0][0] == jugador && tablero[1][1] == jugador && tablero[2][2] == jugador) ||
                (tablero[0][2] == jugador && tablero[1][1] == jugador && tablero[2][0] == jugador)) {
            return true;
        }

        return false;
    }

    public int getCasilla(int fila, int columna) {
        return tablero[fila][columna];
    }

    public boolean esEmpate() {
        return movimientosTotales == tamano * tamano;
    }
}