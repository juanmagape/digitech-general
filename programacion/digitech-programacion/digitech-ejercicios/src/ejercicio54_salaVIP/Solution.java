package ejercicio54_salaVIP;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        int edad = print.nextInt();
        boolean paseVip = print.nextBoolean();
        String vestimentaElegante = print.next();
        boolean organizador = print.nextBoolean();


        boolean valorFinal = (edad >= 18 && paseVip && vestimentaElegante.equals("elegante") || organizador);

        System.out.println(valorFinal);

    }
}



