package Examen03_Bucles;

import java.util.Scanner;

public class Solution3 {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int i = 0;
        int posicionAnterior = 0;

        while (true) {
            int posicionActual = print.nextInt();

            if (posicionActual == -1) {
                break;
            }

            if (posicionActual > posicionAnterior) {
                i++;
            }

            posicionAnterior = posicionActual;
        }

        System.out.println(i - 1);
    }
}
