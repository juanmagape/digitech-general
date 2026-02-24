package PracticaHerencia.PersonajeDeVideojuego;

public class Mago extends Personaje {
    private int mana;
    private int poderMagico;

    public Mago (String nombre, int vida, int ataque, int defensa, int mana, int poderMagico) {
        super(nombre, vida, ataque, defensa);
        this.mana = mana;
        this.poderMagico = poderMagico;


    }

    public int getMana() {
        return mana;
    }

    public void setMana(int mana) {
        this.mana = mana;
    }

    public int getPoderMagico() {
        return poderMagico;
    }

    public void setPoderMagico(int poderMagico) {
        this.poderMagico = poderMagico;
    }

    public void mostrarMago() {
        System.out.println("Nombre: " + super.getNombre());
        System.out.println("Vida: " + super.getVida());
        System.out.println("Ataque: " + super.getAtaque());
        System.out.println("Defensa: " + super.getDefensa());
        System.out.println("Mana: " + this.getMana());
        System.out.println("Poder Magico: " + this.getPoderMagico());
    }
}
