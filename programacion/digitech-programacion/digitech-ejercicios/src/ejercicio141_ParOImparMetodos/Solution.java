package ejercicio141_ParOImparMetodos;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        int num1 = print.nextInt();

        System.out.println(Comparacion(num1));
    }

    static String Comparacion(int num1) {
        if (num1 % 2 == 0) {
            return "PAR";
        } else {
            return "IMPAR";
        }
    }
}
