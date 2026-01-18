// Importación de la clase Scanner
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    // Crear número aleatorio y guardarlo en una variable.
    int numeroAdivinar = (int)(Math.random() * 100 + 1);
    // Asignar al número del input un 0 para que no pueda ser igual a ninguno de los aleatorios.
    int numeroIntento = 0;

    // Hacer bucle en caso de que el número randomizado no sea igual al número por defecto "0".
    while (numeroIntento != numeroAdivinar) {
        numeroIntento = sc.nextInt();  // Recoger los datos del input

        if (numeroIntento == numeroAdivinar) // Comprobar si el número que ha leído el scanner es igual al número por adivinar
            // Print para cuando el jugador acierte el número randomizado.
            System.out.println("Correcto");

        else if (numeroIntento > numeroAdivinar)
            // Print para en caso de que el número introducido sea más grande que el valor que puede generar.
            System.out.println("El número que has puesto es más grande que el número randomizado.");

        else
            // Hacemos el print en caso de que falle el usuario
            System.out.println("Incorrecto, prueba de nuevo");
    }
}}