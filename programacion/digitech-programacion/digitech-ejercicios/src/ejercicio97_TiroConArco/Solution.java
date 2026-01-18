package ejercicio97_TiroConArco;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int x = print.nextInt();
        int y = print.nextInt();

        if (x == 0 && y == 0) {
            System.out.println("5");
        } else if (x >= 5 && y >= 5 && x < 10 && y < 10) {
            System.out.println("4");
        } else {
            System.out.println("3");
        }
    }
}