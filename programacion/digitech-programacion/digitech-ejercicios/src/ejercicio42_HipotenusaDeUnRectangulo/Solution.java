package ejercicio42_HipotenusaDeUnRectangulo;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        float cat1 = print.nextFloat();
        float cat2 = print.nextFloat();

        float cat1A2 = (float) Math.pow(cat1,2);
        float cat2A2 = (float) Math.pow(cat2,2);

        float res = (float) Math.sqrt(cat1A2 + cat2A2);

        System.out.println(res);

    }
}


