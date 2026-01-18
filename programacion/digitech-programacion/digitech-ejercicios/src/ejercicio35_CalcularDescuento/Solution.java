package ejercicio35_CalcularDescuento;

import java.io.*;
import java.util.*;
import java.util.Scanner;


public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int producto = print.nextInt();
        int descuentoAplicado = print.nextInt();

        int precioTotal = producto - (producto * descuentoAplicado / 100);

        System.out.println(precioTotal);
    }
}
