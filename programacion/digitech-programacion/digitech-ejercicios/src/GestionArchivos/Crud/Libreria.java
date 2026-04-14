package GestionArchivos.Crud;

import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class Libreria {
    public static ArrayList<String> libros = new ArrayList<>();

    public static void AgregarLibro(File libreria) throws IOException, InterruptedException {
        Scanner sc = new Scanner(System.in);

        System.out.println("Ingrese el título:");
        String titulo = sc.nextLine();
        System.out.println("Ingrese el autor:");
        String autor = sc.nextLine();
        System.out.println("Ingrese el año:");
        int ano = sc.nextInt();

        FileWriter fw = new FileWriter(libreria, true);
        fw.write(titulo + " | " + autor + " | " + ano + "\n");
        fw.close();
        System.out.println("¡Libro guardado!");

        Thread.sleep(1000);
    }

    public static void Leer(File libreria) throws FileNotFoundException, InterruptedException {
        libros.clear();
        Scanner reader = new Scanner(libreria);
        while (reader.hasNextLine()) {
            String linea = reader.nextLine();
            if (!linea.trim().isEmpty()) {
                libros.add(linea);
            }
        }
        reader.close();

        System.out.println("\n--- LISTA DE LIBROS ---");
        for (int i = 0; i < libros.size(); i++) {
            System.out.println((i + 1) + " - " + libros.get(i));
        }

        Thread.sleep(1000);
    }

    public static void EditarLibro(File libreria) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        try {
            Leer(libreria);
            System.out.println("\nIngrese el número del libro que desea editar:");
            int indice = sc.nextInt() - 1;
            sc.nextLine();

            if (indice >= 0 && indice < libros.size()) {
                System.out.println("Cambiando: " + libros.get(indice));
                System.out.println("Ingrese el nuevo título:");
                String nuevoTitulo = sc.nextLine();
                System.out.println("Ingrese el autor:");
                String nuevoAutor = sc.nextLine();
                System.out.println("Ingrese el año de publicación:");
                int nuevoAno = sc.nextInt();

                String libroActualizado =   nuevoTitulo + " | " + nuevoAutor + " | " + nuevoAno;

                libros.set(indice, libroActualizado);

                GuardarTodo(libreria);
                System.out.println("¡Editado!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread.sleep(1000);
    }

    public static void EliminarLibro(File libreria) throws InterruptedException {
        Scanner sc = new Scanner(System.in);
        try {
            Leer(libreria);
            System.out.println("\nIngrese el número del libro a borrar:");
            int indice = sc.nextInt() - 1;

            if (indice >= 0 && indice < libros.size()) {
                libros.remove(indice);
                GuardarTodo(libreria);
                System.out.println("¡Libro eliminado!");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Thread.sleep(1000);
    }

    private static void GuardarTodo(File archivo) throws IOException {
        try (PrintWriter pw = new PrintWriter(new FileWriter(archivo, false))) {
            for (String l : libros) {
                pw.println(l);
            }
        }
    }
}