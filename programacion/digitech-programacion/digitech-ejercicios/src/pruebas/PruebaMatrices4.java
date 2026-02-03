package pruebas;

import java.util.Scanner;

public class PruebaMatrices4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int filas = sc.nextInt();
        int columnas = sc.nextInt();
        int cantidadDiv = filas * columnas;
        int sumaTotal = 0;


        int[][] lab = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                lab[i][j] = sc.nextInt();
                sumaTotal += lab[i][j];
            }
        }

        sumaTotal = sumaTotal/cantidadDiv;

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (lab[i][j] > sumaTotal) {}
            }
        }
    }
}
