package ejercicio49_DesbloqueaElNivel;
import java.util.Scanner;

public class Solution {
    public static void main() {
        Scanner sc = new Scanner(System.in);

        int puntos = sc.nextInt();
        int partidas = sc.nextInt();

        System.out.println(puntos > 1000 || partidas > 50);
    }
}
