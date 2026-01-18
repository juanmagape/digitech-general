package ejercicio111_Trilero;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int dia = print.nextInt();
        int mes = print.nextInt();
        if (mes >= 12 && dia >= 21 || mes <= 3 && dia < 21) {
            System.out.println("Invierno");
            System.out.println("Verano");
        } else if (mes >= 9 && dia >= 23 || mes <= 12 && dia < 21) {
            System.out.println("Otono");
            System.out.println("Primavera");

        } else if (mes >= 6 && dia >= 21 || mes <= 9 && dia < 23) {
            System.out.println("Verano");
            System.out.println("Invierno");

        } else if (mes >= 3 && dia >= 21 || mes <= 6 && dia < 21) {
            System.out.println("Primavera");
            System.out.println("Otono");
        }
        }
}