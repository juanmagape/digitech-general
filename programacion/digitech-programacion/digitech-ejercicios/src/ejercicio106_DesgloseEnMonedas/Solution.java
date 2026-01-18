package ejercicio106_DesgloseEnMonedas;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int valor = print.nextInt();

        int res1 = valor % 500;
        int res2 = res1 % 100;
        int res3 = res2 % 5;
        int res4 = res3 % 1;

        int utilizados500 = valor / 500;
        int utilizados100 = res1 / 100;
        int utilizados5 = res2 / 5;
        int utilizados1 = res3 / 1;

        if (utilizados500 != 0) {
            if (utilizados500 <= 1) {
                System.out.println(utilizados500 + " moneda de 500");
            } else {
                System.out.println(utilizados500 + " monedas de 500");
            }
        }

        if (utilizados100 != 0) {
            if (utilizados100 <= 1) {
                System.out.println(utilizados100 + " moneda de 100");
            } else {
                System.out.println(utilizados100 + " monedas de 100");
            }
        }

        if (utilizados5 != 0) {
            if (utilizados5 <= 1) {
                System.out.println(utilizados5 + " moneda de 5");
            } else {
                System.out.println(utilizados5 + " monedas de 5");
            }
        }

        if (utilizados1 != 0) {
            if (utilizados1 <= 1) {
                System.out.println(utilizados1 + " moneda de 1");
            } else {
                System.out.println(utilizados1 + " monedas de 1");
            }
        }
    }
}