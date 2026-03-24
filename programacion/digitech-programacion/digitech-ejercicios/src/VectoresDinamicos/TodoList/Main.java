package VectoresDinamicos.TodoList;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        ArrayList<Tarea> todoList = new ArrayList<>();

        System.out.println("=================================");
        System.out.println("Bienvenido a tu lista de tareas");
        System.out.println("=================================");
        System.out.println("¿Cuántas tareas quieres agregar a tu lista?");
        int cantidadTareas = print.nextInt();
        print.nextLine();

        int numeroDeTareas = 0;

        for (int i = 0; i < cantidadTareas; i++) {
            System.out.println("\n--- Creando tarea " + (i + 1) + " de " + cantidadTareas + " ---");

            agregarTarea(print, todoList);
            numeroDeTareas++;
        }

        System.out.println("=================================");
        System.out.println("TAREAS AGREGADAS: " + numeroDeTareas);
        System.out.println("=================================");

        for (Tarea t : todoList) {
            System.out.println(t.toString());
        }

        System.out.println("=================================");

    }

    public static void agregarTarea(Scanner print, ArrayList<Tarea> todoList) {
        System.out.println("================================");
        System.out.println("Nombre de la tarea:");
        String tarea = print.nextLine();

        System.out.println("Autor/Responsable de la tarea");
        String autor = print.nextLine();

        System.out.println("Descripcion de la tarea:");
        String descripcion = print.nextLine();

        System.out.println("Duración aproximada de la tarea (horas):");
        int duracion = print.nextInt();
        print.nextLine();

        System.out.println("Estado de la tarea (Pendiente/En progreso/Completada):");
        String estado = print.nextLine();
        System.out.println("================================");

        Tarea nuevaTarea = new Tarea(tarea, autor, descripcion, duracion, estado);
        todoList.add(nuevaTarea);
    }
}
