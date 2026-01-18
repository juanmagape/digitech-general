package ejercicio127_InicializarArray;

import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        scanner.useLocale(Locale.ENGLISH);

        // inicializa el array numbers
        int[] numbers = {12,17,8,101,33};

        for (int i = 0; i < numbers.length; i++) {
            System.out.println(numbers[i]);
        }
    }
}