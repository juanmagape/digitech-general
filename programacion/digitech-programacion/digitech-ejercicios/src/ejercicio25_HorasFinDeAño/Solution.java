package ejercicio25_HorasFinDeAño;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        int hora = print.nextInt();
        int minutos = print.nextInt();

        int tiempoFaltante = 1440 - (hora * 60 + minutos);

        System.out.println(tiempoFaltante);


    }
}