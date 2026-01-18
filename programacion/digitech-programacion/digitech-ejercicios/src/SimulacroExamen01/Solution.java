package SimulacroExamen01;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        String ciudad = print.nextLine();
        String actividad = print.nextLine();
        String tiempo = print.nextLine();
        String poblacion = print.nextLine();


        System.out.println("Ciudad: " + ciudad);
        System.out.println("Tiempo: " + tiempo);
        System.out.println("Actividad: " + actividad);
        System.out.println("Poblacion: " + poblacion);
    }
}
