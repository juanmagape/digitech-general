package ejercicio41_distanciaEntreDosPuntos;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        float x1 = print.nextFloat();
        float y1 = print.nextFloat();

        float z1 = print.nextFloat();
        float x2 = print.nextFloat();


        float y2 = print.nextFloat();
        float z2 = print.nextFloat();

        float restaX = x2 - x1;
        float xAlaDos = (float) Math.pow(restaX,2);
        float restaY = y2 - y1;
        float yAlaDos = (float) Math.pow(restaY,2);
        float restaZ = z2 - z1;
        float zAlaDos = (float) Math.pow(restaZ,2);

        float resultado = xAlaDos + yAlaDos + zAlaDos;

        float res = (float) Math.sqrt(resultado);

        System.out.println(res);

    }
}



