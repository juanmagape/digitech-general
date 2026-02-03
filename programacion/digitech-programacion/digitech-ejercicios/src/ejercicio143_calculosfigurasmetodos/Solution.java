package ejercicio143_calculosfigurasmetodos;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        String figura = print.nextLine();
        int valor = 0;
        int valor2 = 0;

        if (figura.equals("circulo")) {
            valor = print.nextInt();
            System.out.printf("Area del circulo: %.2f%n", CalculoCirculo(valor));
        } else if (figura.equals("triangulo")) {
            valor = print.nextInt();
            valor2 = print.nextInt();
            System.out.println("Area del triangulo: " + CalculoTriangulo(valor, valor2));
        }  else if (figura.equals("cuadrado")) {
            valor = print.nextInt();
            System.out.println("area del cuadrado: " + CalculoCuadrado(valor));
        }

    }

    static double CalculoCirculo(int valor) {
        return (valor * valor) * Math.PI;
    }

    static double CalculoTriangulo(int valor, int valor2) {
        return (double) (valor * valor2) / 2;
    }

    static double CalculoCuadrado(int valor) {
        return valor * valor;
    }
}
