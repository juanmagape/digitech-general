package ejercicio102_PrecioFerrocarril;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        float a = print.nextFloat();
        int b = print.nextInt();
        double precio = a * 0.35;

        if (b > 7 && a > 800) {
            double descuento = precio * 0.30;
            double precioFinal = precio - descuento;

            System.out.println(precioFinal);
        } else {
            System.out.println(precio);
        }
    }
}