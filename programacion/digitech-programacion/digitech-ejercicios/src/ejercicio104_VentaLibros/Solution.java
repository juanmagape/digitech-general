package ejercicio104_VentaLibros;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        int num = print.nextInt();

        int a = num / 100;
        int b = (num / 10) % 10;
        int c = num % 10;
        int numTotal = a + b + c;

        System.out.println("La cantidad total de libros vendidos es: " + numTotal);
        if (a > b && a > c) {
            System.out.println("El dia con mas ventas ha sido: Viernes");
        } else if (b > a && b > c) {
            System.out.println("El dia con mas ventas ha sido: Sabado");
        } else if (c > a && c > b || c == b) {
            System.out.println("El dia con mas ventas ha sido: Domingo");
        }
    }
}