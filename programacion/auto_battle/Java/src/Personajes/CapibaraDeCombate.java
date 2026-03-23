package Personajes;

public class CapibaraDeCombate extends Personaje{

    public CapibaraDeCombate() {
        super("Capibara de Combate", 10, 10);
    }

    @Override
    public int ataque() {
        return 15;
    }

    @Override
    public boolean defensa() {
        if (Math.random() < 0.5) {
            System.out.println("Ha llamado a Plex para que reciba el ataque en su lugar!");
            return true;
        } else {
            System.out.println();
            return false;
        }
    }
}
