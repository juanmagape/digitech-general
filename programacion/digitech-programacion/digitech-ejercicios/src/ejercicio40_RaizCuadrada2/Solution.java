package ejercicio40_RaizCuadrada2;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);
        int inputRaiz = print.nextInt();

        float res = (float) Math.sqrt(inputRaiz);

        System.out.println(res);

    }
}


