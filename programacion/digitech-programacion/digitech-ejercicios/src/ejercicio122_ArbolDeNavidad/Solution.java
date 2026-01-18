package ejercicio122_ArbolDeNavidad;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int entrada = print.nextInt();
        String x = "";

        for (int i = 0; i < entrada; i++) {

            int numeroAsteriscos = 2 * i + 1;
            int numeroEspacios = entrada - i - 1;

            for (int j = 0; j < numeroEspacios; j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < numeroAsteriscos; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        for (int i = 0; i < entrada; i++) {

            for (int j = 0; j < entrada - 1; j++) {
                System.out.print(" ");
            }
            System.out.println("|");
        }
    }
}