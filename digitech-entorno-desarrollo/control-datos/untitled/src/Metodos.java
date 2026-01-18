import java.util.InputMismatchException;
import java.util.Scanner;

public class Metodos {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        String[] palabras = {"java", "linux", "lexico", "farmaceutico", "ordenador", "programa", "pantalla", "raton", "servidor", "nube", "cable", "red", "router", "teclado"};
        int palabraAleatoria = (int) (Math.random() * 5);

        String palSele = palabras[palabraAleatoria];

        jugarAhorcado(palSele, print);
    }

    public static void jugarAhorcado(String palabra, Scanner print) {
        char[] pal = new char[palabra.length()];
        for (int i = 0; i < pal.length; i++) pal[i] = '_';


        while (true) {
            System.out.println("Palabra: " + new String(pal));
            System.out.print("Letra: ");

            char letra;

            try {
                letra = print.nextLine().charAt(0);
            } catch (Exception e) {
                System.out.println("Error, introduce una letra. " + e);
                continue;
            }

            boolean acierto = false;

            for (int i = 0; i < palabra.length(); i++) {
                if (palabra.charAt(i) == letra) {
                    pal[i] = letra;
                    acierto = true;
                }
            }

            if (new String(pal).equals(palabra)) {
                System.out.println("\n¡Has ganado! La palabra era: " + palabra);
                break;
            }

            if (!acierto) {
                System.out.println("Letra incorrecta");
            }
        }
    }
}
