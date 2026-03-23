package Personajes;
public class Patricio extends Personaje {
    public Patricio() {
        super("Patricio", 15, 15);
    }

    @Override
    public int ataque() {
        System.out.println("Patricio te ha atacado.");
        return 5;
    }

    @Override
    public boolean defensa() {
        if (Math.random() < 0.5) {
            System.out.println("Patricio se esta defendiendo");
            return true;
        } else {
            System.out.println();
            return false;
        }
    }
}
