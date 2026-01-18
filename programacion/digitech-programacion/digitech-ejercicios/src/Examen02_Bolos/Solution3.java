package Examen02_Bolos;
import java.util.Scanner;

public class Solution3 {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        float dinero = print.nextFloat();
        float precio = print.nextFloat();
        String producto = print.next();
        int deposito = print.nextInt();

        boolean puedeComprar = dinero >= precio && deposito >= 50;
        boolean productosDisp = producto.equals("Fanta") || producto.equals("Cocacola");
        System.out.println(puedeComprar && productosDisp);

    }
}