package Personajes;

public class KokaLoka extends Personaje{

    public KokaLoka() {
        super("Koka Loka", 15, 15);
   }

    @Override
    public int ataque() {
        return 15;
    }

    @Override
    public boolean defensa() {
        if (Math.random() < 0.5) {
            System.out.println("Ha usado Escudo Real!");
            return true;
        } else {
            System.out.println();
            return false;
        }
    }


}
