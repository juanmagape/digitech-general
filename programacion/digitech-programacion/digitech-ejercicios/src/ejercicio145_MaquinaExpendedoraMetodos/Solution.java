package ejercicio145_MaquinaExpendedoraMetodos;

import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int fila = print.nextInt();
        int columna = print.nextInt();

        int[][] maquina = {
                {5, 3, 0},
                {2, 0, 1},
                {0, 4, 6}
        };

        System.out.println(validacionProducto(fila, columna, maquina));
    }

    static String validacionProducto(int fila, int columna, int[][] maquina) {

        if (maquina[fila][columna] == 0) {
            return "Producto agotado";
        } else {
            return "Producto disponible";
        }
    }

}
