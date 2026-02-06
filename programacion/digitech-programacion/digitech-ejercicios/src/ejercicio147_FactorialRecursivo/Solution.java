package ejercicio147_FactorialRecursivo;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int numero = print.nextInt();
        System.out.println(contar(numero));
    }

    public static int contar(int numero) {
        if (numero == 1) {
            return 1;}

        return numero * contar(numero - 1);
    }

}
