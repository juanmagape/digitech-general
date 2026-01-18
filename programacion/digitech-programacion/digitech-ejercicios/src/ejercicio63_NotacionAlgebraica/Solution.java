package ejercicio63_NotacionAlgebraica;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int a = print.nextInt();
        int b = print.nextInt();

        int xA = a + 96;
        char yA = (char) xA;

        System.out.print(yA);
        System.out.print(b);
    }
}