package ejercicio73_palindromo;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        String linea1 = print.nextLine();

        char res1 = linea1.charAt(0);
        char res2 = linea1.charAt(1);
        char res3 = linea1.charAt(2);
        char res4 = linea1.charAt(3);
        char res5 = linea1.charAt(4);

        boolean resultadoFinal = res1 == res5 && res2 == res4;
        System.out.println(resultadoFinal);

    }
}