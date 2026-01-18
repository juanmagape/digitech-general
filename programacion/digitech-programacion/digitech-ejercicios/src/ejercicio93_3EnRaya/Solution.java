package ejercicio93_3EnRaya;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int num1Linea1 = print.nextInt();
        int num2Linea1 = print.nextInt();
        int num3Linea1 = print.nextInt();

        int num1Linea2 = print.nextInt();
        int num2Linea2 = print.nextInt();
        int num3Linea2 = print.nextInt();

        int num1Linea3 = print.nextInt();
        int num2Linea3 = print.nextInt();
        int num3Linea3 = print.nextInt();

        if (num1Linea1 == 1 && num2Linea1 == num1Linea1 && num3Linea1 == num2Linea1 || num1Linea1 == 1 && num2Linea2 == num1Linea1 && num3Linea3 == num1Linea1 || num1Linea1 == 1 && num1Linea2 == num1Linea1 && num1Linea3 == num1Linea1 || num3Linea1 == 1 && num3Linea3 == num3Linea1 && num3Linea2 == num3Linea1) {
            System.out.println("Jugador1");
        } else if (num1Linea3 == 2 && num2Linea3 == num1Linea3 && num3Linea3 == num1Linea3 || num3Linea1 == 2 && num2Linea2 == num3Linea1 && num2Linea2 == num1Linea3) {
            System.out.println("Jugador2");
        } else {
            System.out.println("Empate");
        }
    }
}
