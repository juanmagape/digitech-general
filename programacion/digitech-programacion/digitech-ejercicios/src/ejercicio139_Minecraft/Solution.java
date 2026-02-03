package ejercicio139_Minecraft;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        int filas = 3;
        int columnas = 9;
        int cantidadTotal = 0;

        int columna = 0;
        int fila = 0;
        int cantidadMaxima = 0;

        int[][] tablero = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                tablero[i][j] = print.nextInt();
                cantidadTotal += tablero[i][j];

                if (tablero[i][j] > cantidadMaxima) {
                    cantidadMaxima = tablero[i][j];
                    columna = j;
                    fila = i;
                }
            }
        }

        System.out.println(cantidadTotal);
        System.out.println((fila + 1)  + " " + (columna + 1));
    }
}
