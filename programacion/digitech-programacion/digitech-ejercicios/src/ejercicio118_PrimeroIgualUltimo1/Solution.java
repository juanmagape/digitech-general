package ejercicio118_PrimeroIgualUltimo1;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int primero = 0;
        int ultimo = 0;
        boolean primL = false;

        while (true) {
            int num = print.nextInt();

            if (num == 0) {
                break;
            }

            if (!primL) {
                primero = num;
                primL = true;
            }

            ultimo = num;
        }

        if (primero == ultimo) {
            System.out.println("SI");
        } else {
            System.out.println("NO");
        }
    }
}