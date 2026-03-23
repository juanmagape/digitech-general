package Personajes;

public class Mordecai extends Personaje{

    public Mordecai() {
        super("Mordecai", 7, 7);

    }
    @Override
    public int ataque() {
        return 13;
    }

    @Override
    public boolean defensa() {
        if (Math.random() < 0.5) {
            System.out.println("Pega un salto y esquiva los ataques");
            return true;
        } else {
            System.out.println();
            return false;
        }
    }

}
