package ejercicio128_AlturaMinima;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int num = print.nextInt();
        float [] array = new float[num];

        for (int i = 0; i < num; i++) {
            array[i] = print.nextFloat();
        }

        float alturaMin = print.nextFloat();

        for (int i = 0; i < num; i++) {
            if (array[i] >= alturaMin) {
                System.out.println("SI");
            } else {
                System.out.println("NO");
            }
        }
    }
}