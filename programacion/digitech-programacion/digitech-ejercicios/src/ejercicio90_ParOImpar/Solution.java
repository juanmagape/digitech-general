package ejercicio90_ParOImpar;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        int num = print.nextInt();

        boolean res = num % 2==0;

        if (res) {
            System.out.println("El numero " + num + " es par");
        } else {
            System.out.println("El numero " + num + " es impar");
        }
    }
}