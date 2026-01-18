package ejercicio76_SplitText;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String texto = sc.nextLine();

        String palabras [] = texto.split(" ");

        for (int i = 0; i < palabras.length; i++) {
            System.out.println(palabras[i]);
        }
    }
}