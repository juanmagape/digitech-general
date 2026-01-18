package ejercicio107_ElTimbreDelInstituto;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int hora = print.nextInt();
        int minutos = print.nextInt();

        String alarma = print.next();

        if (alarma.equals("manual") || alarma.equals("automatic") && minutos == 00) {
            System.out.println("RING");
        } else if (minutos != 00 && alarma.equals("automatic")) {
            System.out.println("---");
        }
    }
}