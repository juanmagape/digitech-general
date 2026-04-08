package BlackJack;

import java.util.ArrayList;

public class Jugador {
    String nombre;
    ArrayList<Carta> mano = new ArrayList<>();

    public Jugador(String n) {
        nombre = n;
    }

    public void pedirCarta(Carta c) {
        mano.add(c);
    }

    public int puntos() {
        int total = 0, ases = 0;
        for (Carta c : mano) {
            total += c.getPuntos();
            if (c.valor.equals("A")) ases++;
        }
        while (total > 21 && ases > 0) {
            total -= 10;
            ases--;
        }
        return total;
    }

    public void mostrar() {
        System.out.println(nombre + ": " + mano + " (" + puntos() + " pts)");
    }
}