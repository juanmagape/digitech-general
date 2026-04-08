package BlackJack;

public class Carta {
    String valor, palo;

    public Carta(String v, String p) {
        valor = v;
        palo = p;
    }

    public int getPuntos() {
        if (valor.matches("J|Q|K")) return 10;
        if (valor.equals("A")) return 11;
        return Integer.parseInt(valor);
    }

    @Override
    public String toString() {
        return valor + "-" + palo;
    }
}