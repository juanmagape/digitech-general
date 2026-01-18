package ejercicio81_VocalesMayuscula;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        String linea1 = print.nextLine();

        System.out.println(linea1.replace("a", "A")
                .replace("e" , "E")
                .replace("i", "I")
                .replace("o", "O")
                .replace("u", "U"));

    }
}