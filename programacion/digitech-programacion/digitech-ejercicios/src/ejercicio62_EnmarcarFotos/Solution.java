package ejercicio62_EnmarcarFotos;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        int num1 = print.nextInt();
        int num1_2 = print.nextInt();
        int cero1 = print.nextInt();
        int cero2 = print.nextInt();

        int num2 = print.nextInt();
        int num2_2 = print.nextInt();
        int cero3 = print.nextInt();
        int cero4 = print.nextInt();

        boolean coord = (num1 - num1_2) == (num2 - num2_2) && (cero1 - cero2) == (cero3 - cero4);
        System.out.println(coord);
    }
}