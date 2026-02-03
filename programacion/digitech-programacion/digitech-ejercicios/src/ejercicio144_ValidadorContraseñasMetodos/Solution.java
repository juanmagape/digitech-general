package ejercicio144_ValidadorContraseñasMetodos;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        String contraseñaIntro = print.nextLine();
        String contraseñaCorrecta = print.nextLine();

        System.out.println(ValidacionContraseña(contraseñaIntro, contraseñaCorrecta));
    }

    static String ValidacionContraseña(String contraseñaIntro, String contraseñaCorrecta) {

        if (contraseñaIntro.equals(contraseñaCorrecta)) {
            return "Acceso permitido";
        } else {
            return "Acceso denegado";
        }
    }

}
