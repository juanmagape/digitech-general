package ejercicio71_HundirLaFlota1;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int a = print.nextInt();
        int b = print.nextInt();

        int xA = a + 96;
        char yA = (char) xA;

        String res1 = yA + "" + b;
        System.out.println(res1);
        System.out.println(res1.equals("b5") || res1.equals("a2") || res1.equals("b2") || res1.equals("g3") || res1.equals("f7") || res1.equals("g7") || res1.equals("bh7"));

    }
}