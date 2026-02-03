package Examen04_Matrices;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int filas = sc.nextInt();
        int columnas = sc.nextInt();

        int[][] pokemon = new int[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                pokemon[i][j] = sc.nextInt();
            }
        }

        int indice1 =  sc.nextInt();
        int indice2 = sc.nextInt();

        if (pokemon[indice1][indice2] == 0) {
            System.out.println("NO EFFECT");
        } else if (pokemon[indice1][indice2] == 1) {
            System.out.println("NORMAL");
        } else if (pokemon[indice1][indice2] == 2) {
            System.out.println("SUPER EFFECTIVE");
        }
    }
}
