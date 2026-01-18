package Examen02_Bolos;
import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        int personas = print.nextInt();
        int aforo = print.nextInt();
        boolean seguridad = print.nextBoolean();

        boolean aforoPersonas = personas < aforo;

        System.out.println(aforoPersonas && seguridad);

    }
}