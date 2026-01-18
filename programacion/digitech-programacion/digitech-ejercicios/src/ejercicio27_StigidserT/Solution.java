package ejercicio27_StigidserT;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        int numero = print.nextInt();

        int digito1 = numero / 100;
        int digito2 = (numero / 10) % 10;
        int digito3 = numero % 10;

        int invertido = digito3 * 100 + digito2 * 10 + digito1;
        System.out.println(invertido);

    }
}

