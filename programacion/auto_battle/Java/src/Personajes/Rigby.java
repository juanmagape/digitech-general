package Personajes;

public class Rigby extends Personaje{

    public Rigby() {
        super("Rigby", 3, 3);
    }

    @Override
    public int ataque() {
        return 7;
    }

    @Override
    public boolean defensa() {
        if (Math.random() < 0.5) {
            System.out.println("Se hace bolita");
            return true;
        } else {
            System.out.println();
            return false;
        }
    }
}
