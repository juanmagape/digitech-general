package ejercicio132_TipoDeLibro;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        int num = print.nextInt();
        print.nextLine();

        int[] cantidad = new int[num];
        String[] nombreLibro = new String[num];

        for (int i = 0; i < num; i++) {
            nombreLibro[i] = print.next();
        }

        for (int i = 0; i < num; i++) {
            cantidad[i] = print.nextInt();
        }

        int minimo = cantidad[0];
        for (int i = 1; i < cantidad.length; i++) {
            if (cantidad[i] < minimo) {
                minimo = cantidad[i];
            }
        }
        System.out.println("el listado de libros que menos tenemos son:");
        for (int i = 0; i < num; i++) {
            if (cantidad[i] == minimo) {
                System.out.println(nombreLibro[i] + " " + cantidad[i]);
            }
        }
    }
}