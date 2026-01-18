package ejercicio137_Buscaminas;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        int num1 = print.nextInt();
        int num2 = print.nextInt();

        int[][] matrizNormal = new int[num1][num2];

        for (int i = 0; i < num1; i++) {
            for (int j = 0; j < num2; j++) {
                matrizNormal[i][j] = print.nextInt();
            }
        }

        while (true) {
            int numLeer1 = print.nextInt() - 1;
            int numLeer2 = print.nextInt() - 1;

            if (numLeer1 == 0 && numLeer2 == 0) {
                break;
            }

            if (matrizNormal[numLeer1][numLeer2] == 1) {
                    System.out.println("SI");
            } else {
                    System.out.println("NO");
            }
        }

    }
}
