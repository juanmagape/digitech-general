package ejercicio68_PromedioTruncado;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        float a = print.nextFloat();
        float b = print.nextFloat();
        float c = print.nextFloat();

        int a1 = (int) a;
        int a2 = (int) b;
        int a3 = (int) c;

        int res1 = a1 + a2 + a3;

        System.out.println(res1 / 3);


    }
}