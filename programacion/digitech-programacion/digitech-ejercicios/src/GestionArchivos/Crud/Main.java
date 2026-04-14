package GestionArchivos.Crud;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);
        File libreria = new File("src/GestionArchivos/Crud/libreria.txt");

        if (!libreria.exists()) {
            libreria.createNewFile();
        }

        while (true) {
            System.out.println("=======================================");
            System.out.println("LIBRERIA");
            System.out.println("=======================================");
            System.out.println("1 - Agregar libro");
            System.out.println("2 - Listar Libros");
            System.out.println("3 - Eliminar libro");
            System.out.println("4 - Editar libro");
            System.out.println("5 - Salir");
            System.out.println("=======================================");
            System.out.println("Ingrese una opción:");
            int opcion = sc.nextInt();


            switch (opcion) {
                case 1:
                    Libreria.AgregarLibro(libreria);
                    break;
                case 2:
                    Libreria.Leer(libreria);
                    break;
                case 3:
                    Libreria.EliminarLibro(libreria);
                    break;
                case 4:
                    Libreria.EditarLibro(libreria);
                    break;
                case 5:
                    System.exit(0);
                    break;

            }
        }

    }
}
