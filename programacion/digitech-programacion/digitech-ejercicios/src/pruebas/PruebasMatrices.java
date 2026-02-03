package pruebas;

import java.util.Scanner;

public class PruebasMatrices {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        int fila = 4;
        int columna = 5;
        int[][] mazmorra = new int[fila][columna];


        int monedas = 0;
        int maxMonedas = 0;
        int filaMax = 0;
        int colMax = 0;

        for (int i = 0; i < fila; i++) {
            for (int j = 0; j < columna; j++) {
                mazmorra[i][j] = print.nextInt();
                monedas += mazmorra[i][j];

                if (mazmorra[i][j] > maxMonedas) {
                    maxMonedas = mazmorra[i][j];
                    filaMax = i;
                    colMax = j;
                }
            }
        }

        System.out.println("El moneda es: " + monedas);
        System.out.println("Fila: "  + (filaMax + 1) + " Colum: " + (colMax + 1));
    }

}
