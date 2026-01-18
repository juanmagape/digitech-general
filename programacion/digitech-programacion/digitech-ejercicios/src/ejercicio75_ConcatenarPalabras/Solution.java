package ejercicio75_ConcatenarPalabras;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        String a = print.nextLine();
        char xa = a.charAt(0);
        char ya = a.charAt(1);

        String b = "".concat("" + xa);
        b = b.concat("" + ya);


        System.out.println(b);

    }
}