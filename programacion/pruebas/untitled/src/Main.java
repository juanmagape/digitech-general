import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int cantidadNum = print.nextInt();
        int[] araryMultiplos = new int[cantidadNum];

        for (int i = 0; i < cantidadNum; i++) {
            araryMultiplos[i] = print.nextInt();
        }

        for (int i = 0; i < cantidadNum; i++) {

            int numAct = araryMultiplos[i];

            for (int j = i + 1; j < cantidadNum; j++) {
                if (araryMultiplos[j] % numAct == 0) {
                    System.out.println(araryMultiplos[j] + " es multiplo de " + numAct);
                }
            }

        }

    }
}
