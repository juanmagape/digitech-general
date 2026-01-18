import java.util.InputMismatchException;
import java.util.Scanner;

public class Banco {
    public static void main(String[] args) throws InterruptedException {
        Scanner print = new Scanner(System.in);
        boolean programa = true;
        int dineroActual = 0;

        System.out.println("\nBienvenido al banco.");

        while(programa) {
            System.out.println("Que acción quieres realizar?.");
            Thread.sleep(500);

            System.out.println("\n\n1 - Añadir dinero");
            System.out.println("2 - Sacar dinero");
            System.out.println("3 - Ver dinero actual");
            System.out.println("4 - Salir");
            Thread.sleep(1000);
            int opcionEscogida = 0;

            try {
                opcionEscogida = print.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Indtroduce valores correctos, ha de ser un número del 1 al 4");
            }

            switch (opcionEscogida) {
                case 1:
                    System.out.println("Has escogido la opción añadir dinero");
                    System.out.println("\n\nIntroduce la cantidad a añadir (MIN: 10 / MAX: 10000)");

                    try {
                        int añadirDinero = print.nextInt();

                        if (añadirDinero < 10 || añadirDinero > 10000) {
                            throw new Exception("Para añadir dinero debe ser mas de 10 o menos de 10000");
                        } else {
                            dineroActual = dineroActual + añadirDinero;
                        }
                    } catch (Exception e) {
                        System.out.println(e);
                    }
                    Thread.sleep(1000);
                    break;
                case 2:
                    System.out.println("Has escogido la opción de sacar dinero.");
                    System.out.println("Actualmente tienes: " + dineroActual);

                    if (dineroActual == 0) {
                        System.out.println("Tu dinero actual es 0, no puedes sacar dinero.");
                    } else {
                        System.out.println("Introduce la cantidad a sacar");


                        try {
                            int dineroSacar = print.nextInt();

                            if (dineroSacar > dineroActual) {
                                throw new Exception("Error. Estás intentando sacar más dinero del que tienes.");
                            } else if (dineroSacar < 0) {
                                throw new Exception("Error, no puedes sacar dinero menor a 0");
                            } else {
                                dineroActual = dineroActual - dineroSacar;
                            }
                        } catch (Exception e) {
                            System.out.println(e);
                        }
                    }
                    Thread.sleep(1000);
                    break;
                case 3:
                    System.out.println("Actualmente tienes: " + dineroActual);
                    Thread.sleep(1000);
                    break;
                case 4:
                    programa = false;
                    break;
                default:
                    System.out.println("Error, introduce un número del 1 - 4");
                    break;
            }



        }
    }
}
