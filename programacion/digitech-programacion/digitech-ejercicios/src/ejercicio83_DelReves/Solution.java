package ejercicio83_DelReves;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        String linea1 = print.nextLine();

        char a1 = linea1.charAt(0);
        char a2 = linea1.charAt(1);
        char a3 = linea1.charAt(2);
        char a4 = linea1.charAt(3);

        System.out.println("" + a4 + a3 + a2 + a1);

    }
}