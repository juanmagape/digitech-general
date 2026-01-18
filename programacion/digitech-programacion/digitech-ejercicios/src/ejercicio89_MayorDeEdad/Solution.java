package ejercicio89_MayorDeEdad;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        String nom = print.nextLine();
        int edad = print.nextInt();

        if (edad >= 18) {
            System.out.println(nom + " es mayor de edad");
        } else {
            System.out.println(nom + " no es mayor de edad");
        }
    }
}