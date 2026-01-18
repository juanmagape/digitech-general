package Examen03_Bucles;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int num1 = print.nextInt();
        int num2 = print.nextInt();

        while (true) {
            if (num1 > num2) {
                break;
            }

            System.out.println("Tabla del " + num1);
            for (int i = 1; i <= 10; i++) {
                System.out.println(num1 + " x " + i + " = " + (num1 * i));
            }

            if (num1 < num2) {
                System.out.println("");
            }
            num1++;

        }
    }
}