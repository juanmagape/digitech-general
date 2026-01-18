package ejercicio95_Paella;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        double comensales = print.nextDouble();
        double precioKArroz = print.nextDouble();
        double precioKGambas = print.nextDouble();

        double cantidadArroz = comensales * 0.125;
        double cantidadGambas = comensales * 0.0625;
        double precioArroz = cantidadArroz * precioKArroz;
        double precioGambas = cantidadGambas * precioKGambas;
        double precioTotal =  precioArroz + precioGambas;

        System.out.println(cantidadArroz + " kg arroz");
        System.out.println(cantidadGambas + " kg gambas");
        System.out.println(precioArroz + " euros arroz");
        System.out.println(precioGambas + " euros gambas");
        System.out.println("TOTAL: " + precioTotal + " euros");
    }
}