package ejercicio13_FichaMedica;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        String nombre = print.nextLine();
        String edad = print.nextLine();
        String genero = print.nextLine();
        String ciudad = print.nextLine();
        String sintoma = print.nextLine();

        System.out.println("El/la paciente " + nombre + ", de " + edad + " anos, con residencia en " + ciudad + ", acude al hospital por: " + sintoma);
    }
}
