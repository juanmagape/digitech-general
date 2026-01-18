package ejercicio67_CompararDecimalesTruncados;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        float a = print.nextFloat();
        float b = print.nextFloat();

        int xa = (int) a;
        int xb = (int) b;

        boolean res1 = xa > xb;
        boolean res2 = xa < xb;
        boolean res3 = xa == xb;

        System.out.println(res1);
        System.out.println(res2);
        System.out.println(res3);


    }
}