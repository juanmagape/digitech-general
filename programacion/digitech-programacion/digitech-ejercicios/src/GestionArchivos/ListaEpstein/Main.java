package GestionArchivos.ListaEpstein;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner sc = new Scanner(System.in);
        File lista;

        try {
            lista = new File("src/GestionArchivos/ListaEpstein/lista.txt");
        } catch (Exception e) {
            System.out.println("Archivo no encontrado: " + e.getMessage());
            return;
        }


        while (true) {
            System.out.println("Introduce la palabra a buscar");
            String nombre = sc.next();

            Scanner reader = new Scanner(lista);

            int contador = 0;

            while (reader.hasNext()) {
                String data = reader.next();

                String[] partes = data.split("[^a-zA-Z]+");

                for (String parte : partes) {
                    if (parte.equalsIgnoreCase(nombre)) {
                        contador++;
                    }
                }
            }

            reader.close();

            System.out.println(nombre + " aparece " + contador + " veces en la lista.");

            System.out.println("Seguir buscando palabras? (s/n)");
            String respuesta = sc.next();

            if (respuesta.equalsIgnoreCase("n")) {
                break;
            }
        }

    }
}
