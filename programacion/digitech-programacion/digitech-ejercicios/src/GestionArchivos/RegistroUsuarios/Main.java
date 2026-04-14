package GestionArchivos.RegistroUsuarios;
import java.io.File;
import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);

        File archivo = new File("src/GestionArchivos/RegistroUsuarios/usuarios.txt");


        if (!archivo.exists()) {
            archivo.createNewFile();
            System.out.println("Archivo creado, con el nombre: " + archivo.getName());
        }

        Usuario.verUsuarios(archivo);


        System.out.println("\n\n=============================================");
        System.out.println("===========  GESTIÓN DE USUARIOS  ===========");
        System.out.println("=============================================");

        System.out.println("Introduce tu nombre: ");
        String nombre = sc.nextLine();

        int edad = 0;

        while (edad <= 0) {
            try {
                System.out.println("\nIntroduce tu edad: ");
                edad = sc.nextInt();
                sc.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Error:" + e);
                sc.nextLine();
            }
        }

        System.out.println("\nIntroduce tu correo: ");
        String correo = sc.nextLine();

        Usuario.agregarUsuario(nombre, edad, correo, archivo);

    }
}
