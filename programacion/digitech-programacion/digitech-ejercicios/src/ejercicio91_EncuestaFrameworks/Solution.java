package ejercicio91_EncuestaFrameworks;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        System.out.println("Bienvenido a la encuesta.");
        System.out.println("Conoces algun framework?");

        String res = print.nextLine();

        if (res.equals("no")) {
            System.out.println("Gracias por contestar");
        } else {
            System.out.println("Cual?");
            String res2 = print.nextLine();

            System.out.println("Se ha registrado la respuesta: " + res2);
            System.out.println("Gracias por contestar");
        }
    }
}