package ejercicio48_Equilatero;

import java.util.Scanner;

public class Solution {
    public static void main() {
        Scanner sc = new Scanner(System.in);

        int lado1 = sc.nextInt();
        int lado2 = sc.nextInt();
        int lado3 = sc.nextInt();

        System.out.println(lado1 == lado2 && lado2 == lado3);
    }
}
