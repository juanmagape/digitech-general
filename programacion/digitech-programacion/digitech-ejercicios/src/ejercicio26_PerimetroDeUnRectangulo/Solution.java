package ejercicio26_PerimetroDeUnRectangulo;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        int x1 = print.nextInt();
        int y1 = print.nextInt();
        int x2 = print.nextInt();
        int y2 = print.nextInt();

        int base = (x1 - x2);
        int altura = (y1 - y2);

        int perimetro = 2 * (base + altura);

        System.out.println(perimetro);


    }
}

