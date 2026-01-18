package ejercicio80_SubdividirPalabra;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        String palabra = print.nextLine();

        String a = palabra.substring(0,3);
        String b = palabra.substring(1,2);
        String c = palabra.substring(1,3);
        String d = palabra.substring(3,4);
        String e = palabra.substring(5,6);

        System.out.println(a + b + c + d + e);
    }
}