package ejercicio87_HoraApertura;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        String diaSemana = print.nextLine();

        if (diaSemana.equals("Lunes") || diaSemana.equals("Martes") || diaSemana.equals("Miercoles") || diaSemana.equals("Jueves") || diaSemana.equals("Viernes")) {
            System.out.println("8:00");
        } else {
            System.out.println("10:00");
        }

    }
}