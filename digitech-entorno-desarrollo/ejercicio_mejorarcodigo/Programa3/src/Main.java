// Importacion de la clase Scanner.
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        // Creación de variables
        int energiaQi = 50;
        int puntosFuerza = 0;
        int opcion1 = 0;
        int opcion2 = 0;
        int opcion3 = 0;
        boolean enEjecucion = true;

        while (enEjecucion) {

            // Añadir prints al iniciar el programa explicando las opciones a escoger por el usuario
            System.out.println("----- MENÚ DE OPCIONES -----");
            System.out.println("1. Realizar acción tipo 1 (-10 energía Qi, +5 puntosFuerza)");
            System.out.println("2. Realizar acción tipo 2 (-7 energía Qi, +3 puntosFuerza)");
            System.out.println("3. Realizar acción tipo 3 (-20 energía Qi, +10 puntosFuerza)");
            System.out.println("4. Puntuación actual");
            System.out.println("5. Salir");
            System.out.print("Elige un número de entre el 1 al 5: ");
            int opcion = s.nextInt();

            // En caso de que la opción escogida por el usuario sea 1, realizar el if, restando energiaQi y sumando puntosFuerza
            if (opcion == 1) {
                if (energiaQi >= 10) {
                    energiaQi -= 10;
                    puntosFuerza += 5;
                    opcion1++;

                    // Prints para mostrar la acción realizada, datos gastados y datos restantes para las siguientes acciones.
                    System.out.println("-10 energía, +5 puntosFuerza");
                    System.out.println("Energia Qi actual: " + energiaQi);
                    System.out.println("Puntos de fuerza actuales: " + puntosFuerza + "\n");
                } else {
                    // Print en caso de que la energiaQi actual sea menos a la que requiere el programa
                    System.out.println("Tienes menos recursos de los necesitados");
                }

                // En caso de que la opción escogida por el usuario sea 2, realizar el if, restando energiaQi y sumando puntosFuerza
            } else if (opcion == 2) {
                if (energiaQi >= 7) {
                    energiaQi -= 7;
                    puntosFuerza += 3;
                    opcion2++;

                    // Prints para mostrar la acción realizada, datos gastados y datos restantes para las siguientes acciones.
                    System.out.println("-7 energía, +3 puntosFuerza");
                    System.out.println("Energia Qi actual: " + energiaQi);
                    System.out.println("Puntos de fuerza actuales: " + puntosFuerza + "\n");

                } else {
                    // Print en caso de que la energiaQi actual sea menos a la que requiere el programa
                    System.out.println("Tienes menos recursos de los necesitados");
                }
                // En caso de que la opción escogida por el usuario sea 2,
                // realizar el if, restando energiaQi y sumando puntosFuerza
            } else if (opcion == 3) {
                if (energiaQi >= 20) {
                    energiaQi -= 20;
                    puntosFuerza += 10;
                    opcion3++;

                    // Prints para mostrar la acción realizada, datos gastados
                    // y datos restantes para las siguientes acciones.
                    System.out.println("-20 energía Qi, +10 puntosFuerza");
                    System.out.println("Energia Qi actual: " + energiaQi);
                    System.out.println("Puntos de fuerza actuales: " + puntosFuerza + "\n");

                } else {
                    // Print en caso de que la energiaQi actual sea menos a la que requiere el programa
                    System.out.println("Tienes menos recursos de los necesitados");
                }
                // Cuando la opción 4 es seleccionada, se muestran todos los datos,
                // tanto la energia, puntos, y cuantas veces se han realizado cada acción
            } else if (opcion == 4) {
                System.out.println("Energia restante: " + energiaQi);
                System.out.println("Puntos obtenidos: " + puntosFuerza);
                System.out.println("Opción 1: " + opcion1);
                System.out.println("Opción 2: " + opcion2);
                System.out.println("Opción 3: " + opcion3);
            } else if (opcion == 5) {
                enEjecucion = false;
            }

            // En caso de que la energia sea 0, se termina el programa.
            if (energiaQi < 0) {
                System.out.println("end");
                enEjecucion = false;
            }
        }

        s.close();
    }
}
