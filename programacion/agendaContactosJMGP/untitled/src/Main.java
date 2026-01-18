import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws InterruptedException {

        Scanner print = new Scanner(System.in);
        boolean salir = true;
        String[] arrayNombre = new String[100];
        int[] arrayTelef = new int[100];
        int cantidadContactos = 0;
        
        while (salir) {

        System.out.println("\n===================== AGENDA DE CONTACTOS =====================\n");
        System.out.println("Escoge un número (1 - 4)\n");
        System.out.println("1: Añadir contactos");
        System.out.println("2: Mostrar contactos");
        System.out.println("3: Buscar contacto");
        System.out.println("4: Modificar contacto");
        System.out.println("5: Salir");

        int opcionEscogida = print.nextInt();
        print.nextLine();

            switch (opcionEscogida) {
                case 1:
                    System.out.println("Cuantos contactos quieres añadir? (MAX: 100)");
                    int numCon = print.nextInt();

                    if (cantidadContactos + numCon > 100) {
                        System.out.println("No hay espacio para tantos contactos.");
                        break;
                    }

                    print.nextLine(); // limpiar buffer

                    for (int i = 0; i < numCon; i++) {
                        System.out.println("Introduce el nombre del contacto:");
                        arrayNombre[cantidadContactos] = print.nextLine();

                        System.out.println("Introduce el teléfono:");
                        arrayTelef[cantidadContactos] = print.nextInt();
                        print.nextLine();

                        cantidadContactos++;
                    }


                    break;
                case 2:
                    System.out.println("Mostrando todos los contactos añadidos...");
                    for (int i = 0; i < cantidadContactos; i++) {
                        System.out.println(arrayNombre[i] + " - " + arrayTelef[i]);
                    }
                    Thread.sleep(3000);
                    break;
                case 3:
                    System.out.println("Quieres buscar el contacto por número o por nombre? (1 - 2)");
                    int busq = print.nextInt();

                    if (busq == 1) {
                        System.out.println("Introduce el nombre");
                        String busqNom = print.nextLine();
                    } else {
                        System.out.println("Introduce el número");
                        int busqNum = print.nextInt();
                    }

                    break;

                case 4:
                    System.out.println("Estos son tus contactos actuales");
                    for (int i = 0; i < cantidadContactos; i++) {
                        System.out.println(arrayNombre[i] + " - " + arrayTelef[i]);
                    }

                    System.out.println("Cual quieres editar?");
                    int contactoEditar = print.nextInt();
                    print.nextLine();
                    if (contactoEditar < cantidadContactos) {
                        System.out.println("Introduce el nuevo nombre: ");
                        arrayNombre[contactoEditar] = print.nextLine();

                        System.out.println("Introduce el nuevo telefono");
                        arrayTelef[contactoEditar] = print.nextInt();
                    } else {
                        System.out.println("Numero de contacto no válido");
                    }

                    break;
                case 5:
                    System.out.println("Saliendo del programa");
                    salir = false;
                    print.close();
                    break;
            }
        }

    }
}
