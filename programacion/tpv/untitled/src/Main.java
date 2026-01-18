import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static int pan = 0;
    static int huevos = 0;
    static int aceite = 0;
    static int harina = 0;

    public static void main(String[] args) throws InterruptedException {
        Scanner print = new Scanner(System.in);

        String[] listaProductos = {"Pan", "Huevos", "Aceite", "Harina"};
        double[] precioProductos = {0.89, 2.50, 3.59, 1.32};
        ArrayList<String> carrito = new ArrayList<>(4);

        boolean seguirComprando = true;

        while (seguirComprando) {

            System.out.println("============================");
            System.out.println("[1] - Ver productos");
            System.out.println("[2] - Añadir productos");
            System.out.println("[3] - Ver carrito");
            System.out.println("[4] - Finalizar compra");
            System.out.println("[5] - Salir");
            System.out.println("============================");

            int opcionTPV = print.nextInt();

            switch (opcionTPV) {
                case 1:
                    VerProductos(listaProductos);
                    break;
                case 2:
                    AñadirProductos(print, listaProductos, carrito);
                    break;
                case 3:
                    VerCarrito(carrito);
                    break;
                case 4:
                    FinalizarCompra(precioProductos);
                    seguirComprando = false;
                    break;
                case 5:
                    System.out.println("Saliendo del supermercado");
                    seguirComprando = false;
                    break;
                default:
                    break;
            }
        }
    }

    public static void VerProductos(String[] listaProductos) {
        System.out.println("Productos disponibles:");

        for (int i = 0; i < listaProductos.length; i++) {
            System.out.println("[" + i + "] - " + listaProductos[i]);
        }
    }

    public static void AñadirProductos(Scanner print, String[] listaProductos, ArrayList<String> carrito) throws InterruptedException {

        boolean seguirAñadiendoP = true;

        while (seguirAñadiendoP) {

            System.out.println("Escoge el producto a añadir");
            for (int i = 0; i < listaProductos.length; i++) {
                System.out.println("[" + i + "] - " + listaProductos[i]);
            }
            System.out.println("[4] - Salir");

            int producto = print.nextInt();

            if (producto <= 3) {
                carrito.add(listaProductos[producto]);
            }

            switch (producto) {

                case 0:
                    System.out.println("Has añadido el producto pan al carrito");
                    Thread.sleep(1000);
                    break;
                case 1:
                    System.out.println("Has añadido el producto huevos al carrito");
                    Thread.sleep(1000);
                    break;
                case 2:
                    System.out.println("Has añadido el producto aceite al carrito");
                    Thread.sleep(1000);
                    break;
                case 3:
                    System.out.println("Has añadido el producto harina al carrito");
                    Thread.sleep(1000);
                    break;
                case 4:
                    System.out.println("Has dejado de coger productos");
                    seguirAñadiendoP = false;
                    break;
                default:
                    System.out.println("Producto seleccionado incorrecto");
                    break;
            }
        }
    }

    public static void VerCarrito(ArrayList<String> carrito) {
        if (carrito.isEmpty()) {
            System.out.println("El carrito está vacío.");
            return;
        }

        for (String producto : carrito) {
            switch (producto) {
                case "Pan":
                    pan++;
                    break;
                case "Huevos":
                    huevos++;
                    break;
                case "Aceite":
                    aceite++;
                    break;
                case "Harina":
                    harina++;
                    break;
            }
        }

        System.out.println("Contenido del carrito:");
        if (pan > 0) System.out.println("Pan: " + pan);
        if (huevos > 0) System.out.println("Huevos: " + huevos);
        if (aceite > 0) System.out.println("Aceite: " + aceite);
        if (harina > 0) System.out.println("Harina: " + harina);
    }

    public static void FinalizarCompra(double[] precioProductos) {

        double precioPan = pan * precioProductos[0];
        double precioHuevos = huevos * precioProductos[1];
        double precioAceite = aceite * precioProductos[2];
        double precioHarina = harina * precioProductos[3];

        if (pan > 0) System.out.println("Pan X" + pan + " - " + precioPan);
        if (huevos > 0) System.out.println("Huevos X" + huevos + " - " + precioHuevos);
        if (aceite > 0) System.out.println("Aceite X" + aceite + " - " + precioAceite);
        if (harina > 0) System.out.println("Harina X" + harina + " - " + precioHarina);

        double total = precioPan + precioAceite + precioHarina + precioHuevos;
        System.out.println("TOTAL - " + total);

    }
}