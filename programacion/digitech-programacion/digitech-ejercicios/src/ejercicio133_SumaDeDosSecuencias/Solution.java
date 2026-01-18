package ejercicio133_SumaDeDosSecuencias;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        int numSec1 = print.nextInt();
        int[] secuencia1 = new int[numSec1];

        for (int i = 0; i < numSec1; i++) {
            secuencia1[i] = print.nextInt();
        }

        int numSec2 = print.nextInt();
        int[] secuencia2 = new int[numSec2];

        for (int i = 0; i < numSec2; i++) {
            secuencia2[i] = print.nextInt();
        }

        for (int i = 0; i < numSec1; i++) {
            System.out.print(secuencia1[i] + secuencia2[i] + " ");
        }
    }
}