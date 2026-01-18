package ejercicio39_potencias;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);
        int inputN1 = print.nextInt();
        int inputN2 = print.nextInt();

        float res = (float) Math.pow(inputN1, inputN2);

        System.out.println(res);

    }
}


