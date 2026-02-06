package ejercicio148_PotenciaRecursiva;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int base = print.nextInt();
        int exponente = print.nextInt();
        System.out.println(contar(base, exponente));
    }

    public static int contar(int base, int exponente) {
        if (exponente == 0) {
            return 1;}

        return base * contar(base, exponente - 1);
    }
}
