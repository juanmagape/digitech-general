package ejercicio82_NoMeGrites;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        String linea1 = print.nextLine();
        String linea2 = print.nextLine();
        String linea3 = print.nextLine();
        String linea4 = print.nextLine();

        System.out.println(linea1);
        System.out.println(linea2);
        System.out.println(linea3.toUpperCase());
        System.out.println(linea4);
    }
}