package ejercicio78_CaracterPosicionX;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        String palabra = print.nextLine();
        int num = print.nextInt();

        char res = palabra.charAt(num);
        System.out.println(res);
    }
}