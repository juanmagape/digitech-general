package Personajes;

public class PerroMetralleta extends Personaje {

    public PerroMetralleta() {
        super("PerroMetralleta", 8, 8);
    }

    @Override
    public int ataque() {
        return 10;
    }

    @Override
    public boolean defensa() {
        if (Math.random() < 0.5) {
            System.out.println("Ha usado su AK-47 para protegerse");
            return true;
        } else {
            System.out.println();
            return false;
        }
    }

}
