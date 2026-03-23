package Personajes;

public class Meowl extends Personaje {
    public Meowl() {
        super("Meowl", 10, 10);
    }

    @Override
    public int ataque() {
        System.out.println(getNombre() + " sings 'New Soul' (+20 damage).");
        return 20;
    }

    @Override
    public boolean defensa() {
        if (Math.random() < 0.5) {
            System.out.println(getNombre() + " gets clipped....");
            return true;
        } else {
            System.out.println();
            return false;
        }
    }

}
