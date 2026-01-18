package ejercicio56_AtraparPokemon;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        int vidaActual = print.nextInt();
        int vidaTotal = print.nextInt();
        String estado = print.next();
        String tipoPokeball = print.next();

        boolean condicion1 = tipoPokeball.equals("masterball");
        boolean condicion2 = (vidaActual < vidaTotal/2 && estado.equals("dormido") || estado.equals("paralizado"));

        System.out.println(condicion1 || condicion2);

    }
}



