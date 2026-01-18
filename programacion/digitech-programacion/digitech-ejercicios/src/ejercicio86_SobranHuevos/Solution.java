package ejercicio86_SobranHuevos;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        int huevos = print.nextInt();
        int hueveras;
        int faltan;

        if (huevos == 0) {
            hueveras = 0;
            faltan = 0;
        } else if (huevos % 24 == 0) {
            hueveras = 1;
            faltan = 0;
        } else {
            hueveras = (huevos / 24) + 1;
            faltan = 24 - (huevos % 24);
        }

        System.out.println(hueveras + " " + faltan);
    }
}