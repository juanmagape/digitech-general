package Personajes;
public class Castor extends Personaje {
    public Castor() {
        super("Castor", 5, 5);
    }

    @Override
    public int ataque() {
        System.out.println("El castor te ataca con sus dientes.");
        return 5;
    }

    @Override
    public boolean defensa() {

        if (Math.random() < 0.5) {
            System.out.println("El castor se esta defendiendo");
            return true;
        } else {
            System.out.println();
            return false;
        }
    }
}
