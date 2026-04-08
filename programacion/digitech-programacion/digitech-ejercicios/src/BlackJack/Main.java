package BlackJack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    static ArrayList<Carta> baraja = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        ArrayList<String> palos = new ArrayList<>(Arrays.asList("Corazones", "Diamantes", "Picas", "Tréboles"));
        ArrayList<String> val = new ArrayList<>(Arrays.asList("2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q", "K", "A"));

        for (String p : palos) {
            for (String v : val) {
                baraja.add(new Carta(v, p));
            }
        }

        Collections.shuffle(baraja);

        Jugador humano = new Jugador("Jugador");
        Jugador ia = new Jugador("IA");

        humano.pedirCarta(robar());
        ia.pedirCarta(robar());

        boolean jugar = true;

        while (jugar) {
            while (humano.puntos() < 21) {
                humano.mostrar();
                System.out.print("1: Pedir, 2: Plantarse");
                if (sc.nextLine().equals("2")) break;
                humano.pedirCarta(robar());
            }

            if (humano.puntos() > 21) {
                humano.mostrar();
                System.out.println("Te has pasado. Gana IA.");
                return;
            }

            while (ia.puntos() < 17) ia.pedirCarta(robar());

            System.out.println("\nRESULTADO:");
            humano.mostrar();
            ia.mostrar();

            int p1 = humano.puntos();
            int p2 = ia.puntos();

            if (p2 > 21 || p1 > p2) System.out.println("Has ganado");
            else if (p1 == p2) System.out.println("Empate");
            else System.out.println("Gana IA");

            System.out.println("Quieres seguir jugando? 1 - si | 2 - no");
            int respuesta = sc.nextInt();

            if (respuesta == 2) {
                System.exit(0);
            }
        }
    }

    static Carta robar() {
        return baraja.remove(baraja.size() - 1);
    }
}