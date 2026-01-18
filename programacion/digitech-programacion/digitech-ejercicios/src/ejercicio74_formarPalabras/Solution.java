package ejercicio74_formarPalabras;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        String linea1 = print.nextLine();

        int a1 = print.nextInt();
        int a2 = print.nextInt();
        int a3 = print.nextInt();
        int a4 = print.nextInt();
        int a5 = print.nextInt();
        int a6 = print.nextInt();

        char res1 = (char) linea1.charAt(a1);
        char res2 = (char) linea1.charAt(a2);
        char res3 = (char) linea1.charAt(a3);
        char res4 = (char) linea1.charAt(a4);
        char res5 = (char) linea1.charAt(a5);
        char res6 = (char) linea1.charAt(a6);

        System.out.println("" + res1 + res2 + res3 + res4 + res5 + res6);

    }
}