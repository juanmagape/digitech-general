import java.util.Scanner;

public class Main {
    static String nombre;
    static String clase;
    static int claseEscogida;

    public static void main(String[] args) throws InterruptedException {
        Programa();
    }

    public static void Programa() throws InterruptedException {
        Scanner print = new Scanner(System.in);

        String[] arrayClase = {"Mago", "Guerrero", "Guerrero magico", "Elfo", "Alquimista"};

        System.out.println("=================================================");
        System.out.println("============ Bienvenido al juego RPG ============");
        Thread.sleep(500);

        System.out.println("\nINTRODUCE EL NOMBRE DE TU PERSONAJE:");
        nombre = print.nextLine();
        System.out.println("==================================================");
        Thread.sleep(500);
        escogerClase(arrayClase, print);
        Personaje.datosClase(claseEscogida);

        Pelea.pelea(nombre, clase, print, Personaje.oro, Personaje.mana, Personaje.danoMagico, Personaje.danoMelee, Personaje.vida);
    }

    public static String escogerClase(String[] arrayClase, Scanner print) {
        System.out.println("\nESCOGE LA CLASE DE TU PERSONAJE:");
        for (int i = 0; i < arrayClase.length; i++) {
            System.out.println("[" + i + "] - " + arrayClase[i]);
        }

        claseEscogida = print.nextInt();

        switch (claseEscogida) {
            case 0:
                System.out.println("==================================================");
                System.out.println("\nHAS ESCOGIDO LA CLASE: Mago");
                System.out.println("\n==================================================");
                return clase = "Mago";
            case 1:
                System.out.println("==================================================");
                System.out.println("\nHAS ESCOGIDO LA CLASE: Guerrero");
                System.out.println("\n==================================================");
                return clase = "Guerrero";
            case 2:
                System.out.println("==================================================");
                System.out.println("\nHAS ESCOGIDO LA CLASE: Guerrero Magico");
                System.out.println("\n==================================================");
                return clase = "Guerrero Magico";
            case 3:
                System.out.println("==================================================");
                System.out.println("\nHAS ESCOGIDO LA CLASE: Elfo");
                System.out.println("\n==================================================");
                return clase = "Elfo";
            case 4:
                System.out.println("==================================================");
                System.out.println("\nHAS ESCOGIDO LA CLASE: Alquimista");
                System.out.println("\n==================================================");
                return clase = "Alquimista";
            default:
                System.out.println("==================================================");
                System.out.println("\nOpción inválida, por defecto se escoge la clase: Mago");
                System.out.println("\n==================================================");
                return clase = "Mago";
        }
    }
}
