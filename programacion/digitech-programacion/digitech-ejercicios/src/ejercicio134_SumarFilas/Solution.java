package ejercicio134_SumarFilas;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        int num1 = print.nextInt();
        int num2 = print.nextInt();

        int[][] matriz = new int[num1][num2];

        for (int i = 0; i < num1; i++) {
            int suma = 0;

            for (int j = 0; j < num2; j++) {
                matriz[i][j] = print.nextInt();
                suma += matriz[i][j];
            }
            System.out.println(suma);
        }
    }
}