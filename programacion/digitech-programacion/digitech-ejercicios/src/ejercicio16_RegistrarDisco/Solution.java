package ejercicio16_RegistrarDisco;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        String nombreCancion = print.nextLine();
        String grupo = print.nextLine();
        String album = print.nextLine();
        String duracion = print.nextLine();
        String anoPublicacion = print.nextLine();

        System.out.println("La cancion \"" + nombreCancion + "\" del grupo \"" + grupo + "\", del album \"" + album + "\", con una duracion de " + duracion + " minutos y publicada en " + anoPublicacion + ", ha sido guardada correctamente.");
    }
}