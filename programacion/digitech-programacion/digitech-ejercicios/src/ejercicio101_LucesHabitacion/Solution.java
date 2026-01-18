package ejercicio101_LucesHabitacion;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        boolean a = print.nextBoolean();
        boolean b = print.nextBoolean();
        boolean c = print.nextBoolean();

        if (a || b || c) {
            System.out.println("Solo hay una luz encendida.");
        } else {
            System.out.println("No se ha encendido ninguna luz.");
        }
    }
}