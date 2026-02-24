package PracticaHerencia.PersonajeDeVideojuego;

public class Guerrero extends Personaje {
    private int fuerza;
    private int armadura;


    public Guerrero(String nombre, int vida, int ataque, int defensa, int fuerza, int armadura) {
        super(nombre, vida, ataque, defensa);
        this.fuerza = fuerza;
        this.armadura = armadura;
    }

    public int getFuerza() {
        return fuerza;
    }

    public void setFuerza(int fuerza) {
        this.fuerza = fuerza;
    }

    public int getArmadura() {
        return armadura;
    }

    public void setArmadura(int armadura) {
        this.armadura = armadura;
    }

    public void mostrarGuerrero() {
        System.out.println("Nombre: " + super.getNombre());
        System.out.println("Vida: " + super.getVida());
        System.out.println("Ataque: " + super.getAtaque());
        System.out.println("Defensa: " + super.getDefensa());
        System.out.println("Fuerza: " + this.getFuerza());
        System.out.println("Poder Magico: " + this.getArmadura());
    }
}
