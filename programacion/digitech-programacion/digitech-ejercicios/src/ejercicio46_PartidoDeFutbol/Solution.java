package ejercicio46_PartidoDeFutbol;
import java.util.Scanner;

public class Solution {
    public static void main() {
        Scanner sc = new Scanner(System.in);

        int golA = sc.nextInt();
        int golB = sc.nextInt();

        int tarjetaRojaA = sc.nextInt();
        int tarjetaRojaB = sc.nextInt();

        System.out.println((golA > golB) || (golA == golB && tarjetaRojaA < tarjetaRojaB));

    }
}
