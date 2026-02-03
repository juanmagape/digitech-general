package pruebas;

import java.util.Scanner;

public class PruebasMatrices3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int filas =  sc.nextInt();
        int columnas = sc.nextInt();
        int filasPrimera = -1;
        int columnasPrimera = -1;
        int zonasInfectadas = 0;

        int[][] ciudad = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                ciudad[i][j] = sc.nextInt();
            }
        }

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (i > 0 && i < filas - 1 && j > 0 && j < columnas - 1) {
                    if (ciudad[i][j] > ciudad[i - 1][j] && ciudad[i][j] > ciudad[i + 1][j] && ciudad[i][j] > ciudad[i][j - 1] && ciudad[i][j] > ciudad[i][j + 1]) {
                        if (filasPrimera == -1 && columnasPrimera == -1) {
                            filasPrimera = i;
                            columnasPrimera = j;
                        }
                        zonasInfectadas++;
                    }
                }
            }
        }

        System.out.println((filasPrimera +1)+ " " + (columnasPrimera +1));
        System.out.println(zonasInfectadas);
    }
}
