package ejercicio55_chunksMinecraft;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        String ubicacion = print.next();
        int nivelLuz = print.nextInt();
        int distanciaJugadorCercano = print.nextInt();
        int distanciaMaximaAparicionMob = print.nextInt();
        boolean chunkSlime = print.nextBoolean();
        int alturaSuelo = print.nextInt();



        boolean condicion1 = (distanciaJugadorCercano < distanciaMaximaAparicionMob || chunkSlime && alturaSuelo > 50);
        boolean valorFinal = (ubicacion.equals("overworld") && nivelLuz < 7);

        System.out.println(condicion1 && valorFinal);

    }
}



