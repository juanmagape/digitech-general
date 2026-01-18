package ejercicio50_comparardospalabras;
import java.util.Scanner;

public class Solution {
    public static void main() {
        Scanner sc = new Scanner(System.in);

        String palabra1 = sc.nextLine();
        String palabra2 = sc.nextLine();

        System.out.println(palabra1.equals(palabra2));
    }
}
