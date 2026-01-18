package ejercicio113_Intervalo2;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int num1 = print.nextInt();
        int num2 = print.nextInt();

        for (int i = num1; i < num2; i++) {
            System.out.print(i);
        }
    }
}