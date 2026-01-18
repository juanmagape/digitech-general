package ejercicio17_ContratarUnDesarrollador;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        String nombre = print.next();
        int edad = print.nextInt();
        String ocupacion = print.next();
        int experiencia = print.nextInt();
        String lenguaje = print.next();

        System.out.println("El formulario de " + nombre + " se ha completado. Te contactaremos si necesitamos un programador de " + lenguaje + ".");
    }
}
