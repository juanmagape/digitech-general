package ejercicio85_Terminacion;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        String palabra = print.nextLine();
        char palabra2 = print.next().charAt(0);

        char ultimoChar = palabra.charAt(3);
        System.out.println(palabra2 == ultimoChar);

    }
}