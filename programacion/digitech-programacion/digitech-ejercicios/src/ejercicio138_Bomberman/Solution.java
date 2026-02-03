package ejercicio138_Bomberman;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        int filas = print.nextInt();
        int columnas = print.nextInt();

        int[][] tablero = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = print.nextInt();
            }
        }

        int bomba =  print.nextInt();

        int filaBomba = 0;
        int columnaBomba = 0;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (tablero[i][j] == bomba) {
                    filaBomba = i;
                    columnaBomba = j;
                }
            }
        }

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i == filaBomba || j == columnaBomba) {
                    System.out.print("@");
                } else {
                    System.out.print("#");
                }
            }
            System.out.println();
        }

    }
}
