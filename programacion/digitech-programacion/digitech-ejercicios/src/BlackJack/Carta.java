package BlackJack;

public class Carta {
        private String palo;
        private String valor;

        public Carta(String palo, String valor) {
            this.palo = palo;
            this.valor = valor;
        }

        public String getPalo() {
            return palo;
        }

        public String getValor() {
            return valor;
        }
}
