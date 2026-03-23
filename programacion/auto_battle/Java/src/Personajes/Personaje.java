package Personajes;

public abstract class Personaje {
    private String nombre;
    private int vida;
    private int vidaMax;

    public Personaje(String nombre, int vida, int vidaMax) {
        this.nombre = nombre;
        this.vida = vida;
        this.vidaMax = vidaMax;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getVida() {
        return vida;
    }
    public void setVida(int vida) {
        this.vida = vida;
    }

    public int getVidaMax() {
        return vidaMax;
    }
    public void setVidaMax(int vidaMax) {
        this.vidaMax = vidaMax;
    }

    public abstract int ataque ();
    public abstract boolean defensa();
}
