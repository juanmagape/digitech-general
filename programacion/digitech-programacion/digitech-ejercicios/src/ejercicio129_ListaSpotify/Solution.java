package ejercicio129_ListaSpotify;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        int num = print.nextInt();
        print.nextLine();

        float[] minutos = new float[num];
        String[] nombreCancion = new String[num];

        for (int i = 0; i < num; i++) {
            nombreCancion[i] = print.nextLine();
            minutos[i] = print.nextFloat();
            if (print.hasNextLine()) {
                print.nextLine();
            }
        }

        System.out.println("--- Lista de Spotify ---");
        for (int i = 0; i < num; i++) {
            System.out.printf("Cancion %d: %s - %.2f%n", (i + 1), nombreCancion[i], minutos[i]);

        }

        print.close();
    }
}