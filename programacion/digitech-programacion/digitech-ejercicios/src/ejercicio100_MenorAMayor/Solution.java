package ejercicio100_MenorAMayor;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int a = print.nextInt();
        int b = print.nextInt();
        int c = print.nextInt();

        if (a + 1 == b && a + 2 == c) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}