package Examen04_Matrices;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int filas  = sc.nextInt();
        int columnas = sc.nextInt();
        int nenufarSeguro = 0;


        String[][] estanque = new String[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                estanque[i][j] = sc.next();
            }
        }

        for (int i = 1; i < filas - 1; i++) {
            for (int j = 1; j < columnas - 1; j++) {
                if (estanque[i][j].equals("N")) {

                    if (i == columnas) {
                        if (!estanque[i + 1][j].equals("P") && !estanque[i][j + 1].equals("P")) {
                            nenufarSeguro++;
                        }
                    } else if (!estanque[i - 1][j].equals("P") && !estanque[i + 1][j].equals("P") && !estanque[i][j - 1].equals("P") && !estanque[i][j + 1].equals("P")) {
                        nenufarSeguro++;
                    }

                    if (filas == j) {
                        if (!estanque[i - 1][j].equals("P") && !estanque[i][j - 1].equals("P")) {
                            nenufarSeguro++;
                        }
                    } else if (!estanque[i - 1][j].equals("P") && !estanque[i + 1][j].equals("P") && !estanque[i][j - 1].equals("P") && !estanque[i][j + 1].equals("P")) {
                        nenufarSeguro++;
                    }


                }
            }
        }

        System.out.println(nenufarSeguro);

    }
}
