package ejercicio99_ControlCalidad;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        boolean a = print.nextBoolean();
        boolean b = print.nextBoolean();
        boolean c = print.nextBoolean();
        boolean d = print.nextBoolean();
        boolean e = print.nextBoolean();

        String y = "correcto";
        String z = "defectuoso";


        if (a) {
            System.out.println("El estado del chasis es: " + y);
        } else {
            System.out.println("El estado del chasis es: " + z);

        }

        if (b) {
            System.out.println("El estado de las ruedas es: " + y);
        }else {
            System.out.println("El estado de las ruedas es: " + z);

        }
        if (c) {
            System.out.println("El estado del motor es: " + y);
        } else {
            System.out.println("El estado del motor es: " + z);

        }
        if (d) {
            System.out.println("El estado de la electronica es: " + y);
        } else {
            System.out.println("El estado de la electronica es: " + z);

        }

        if (e) {
            System.out.println("El estado de las luces es: " + y );
        } else {
            System.out.println("El estado de las luces es: " + z);
        }


        if (a && b && c && d && e) {
            System.out.println("El estado general del coche es: " + y);
        } else {
            System.out.println("El estado general del coche es: " + z);

        }
    }
}