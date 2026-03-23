package Personajes;

public class Morf extends Personaje {

    public Morf() {
        super("Morf",5, 5);
    }

    @Override
    public int ataque() {
        System.out.println(getNombre() + " ha atacado y ha hecho 5 de daño.");
        return 5;
    }

    @Override
    public boolean defensa() {
        if (Math.random() < 0.5) {
            System.out.println(getNombre() + " ha drogado al rival");
            return true;
        } else {
            System.out.println();
            return false;
        }
    }
}
