package ejercicio149_FibonacciRecursivo;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int base = print.nextInt();
        System.out.println(contar(base));
    }

    public static int contar(int base) {
        if (base == 0) {
            return 0;
        } else if (base == 1) {
            return 1;
        }

        return contar(base - 1) + contar(base - 2);
    }
}
