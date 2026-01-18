package ejercicio119_FiltrarVocales;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int num = print.nextInt();

        for (int i = 0; i < num; i++) {
            String a = print.next();

            if (a.equals("a") || a.equals("e") || a.equals("i") || a.equals("o") ||a.equals("u")) {
                System.out.println(a);
            }
        }
    }
}