package ejercicio146_ContarHastaX;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int numero = print.nextInt();
        contar(numero);
    }

    public static void contar(int numero) {

        if (numero == 0) {
        } else {
            contar(numero - 1);
            System.out.print(numero + " ");
        }
    }

}
