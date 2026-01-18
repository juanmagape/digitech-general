package ejercicio44_Semaforoypeaton;
import java.util.Scanner;

public class Solution {
    public static void main() {
        Scanner sc = new Scanner(System.in);

        int semaforoCoches = sc.nextInt();
        int semaforoPeatones = sc.nextInt();

        System.out.println(semaforoCoches == 0 && semaforoPeatones == 1);
    }
}
