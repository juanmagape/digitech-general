package ejercicio34_CalcularAlmacen;

import java.io.*;
import java.util.*;
import java.util.Scanner;


public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int productos = print.nextInt();
        int productosEnCajas = print.nextInt();

        int cajasLlenas = productos / productosEnCajas;
        int productosSueltos = productos % productosEnCajas;


        System.out.println(cajasLlenas + " " + productosSueltos);    }
}
