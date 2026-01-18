package ejercicio20_AreaRectanguloYPerimetro;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        float base = print.nextFloat();
        float altura = print.nextFloat();

        float perimetro = base * 2 + altura * 2;
        System.out.println("Area: " + base * altura);
        System.out.println("Perimetro: " + perimetro);
    }
}

