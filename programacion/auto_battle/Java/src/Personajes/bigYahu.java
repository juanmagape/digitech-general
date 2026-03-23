package Personajes;

public class bigYahu extends Personaje {
    public bigYahu() {
        super("Big Yahu", 3, 3);

    }

    @Override
    public int ataque() {
        System.out.println("Big Yahu ataca te ataca con sus mochilas explosivas.");
        return 7;
    }

    @Override
    public boolean defensa() {
        if (Math.random() < 0.5) {
            System.out.println("Big Yahu se defiende con su gran tamaño y fuerza, absorbiendo el impacto de los ataques enemigos y reduciendo el daño recibido.");
            return true;
        } else {
            System.out.println();
            return false;
        }
    }
}
