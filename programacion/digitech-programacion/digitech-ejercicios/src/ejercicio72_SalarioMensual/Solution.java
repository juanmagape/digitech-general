package ejercicio72_SalarioMensual;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        double salarioAnual = print.nextDouble();
        double mensual = salarioAnual / 12;

        int resultado = (int) mensual;
        System.out.println(resultado);

    }
}