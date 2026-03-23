package Personajes;

public class furryDeku extends Personaje {
    public furryDeku() {
        super("Furry Deku", 22, 22);
    }

    @Override
    public int ataque() {
        System.out.println("Furry Deku ataca con su poder de transformación en un animal feroz, lanzando un ataque devastador que causa un gran daño a sus enemigos.");
        return 8;
    }

    @Override
    public boolean defensa() {
        if (Math.random() < 0.5) {
            System.out.println("Furry Deku se defiende con su poder de transformación en un animal feroz, aumentando su resistencia y reduciendo el daño recibido.");
            return true;
        } else {
            System.out.println();
            return false;
        }
    }
}
