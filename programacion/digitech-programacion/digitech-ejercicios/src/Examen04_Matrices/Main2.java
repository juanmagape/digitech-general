package Examen04_Matrices;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int filas =  sc.nextInt();
        int columnas = sc.nextInt();
        int cantidadItem = 0;

        String[][] inventario = new String[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                inventario[i][j] = sc.next();
            }
        }

        String itemNecesario = sc.next();
        int cantidadNecesaria = sc.nextInt();

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                if (inventario[i][j].equals(itemNecesario)) {
                    cantidadItem++;
                }
            }
        }

        if (cantidadItem >= cantidadNecesaria) {
            System.out.println("MISSION COMPLETED");
        } else {
            System.out.println("MISSION FAILED");
        }
    }
}
