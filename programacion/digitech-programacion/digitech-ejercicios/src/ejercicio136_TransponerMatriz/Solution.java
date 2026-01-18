package ejercicio136_TransponerMatriz;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        int num1 = print.nextInt();
        int num2 = print.nextInt();

        int[][] matrizNormal = new int[num1][num2];
        int[][] matrizRes = new int[num2][num1];

        for (int i = 0; i < num1; i++) {
            for (int j = 0; j < num2; j++) {
                matrizNormal[i][j] = print.nextInt();
            }
        }

        for (int i = 0; i < num1; i++) {
            for (int j = 0; j < num2; j++) {
                matrizRes[j][i] = matrizNormal[i][j];
            }
        }

        for (int i = 0; i < num2; i++) {
            for (int j = 0; j < num1; j++) {
                System.out.print(matrizRes[i][j] + " ");
            }
            System.out.println();
        }
    }
}
