package Personajes;

public class Osaka extends Personaje {

    public Osaka () {
        super("Osaka",8, 8);
    }

    @Override
    public int ataque() {
        System.out.println(getNombre() + " ha hecho un ataque japones y ha hecho 10 de daño.");
        return 10;
    }

    @Override
    public boolean defensa() {
        if (Math.random() < 0.5) {
            System.out.println(getNombre() + " lanzó un rollito de primavera al rival.");
            return true;
        } else {
            System.out.println();
            return false;
        }
    }
}
