package ejercicio77_PrimeraAparicion;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        String palabra = print.nextLine();
        char car = print.next().charAt(0);

        int res = palabra.indexOf(car);
        System.out.println(res);
    }
}