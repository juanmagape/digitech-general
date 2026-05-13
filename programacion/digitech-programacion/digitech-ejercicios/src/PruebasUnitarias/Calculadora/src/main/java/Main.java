import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("=======================================");
        System.out.println("============= Calculadora =============");
        System.out.println("=======================================");

        while (true) {
            System.out.println("\n=======================================");
            System.out.println("Ingrese el primer numero: ");
            float num1 = sc.nextFloat();

            System.out.println("Ingrese el segundo numero: ");
            float num2 = sc.nextFloat();
            System.out.println("=======================================");

            System.out.println("\n=======================================");
            System.out.println("Operaciones a realizar: ");
            System.out.println("[1] - SUMA");
            System.out.println("[2] - RESTA");
            System.out.println("[3] - DIVISION");
            System.out.println("[4] - MULTIPLICACION");
            System.out.println("[5] - SALIR");
            System.out.println("=======================================");

            System.out.println("Ingrese la operacion a realizar: ");
            int opc = sc.nextInt();

            switch (opc) {
                case 1:
                    Calculadora.suma(num1, num2);
                    break;

                case 2:
                    Calculadora.resta(num1, num2);
                    break;

                case 3:
                    Calculadora.division(num1, num2);
                    break;

                case 4:
                    Calculadora.multiplicacion(num1, num2);
                    break;
                case 5:
                    System.exit(0);
            }

        }
    }
}
