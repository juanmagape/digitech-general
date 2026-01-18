package ejercicio131_BuscarLetras;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        char letraContar = print.next().charAt(0);
        print.nextLine();
        String palabra = print.nextLine();
        char[] array = palabra.toCharArray();
        int contar = 0;

        for (int i = 0; i < array.length; i++) {
            if (array[i] == letraContar) { contar = contar + 1;
            }
        }
        System.out.println(contar);
    }
}