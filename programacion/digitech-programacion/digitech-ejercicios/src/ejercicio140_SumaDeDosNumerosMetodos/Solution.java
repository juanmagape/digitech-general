package ejercicio140_SumaDeDosNumerosMetodos;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        int num1 = print.nextInt();
        int num2 = print.nextInt();

        System.out.println(Suma(num1, num2));
    }

    static int Suma(int num1, int num2) {
        return num1 + num2;
    }
}
