package ejercicio21_JSON;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        String nombre = print.next();
        int edad = print.nextInt();
        String mail = print.next();
        boolean activo = print.nextBoolean();

        System.out.println("{");
        System.out.println("  \"nombre\": " + "\"" + nombre + "\",");
        System.out.println("  \"edad\": " + edad + "," );
        System.out.println("  \"email\": " + "\"" + mail + "\",");
        System.out.println("  \"activo\": " + activo);
        System.out.println("}");
    }
}

