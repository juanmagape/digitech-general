package ejercicio92_AtascoRondaDeDalt;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        int cantidadCoches = print.nextInt();
        int tiempo = print.nextInt();

        int cantidadTotal = cantidadCoches / tiempo;

        if (cantidadTotal <= 375) {
            System.out.println("No hay embudo");
        } else if (cantidadTotal > 375 && cantidadTotal < 425) {
            System.out.println("Embudo bajo");
        } else if (cantidadTotal > 425 && cantidadTotal < 575) {
            System.out.println("Embudo moderado");
        } else if (cantidadTotal > 575 && cantidadTotal < 625) {
            System.out.println("Embudo alto");
        }
    }
}