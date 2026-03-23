package Personajes;

public class Unemployed extends Personaje{

    public Unemployed() {
        super("Unemployed", 15, 15);
    }

    @Override
    public int ataque() {
        return 10;
    }
    @Override
    public boolean defensa(){
        if (Math.random() < 0.5) {
            System.out.println("No cotiza el ataque");
            return true;
        } else {
            System.out.println();
            return false;
        }
    }


}
