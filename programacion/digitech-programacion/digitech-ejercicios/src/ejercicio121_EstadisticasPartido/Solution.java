package ejercicio121_EstadisticasPartido;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int anteriorLocal = print.nextInt();
        int anteriorVisitante = print.nextInt();

        System.out.println("EMPIEZA EL PARTIDO, EMPATE: " + anteriorLocal + " " + anteriorVisitante);


        while (true) {
            int num1 = print.nextInt();
            int num2 = print.nextInt();

            if (num1 == -1 && num2 == -1) {
                if (anteriorLocal > anteriorVisitante) {
                    System.out.println("FINAL DEL PARTIDO, GANA LOCAL: " + anteriorLocal + " " + anteriorVisitante);
                    break;
                } else if (anteriorLocal < anteriorVisitante) {
                    System.out.println("FINAL DEL PARTIDO, GANA VISITANTE: " + anteriorLocal+ " " + anteriorVisitante);
                } else {
                    System.out.println("FINAL DEL PARTIDO, EMPATE: " + anteriorLocal+ " " + anteriorVisitante);
                }
                break;
            }

            if (num1 > anteriorLocal) {
                if (num1 > num2) {
                    System.out.println("GOL LOCAL, GANA LOCAL: " + num1+ " " + num2);
                } else if (num2 == num1) {
                    System.out.println("GOL LOCAL, EMPATE: " + num1+ " " + num2);
                } else {
                    System.out.println("GOL LOCAL, GANA VISITANTE: " + num1+ " " + num2);
                }
            }

            if (num2 > anteriorVisitante) {
                if (num1 < num2) {
                    System.out.println("GOL VISITANTE, GANA VISITANTE: " + num1+ " " + num2);
                } else if (num2 == num1) {
                    System.out.println("GOL VISITANTE, EMPATE: " + num1+ " " + num2);
                } else {
                    System.out.println("GOL VISITANTE, GANA LOCAL: " + num1+ " " + num2);
                }
            }

            anteriorLocal = num1;
            anteriorVisitante = num2;

        }
    }
}