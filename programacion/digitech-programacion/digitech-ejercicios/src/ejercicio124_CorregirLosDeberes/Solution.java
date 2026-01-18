package ejercicio124_CorregirLosDeberes;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        int i = 0;

        while (true) {

            int dividendo = print.nextInt();
            int divisor = print.nextInt();
            int cociente = print.nextInt();
            int residuo = print.nextInt();

            if (dividendo == 0 && divisor == 0 && cociente == 0 && residuo == 0) {
                break;
            }

            i++;

            int cocienteCorrecto = dividendo / divisor;
            int residuoCorrecto = dividendo % divisor;

            if (cocienteCorrecto != cociente || residuoCorrecto != residuo) {
                System.out.println(i + ") " + cocienteCorrecto + " " + residuoCorrecto);
            }

        }
    }
}