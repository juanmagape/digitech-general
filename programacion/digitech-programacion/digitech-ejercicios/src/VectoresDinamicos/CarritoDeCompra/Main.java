package VectoresDinamicos.CarritoDeCompra;

import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Producto carrito = new Producto();
        Scanner print = new Scanner(System.in);

        System.out.println("================================");
        System.out.println("METADONA");
        System.out.println("================================");

        System.out.println("Cuantos productos quieres agregar al carrito?");
        int cantidadProductos = print.nextInt();

        for (int i = 0; i < cantidadProductos; i++) {
            agregarProducto(print);
        }


    }

    public static void agregarProducto(Scanner print) {
        System.out.println("Ingrese el nombre del producto:");
        String nombreProducto = print.nextLine();

        System.out.println("Ingrese el precio del producto:");
        double precio = print.nextDouble();

        System.out.println("Ingrese la cantidad del producto:");
        int cantidad = print.nextInt();


    }
}
