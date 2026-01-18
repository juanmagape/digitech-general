package ejercicio66_SumaLetras;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        char a = print.next().charAt(0);
        char b = print.next().charAt(0);
        char c = print.next().charAt(0);
        char d = print.next().charAt(0);

        int xA = a;
        int xB = b;
        int xC = c;
        int xD = d;

        System.out.println(xA + xB + xC + xD);


    }
}