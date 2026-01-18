package ejercicio33_CalcularIMC1;

import java.io.*;
import java.util.*;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int imc;

        int peso = print.nextInt();
        int altura = print.nextInt();

        imc = peso / (altura * altura);

        System.out.println(imc);
    }
}
