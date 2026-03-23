package Personajes;

public class CarlosKirk extends Personaje {

    public CarlosKirk() {
        super("CarlosKirk", 10, 10);
    }

    @Override
    public int ataque() {
        return 5;
    }

    @Override
    public boolean defensa() {
        if (Math.random() < 0.5) {
            System.out.println("Esquiva el ataque y la bala");
            return true;
        } else {
            System.out.println();
            return false;
        }

    }
}
