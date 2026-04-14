package GestionArchivos.RegistroUsuarios;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Usuario {
    private String nombre;
    private int edad;
    private String correo;

    public Usuario(String nombre, int edad, String correo) {
        this.nombre = nombre;
        this.edad = edad;
        this.correo = correo;
    }

    public static void agregarUsuario(String nombre,int edad,String correo, File archivo) throws IOException {
        FileWriter fw = new FileWriter(archivo, true);

        System.out.println("Datos adjuntados: ");
        System.out.println("Nombre: " + nombre);
        System.out.println("Edad: " + edad);
        System.out.println("Correo: " + correo);

        fw.write("Nombre: " + nombre + " - Edad: " + edad + " - Correo: " + correo + "\n");
        fw.close();
        System.out.println("Usuario agregado correctamente");
    }

    public static void verUsuarios(File archivo) throws IOException {

        try {
            Scanner reader = new Scanner(archivo);
            System.out.println("=============================================");
            System.out.println("===========  USUARIOS REGISTRADOS  ==========");
            System.out.println("=============================================");
            while (reader.hasNextLine()) {
                String data = reader.nextLine();
                System.out.println(data);
            }
            reader.close();
        } catch (Exception e) {
            System.out.println("Error al leer el archivo: " + e.getMessage());
        }
    }
}
