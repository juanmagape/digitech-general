package ejercicio130_MazoDeClashRoyale;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        int num = 8;
        int numElixir = 0;

        int[] cartaElixir = new int[num];

        for (int i = 0; i < num; i++) {
            cartaElixir[i] = print.nextInt();
            numElixir = numElixir + cartaElixir[i];
        }

        System.out.println("--- Mazo de Clash Royale ---");
        for (int i = 0; i < num; i++) {
            System.out.printf("Carta %d: %s elixir%n", (i + 1), cartaElixir[i]);
        }

        float costeMedio = (float) numElixir / 8;

        System.out.println("\nCoste medio del mazo: " + costeMedio + " elixir");


    }
}