package ejercicio37_CalcularBinario;

import java.io.*;
import java.util.*;
import java.util.Scanner;


public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int numero1 = print.nextInt() * 128;
        int numero2 = print.nextInt() * 64;
        int numero3 = print.nextInt() * 32;
        int numero4 = print.nextInt() * 16;
        int numero5 = print.nextInt() * 8;
        int numero6 = print.nextInt() * 4;
        int numero7 = print.nextInt() * 2;
        int numero8 = print.nextInt();

        int suma = numero1 + numero2 + numero3 + numero4 + numero5 + numero6 + numero7 + numero8;

        System.out.println(suma);    }
}
