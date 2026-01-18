package ejercicio108_ComidasRestaurante;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int numMenu = print.nextInt();
        int a = print.nextInt();
        int b = print.nextInt();

        int suma = a + b;

        switch (numMenu) {
            case 1:
                System.out.println("MENU:");
                System.out.println("1.- DESAYUNOS");
                System.out.println("2.- COMIDAS");
                System.out.println("3.- MERIENDAS");
                System.out.println("4.- CENAS");

                System.out.println("\nTotal DESAYUNOS del restaurante A y B: " + suma);
                break;
            case 2:
                System.out.println("MENU:");
                System.out.println("1.- DESAYUNOS");
                System.out.println("2.- COMIDAS");
                System.out.println("3.- MERIENDAS");
                System.out.println("4.- CENAS");

                System.out.println("\nTotal COMIDAS del restaurante A y B: " + suma);

                break;
            case 3:
                System.out.println("MENU:");
                System.out.println("1.- DESAYUNOS");
                System.out.println("2.- COMIDAS");
                System.out.println("3.- MERIENDAS");
                System.out.println("4.- CENAS");

                System.out.println("\nTotal MERIENDAS del restaurante A y B: " + suma);

                break;
            case 4:
                System.out.println("MENU:");
                System.out.println("1.- DESAYUNOS");
                System.out.println("2.- COMIDAS");
                System.out.println("3.- MERIENDAS");
                System.out.println("4.- CENAS");

                System.out.println("\nTotal CENAS del restaurante A y B: " + suma);

                break;
            default:
                System.out.println("MENU:");
                System.out.println("1.- DESAYUNOS");
                System.out.println("2.- COMIDAS");
                System.out.println("3.- MERIENDAS");
                System.out.println("4.- CENAS");

                System.out.println("\nOPCION INEXISTENTE !!");
                break;
        }
    }


}