package ejercicio47_MontañaRusa;
import java.sql.SQLOutput;
import java.util.Scanner;

public class Solution {
    public static void main() {
        Scanner sc = new Scanner(System.in);

        int edad = sc.nextInt();
        int altura = sc.nextInt();

        System.out.println(edad >= 12 && altura > 140);
    }
}
