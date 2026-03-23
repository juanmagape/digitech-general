package Personajes;

public class fih extends Personaje {
    public fih () {
        super("fih", 4, 4);
    }

    @Override
    public int ataque() {
        System.out.println(getNombre() + " blupblup (+4 damage).");
        return 4;
    }

    @Override
    public boolean defensa() {
        if (Math.random() < 0.5) {
            System.out.println(getNombre() + " dries up!");
            return true;
        } else {
            System.out.println();
            return false;
        }
    }

}
