package Personajes;
public class Bob extends Personaje {
    public Bob() {
        super("Bob", 17, 17);
    }

    @Override
    public int ataque() {
        System.out.println("Bob te ataca con su espátula.");
        return 13;
    }

    @Override
    public boolean defensa() {
        if (Math.random() < 0.5) {
            System.out.println("Bob se esta defendiendo");
            return true;
        } else {
            System.out.println();
            return false;
        }
    }

}
