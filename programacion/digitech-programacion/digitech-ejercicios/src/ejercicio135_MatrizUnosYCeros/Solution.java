package ejercicio135_MatrizUnosYCeros;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        int num1 = print.nextInt();
        int num2 = print.nextInt();

        int[][] matriz = new int[num1][num2];

        for (int i = 0; i < num1; i++) {
            for (int j = 0; j < num2; j++) {
                matriz[i][j] = print.nextInt();
            }
        }

        int columna = -1;

        for (int columnas = 0; columnas < num2; columnas++) {
            boolean iguales = true;
            int num = matriz[0][columnas];

            for (int i = 1; i < num1; i++) {
                if (matriz[i][columnas] != num) {
                    iguales = false;
                    break;
                }
            }

            if (iguales) {
                columna = columnas;
                break;
            }
        }

        if (columna != -1) {
            System.out.println("La columna " + columna + " te tots els numeros iguals.");
        } else {
            System.out.println("No hi ha cap columna amb els numeros iguals.");
        }
    }
}
