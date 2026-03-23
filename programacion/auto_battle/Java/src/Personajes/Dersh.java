package Personajes;

public class Dersh extends Personaje {
    public Dersh() {
        super("Dersh", 19, 19);
    }

    @Override
    public int ataque() {
        System.out.println("Dersh ataca con un Dershiyate");
        return 1;
    }

    @Override
    public boolean defensa() {
        if (Math.random() < 0.5) {
            System.out.println("Dersh se defiende con su Dershiyate");
            return true;
        } else {
            System.out.println();
            return false;
        }
    }

}
