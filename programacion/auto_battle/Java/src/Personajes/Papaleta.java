package Personajes;

public class Papaleta extends Personaje {
    public Papaleta() {

        super("Papaleta", 14, 14);
    }

    @Override
    public int ataque() {
        return 16;
    }

    @Override
    public boolean defensa() {
        if (Math.random() < 0.5) {
            System.out.println("Se cubre con los brazos");
            return true;
        } else {
            System.out.println();
            return false;
        }
    }
}
