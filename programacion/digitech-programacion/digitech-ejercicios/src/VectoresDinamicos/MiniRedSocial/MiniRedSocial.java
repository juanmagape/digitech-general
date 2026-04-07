package VectoresDinamicos.MiniRedSocial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class MiniRedSocial {
    public static void main(String[] args) {

        HashMap<String, Usuario> usuarios = new HashMap<>();
        Scanner teclado = new Scanner(System.in);

        Usuario usuario1 = new Usuario("usuario1@example.com", "12345678");
        usuario1.agregarPublicacion("Hola, soy Jolines Macho");
        usuario1.agregarPublicacion("Hoy me he levantado.");
        usuarios.put(usuario1.getCorreo(), usuario1);

        Usuario usuario2 = new Usuario("usuario2@example.com", "12345678");
        usuario2.agregarPublicacion("primerapublicacion.");
        usuarios.put(usuario2.getCorreo(), usuario2);

        int opcion = 0;
        while (opcion != 2) {
            System.out.println("\n============= MINI RED SOCIAL =============");
            System.out.println("[1] - Iniciar sesión");
            System.out.println("[2] - Salir");
            System.out.println("==========================================");
            System.out.print("Elige una opción: ");

            opcion = teclado.nextInt();
            teclado.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Correo electrónico: ");
                    String correo = teclado.nextLine();

                    System.out.print("Contraseña: ");
                    String contrasena = teclado.nextLine();

                    if (usuarios.containsKey(correo) && usuarios.get(correo).getContrasena().equals(contrasena)) {

                        System.out.println("\nSesión iniciada correctamente. Bienvenido/a, " + correo);

                        System.out.println("\n=== PUBLICACIONES DE TODOS LOS USUARIOS ===");
                        for (Map.Entry<String, Usuario> entrada : usuarios.entrySet()) {
                            System.out.println("\nUsuario: " + entrada.getKey());
                            ArrayList<String> posts = entrada.getValue().getPublicaciones();
                            if (posts.isEmpty()) {
                                System.out.println("  (Sin publicaciones)");
                            } else {
                                for (String post : posts) {
                                    System.out.println("  - " + post);
                                }
                            }
                        }
                    } else {
                        System.out.println("Correo o contraseña incorrectos.");
                    }
                    break;

                case 2:
                    System.out.println("Saliendo");
                    break;

                default:
                    System.out.println("Opción no válida.");
            }
        }
    }
}
