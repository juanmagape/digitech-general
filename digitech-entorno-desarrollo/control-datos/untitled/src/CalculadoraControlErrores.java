import java.util.InputMismatchException;
import java.util.Scanner;

public class CalculadoraControlErrores {
    public static void main(String[] args) throws InterruptedException {
        Scanner print = new Scanner(System.in);
        boolean programa = true;

        while(programa) {
            System.out.println("--------------- Calculadora Basica ---------------\n");

            int opcionEscogida = 0;
            int num1 = 0;
            int num2 = 0;

            try {

                System.out.println("Introduce el primer número");
                num1 = print.nextInt();

                System.out.println("Introduce el primer número");
                num2 = print.nextInt();
                Thread.sleep(1000);

                if (num1 < 0 || num2 < 0) {
                    throw new Exception("No pueden ser números menores a 0");
                }

                System.out.println("\n\nOperaciones disponibles:");

                System.out.println("\n1 - Sumar (+)");
                System.out.println("2 - Restar (-)");
                System.out.println("3 - Dividir (/)");
                System.out.println("4 - Multiplicar (*)");
                System.out.println("5 - Salir");
                System.out.println("\nQue opción quiere realizar?");

                opcionEscogida = print.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nIntroduce valores correctos, han de ser números\n");
                print.nextLine();
                Thread.sleep(1000);
            } catch (Exception e) {
                System.out.println("No pueden ser menores a 0\n");
                Thread.sleep(1000);
            }


            switch (opcionEscogida) {
                case 1:
                    System.out.println("Operación: " + num1 + " + " + num2 + " = " + (num1 + num2));
                    Thread.sleep(1000);
                    break;
                case 2:
                    System.out.println("Operación: " + num1 + " - " + num2 + " = " + (num1 - num2));
                    Thread.sleep(1000);
                    break;
                case 3:
                    try {
                        System.out.println("Operación: " + num1 + " / " + num2 + " = " + (num1 / num2));
                    } catch (ArithmeticException e) {
                        System.out.println("\nNo se puede dividir entre cero");
                    }
                    Thread.sleep(1000);
                    break;
                case 4:
                    System.out.println("Operación: " + num1 + " * " + num2 + " = " + (num1 * num2));
                    Thread.sleep(1000);
                    break;
                case 5:
                    programa = false;
                    break;

                default:
                    System.out.println("Opción escogida incorrecta");
                    break;
            }




        }
    }
}
