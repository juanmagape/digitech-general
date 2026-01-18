package ejercicio120_Galibo;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        float alt = print.nextFloat();
        float num = print.nextFloat();

        for (int i = 0; i < num; i++) {
            float alturaPuente = print.nextFloat();
            if (alturaPuente < alt) {
                System.out.println("choca con el puente " + (i + 1));
                break;
            }
        }
    }
}