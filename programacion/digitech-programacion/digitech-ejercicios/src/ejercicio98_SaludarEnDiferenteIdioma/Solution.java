package ejercicio98_SaludarEnDiferenteIdioma;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        String b = "";
        
        String a = print.nextLine();
        if (print.hasNextLine()) {
            b = print.nextLine();
        }

        switch (a) {
            case "French":
                System.out.println("Bonjour");
                break;
            case "Spanish":
                System.out.println("Hola");
                break;
            case "Russian":
                System.out.println("Zdravstvuyte");
                break;
            case "Chinese":
                System.out.println("Nin hao");
                break;

            default:
                System.out.println("No conozco tu idioma, como se dice hola?");
                System.out.println(b);
                break;
        }
    }
}