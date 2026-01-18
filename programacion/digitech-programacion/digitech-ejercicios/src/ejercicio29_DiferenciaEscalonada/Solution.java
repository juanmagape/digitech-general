package ejercicio29_DiferenciaEscalonada;

import java.io.*;
import java.util.*;
import java.util.Scanner;


public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int numero = print.nextInt();
        int resultado = (numero * numero) - ((numero - 1) * 2);

        System.out.println(resultado);    }
}
