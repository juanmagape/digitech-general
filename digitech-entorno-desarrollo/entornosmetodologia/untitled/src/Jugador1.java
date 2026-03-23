public class Jugador1 extends Personaje {
    private int cantMana;
    private int danoCuerpoaCuerpo;
    private int danoMagia;
    private int vida;

    public Jugador1(int cantMana, int danoCuerpoaCuerpo, int danoMagia, int vida, String nombre, int skillPoints) {
        super(nombre, skillPoints);
        this.cantMana = cantMana;
        this.danoCuerpoaCuerpo = danoCuerpoaCuerpo;
        this.danoMagia = danoMagia;
        this.vida = vida;
    }
}
