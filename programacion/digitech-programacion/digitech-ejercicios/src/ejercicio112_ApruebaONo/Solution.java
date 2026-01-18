package ejercicio112_ApruebaONo;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int alumnos = print.nextInt();

        for (int i = 0; i < alumnos; i++) {
            String nom = print.next();
            String ape = print.next();

            float nota = print.nextFloat();

            if (nota >= 5.0) {
                System.out.println(nom + " " + ape + ": aprobado");
            } else {
                System.out.println(nom + " " + ape + ": suspende");
            }
        }

    }
}