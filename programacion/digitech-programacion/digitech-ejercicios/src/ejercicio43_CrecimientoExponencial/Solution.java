package ejercicio43_CrecimientoExponencial;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        float valorInicial = print.nextFloat();
        float tasa = print.nextFloat();
        float tiempo = print.nextFloat();

        float valorFinal = (float) (valorInicial * Math.exp (tasa * tiempo));

        System.out.println(valorFinal);

    }
}



