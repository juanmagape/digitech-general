package ejercicio53_luces;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        boolean luz1 = print.nextBoolean();
        boolean luz2 = print.nextBoolean();
        boolean luz3 = print.nextBoolean();
        boolean luz4 = print.nextBoolean();

        boolean valorFinal = (luz1 == luz2 && luz3 == luz4);

        System.out.println(valorFinal);

    }
}



