package ejercicio94_Balatro;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int a = print.nextInt();
        int b = print.nextInt();
        int c = print.nextInt();

        if (a == b && a == c) {
            System.out.println("THREE OF A KIND");
        } else if (a + 1 == b && a + 2 == c || a + 2 == b && a + 1 == c) {
            System.out.println("STRAIGHT");
        } else if (a == b || a == c ) {
            System.out.println("PAIR");
        } else {
            System.out.println("HIGH CARD");
        }

    }
}
