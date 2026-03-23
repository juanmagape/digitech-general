package Personajes;

public class Jeffrey extends Personaje {

    public Jeffrey() {
        super("Jeffrey", 15, 15);
    }

    @Override
    public int ataque() {
        System.out.println("Jeffrey ha sacado a su orda de niños de la mansión y van a por ti.");
        return 5;
    }

    @Override
    public boolean defensa() {
        if (Math.random() < 0.5) {
            System.out.println("Jeffrey se defiende con su astucia y rapidez, esquivando los ataques enemigos y contraatacando con movimientos impredecibles.");
            return true;
        } else {
            System.out.println();
            return false;
        }
    }
}
