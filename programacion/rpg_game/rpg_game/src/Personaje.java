
public class Personaje {
    static int clase;

    static int vida;
    static int mana;
    static int danoMelee;
    static int danoMagico;
    static int oro = 5;

    public static void datosClase(int claseEscogida) {
        switch (clase) {
            case 0:
                Mago();
                break;
            case 1:
                Guerrero();
                break;
            case 2:
                GuerreroMagico();
                break;
            case 3:
                Elfo();
                break;
            case 4:
                Alquimista();
                break;
        }

    }

    public static void Mago() {
        vida = 40;
        mana = 100;
        danoMelee = 4;
        danoMagico = 18;

        System.out.println("Vida:" + vida);
        System.out.println("Mana: " +mana);
        System.out.println("Daño físico: " + danoMelee);
        System.out.println("Daño mágico: " +danoMagico);

    }

    public static void Guerrero() {
        vida = 100;
        mana = 0;
        danoMelee = 18;
        danoMagico = 0;

        System.out.println("Vida:" + vida);
        System.out.println("Mana: " +mana);
        System.out.println("Daño físico: " +danoMelee);
        System.out.println("Daño mágico: " +danoMagico);
    }

    public static void GuerreroMagico() {
        vida = 70;
        mana = 50;
        danoMelee = 9;
        danoMagico = 9;

        System.out.println("Vida:" + vida);
        System.out.println("Mana: " +mana);
        System.out.println("Daño físico: " +danoMelee);
        System.out.println("Daño mágico: " +danoMagico);
    }

    public static void Elfo() {
        vida = 60;
        mana = 80;
        danoMelee = 8;
        danoMagico = 12;

        System.out.println("Vida:" + vida);
        System.out.println("Mana: " + mana);
        System.out.println("Daño físico: " +danoMelee);
        System.out.println("Daño mágico: " +danoMagico);
    }

    public static void Alquimista() {
        vida = 50;
        mana = 70;
        danoMelee = 5;
        danoMagico = 15;

        System.out.println("Vida: " + vida);
        System.out.println("Mana: " + mana);
        System.out.println("Daño físico: " +danoMelee);
        System.out.println("Daño mágico: " +danoMagico);
    }

}
