package PracticaHerencia.PersonajeDeVideojuego;

public class Main {
    static void main(String[] args) {
        Mago mago1 = new Mago("Mago", 130, 20, 30, 200, 30);
        Guerrero guerrero1 = new Guerrero("Guerrero", 200, 15, 30, 40, 30);

        while (mago1.getVida() > 0 && guerrero1.getVida() > 0) {

            int danoMago = Math.max(1, (mago1.getAtaque() + mago1.getPoderMagico()) - (guerrero1.getDefensa() + guerrero1.getArmadura()));
            guerrero1.setVida(guerrero1.getVida() - danoMago);
            System.out.println(mago1.getNombre() + " causa " + danoMago + " de daño.");

            if (guerrero1.getVida() <= 0) {
                break;
            }

            int danoGuerrero = Math.max(1, (guerrero1.getAtaque() + guerrero1.getFuerza()) - mago1.getDefensa());
            mago1.setVida(mago1.getVida() - danoGuerrero);
            System.out.println(guerrero1.getNombre() + " causa " + danoGuerrero + " de daño.");
        }

        if (mago1.getVida() > 0) {
            System.out.println("Gana " + mago1.getNombre());
        } else {
            System.out.println("Gana " + guerrero1.getNombre());
        }
    }
}
