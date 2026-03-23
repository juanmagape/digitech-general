package Personajes;

public class Trump extends Personaje {

    public Trump() {
        super("Trump",20, 20);
    }

    @Override
    public int ataque() {
        System.out.println(getNombre() + " ha mandado a sus tropas y ha hecho 10 de daño.");
        return 10;
    }

    @Override
    public boolean defensa() {
        if (Math.random() < 0.5) {
            System.out.println("El ICE defendió a " + getNombre());
            return true;
        } else {
            System.out.println();
            return false;
        }
    }
}
