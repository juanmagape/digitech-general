package Personajes;

public class Piccolo extends Personaje{

    public Piccolo() {
        super("Piccolo", 20, 20);
    }

    @Override
    public int ataque() {
        return 5;
    }
    @Override
    public boolean defensa(){
        if (Math.random() < 0.5) {
            System.out.println("Farmea aura");
            return true;
        } else {
            System.out.println();
            return false;
        }
    }


}
