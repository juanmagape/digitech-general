import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);


        while(true) {
            System.out.println("Introduce tu año de nacimiento");

            if (print.hasNextInt()) {
                int num = print.nextInt();

                if (num > 0) {
                    System.out.println("Numero válido, haciendo calculo...");
                    System.out.println( "Tienes " + (2025 - num) + " años");
                    break;

                } else {
                    System.out.println("Numero no valido");
                }
            } else {
                System.out.println("Numero no valido");
                print.next();
            }
        }
    }
}