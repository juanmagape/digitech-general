package ejercicio52_contraseñaSecreta;
import java.util.Objects;
import java.util.Scanner;

public class Solution {
    public static void main() {
        Scanner sc = new Scanner(System.in);

        String palabra1 = "verde";
        String palabra2 = "rojo";
        String palabra3 = "azul";
        String palabra4 = "negro";

        String valor1 = sc.nextLine();
        String valor2 = sc.nextLine();
        String valor3 = sc.nextLine();

        boolean res = valor1.equalsIgnoreCase(palabra1) && !valor2.equalsIgnoreCase(palabra2) && valor3.equalsIgnoreCase(palabra3) || valor3.equalsIgnoreCase(palabra4);
        System.out.println(res);
    }
}
