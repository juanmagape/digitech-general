package ejercicio28_ElCaminoCircular;

import java.io.*;
import java.util.*;
import java.util.Scanner;


public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int radio = print.nextInt();
        double pi = 3.1416;

        double longitud = 2 * pi * radio;

        System.out.println((int)longitud);

    }
}
