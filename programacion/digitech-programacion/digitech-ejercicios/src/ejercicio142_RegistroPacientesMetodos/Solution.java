package ejercicio142_RegistroPacientesMetodos;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        String nombre = print.nextLine();
        String apellido = print.nextLine();
        int edad = print.nextInt();

        System.out.println("Paciente registrado");
        System.out.println("Nombre: " + nombre);
        System.out.println("Apellido: " + apellido);
        System.out.println("Edad: " + edad);

        System.out.println(Registro(edad));
    }

    static String Registro(int edad) {
        String categoria = "";

        if (edad >= 65) {
            categoria = "Categoria: ADULTO MAYOR";
        } else if (edad < 65 && edad >= 18) {
            categoria = "Categoria: ADULTO";
        } else if (edad < 18) {
            categoria = "Categoria: MENOR DE EDAD";
        }

        return categoria;
    }
}
