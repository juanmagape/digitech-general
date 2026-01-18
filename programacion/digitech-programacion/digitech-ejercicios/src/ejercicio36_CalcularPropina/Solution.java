package ejercicio36_CalcularPropina;

import java.io.*;
import java.util.*;
import java.util.Scanner;


public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        int euros = print.nextInt();
        int propina = print.nextInt();


        int precioTotal = euros + (euros * propina / 100);
        int porcentajePropina = euros * propina / 100;

        System.out.println(porcentajePropina + " " + precioTotal);
    }
}
