package ejercicio126_Scrabble;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        String palabra = print.nextLine().toUpperCase();
        int i = 0;

        for (char cPal : palabra.toCharArray()) {
            switch (cPal) {
                case 'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T':
                    i = i + 1;
                    break;
                case 'D', 'G':
                    i = i + 2;
                    break;
                case 'B', 'C', 'M', 'P':
                    i = i + 3;
                    break;
                case 'F', 'H', 'V', 'W', 'Y':
                    i = i + 4;
                    break;
                case 'K':
                    i = i + 5;
                    break;
                case 'J', 'X':
                    i = i + 8;
                    break;
                case 'Q', 'Z':
                    i = i + 10;
                    break;

            }

        }
        System.out.println(i);
    }
}