package pruebas;

import java.util.Scanner;

public class PruebasMatrices2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int[][] cine = new int[6][6];

        int filasConMasLibres = 0;
        int maxLibres = -1;
        int filaMaxLibres = 0;

        for (int i = 0; i < cine.length; i++) {

            int libres = 0;
            int ocupados = 0;

            for (int j = 0; j < cine[i].length; j++) {
                cine[i][j] = sc.nextInt();

                if (cine[i][j] == 0) {
                    libres++;
                } else {
                    ocupados++;
                }
            }

            if (libres > ocupados) {
                filasConMasLibres++;
            }

            if (libres > maxLibres) {
                maxLibres = libres;
                filaMaxLibres = i;
            }
        }

        System.out.println(filasConMasLibres);
        System.out.println(filaMaxLibres + 1);
    }
}