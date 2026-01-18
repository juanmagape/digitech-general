import java.util.Scanner;

public class Pin {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);


        while(true) {
            System.out.println("Introduce tu nuevo Pin");

            if (print.hasNextInt()) {
                int num = print.nextInt();

                if (String.valueOf(num).length() == 4) {
                    System.out.println("Numero válido, verifica el numero pin");

                    while (true) {
                        int num2 = print.nextInt();

                        if (num == num2) {
                            System.out.println("Pin verificado");
                            break;

                        } else {
                            System.out.println("Pin no válido, porfavor intentalo de nuevo");
                        }
                    }
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