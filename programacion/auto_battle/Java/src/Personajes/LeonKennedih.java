package Personajes;

public class LeonKennedih extends Personaje {
    public LeonKennedih() {
        super("Leon Kennedih", 10, 10);
    }

    @Override
    public int ataque() {
        System.out.println(getNombre() + " aura farms (+10 damage).");
        return 10;
    }

    @Override
    public boolean defensa() {
        if (Math.random() < 0.5) {
            System.out.println(getNombre() + " gets dihstroyed!");
            return true;
        } else {
            System.out.println();
            return false;
        }
    }

}
