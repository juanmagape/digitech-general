package ejercicio116_BucleDePares;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int numV = print.nextInt();
        int num = 0;
        int res = 0;

        for (int i = 0; i < numV; i++) {
            num = print.nextInt();
            if (num % 2 == 0) {
                res = res + num;
                System.out.println(num);
            }
        }
        System.out.println("Suma: " + (res));

    }
}