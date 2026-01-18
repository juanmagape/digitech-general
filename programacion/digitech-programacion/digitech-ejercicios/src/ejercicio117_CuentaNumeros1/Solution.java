package ejercicio117_CuentaNumeros1;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int i;
        int num = 0;

        do {
            i = print.nextInt();
            if (i != 0) num++;
        } while (i != 0);

        System.out.println(num);
    }
}