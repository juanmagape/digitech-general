import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Scanner print = new Scanner(System.in);

        String nombre = "";
        String skin = "";

        System.out.println("===========================================================\n");
        System.out.println("\n                      Tamagotchi                          \n");
        System.out.println("\n===========================================================\n");

        System.out.println("\n\n\n===========================================================\n");

        System.out.println("\nIntroduce el nombre de tu mascota:");
        nombre = print.nextLine();

        skin = skin(print);
        System.out.println("Antes de empezar a jugar te gustaría modificar algún elemento? (1: Si / 2: No)");
        int seguirPrograma = print.nextInt();

        if (seguirPrograma == 1) {
            modificar(print, nombre, skin);
        } else if (seguirPrograma == 2) {
            System.out.println("El juego empieza\n");
        } else {
            System.out.println("Número introducido incorrecto");
        }
        System.out.println("\n===========================================================\n\n");

        Acciones.acciones(print, skin, nombre);
    }

    public static String skin(Scanner print) throws InterruptedException {
        System.out.println("\n\n\n===========================================================\n");

        System.out.println("Escoge la skin de tu tamagotchi\n");

        System.out.println("{1} - 🐷");
        System.out.println("{2} - 🐬");
        System.out.println("{3} - 🐞");
        System.out.println("{4} - 🕊️");

        int skinEscogida = print.nextInt();

        System.out.println("\n\n\n===========================================================\n");


        switch (skinEscogida) {
            case 1: System.out.println("Has escogido 🐷"); return "🐷";
            case 2: System.out.println("Has escogido 🐬"); return "🐬";
            case 3: System.out.println("Has escogido 🐞"); return "🐞";
            case 4: System.out.println("Has escogido 🕊️"); return "🕊️";
            default: System.out.println("Opción inválida, se asigna 🐷"); return "🐷";
        }
    }

    public static void modificar(Scanner print, String nombre, String skin) throws InterruptedException {
        System.out.println("\n\n\n===========================================================\n");

        System.out.println("Que te gustaría modificar? (1: Nombre / 2: Skin)");
        int eleccionModificar = print.nextInt();
        Thread.sleep(1000);

        if (eleccionModificar == 1) {
            System.out.println("Nombre actual: " + nombre);
            System.out.println("Introduce tu nuevo nombre: ");

            nombre = print.nextLine();
            Thread.sleep(1000);

        } else if (eleccionModificar == 2) {
            skin = skin(print);
            Thread.sleep(1000);

        } else {
            System.out.println("Número introducido incorrecto");
            Thread.sleep(1000);

        }
        System.out.println("\n\n\n===========================================================\n");

    }

}