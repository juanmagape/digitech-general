import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int tamano = print.nextInt();
        int[] ranaS = new int[tamano];
        boolean salto = true;
        int caida = 0;

        for (int i = 0; i < tamano; i++) {
            ranaS[i] = print.nextInt();
        }

        if (ranaS[0] == 1) {
            salto = false;
            System.out.println(salto);
            System.out.println(0);
            return;
        }

        for (int i = 0; i < tamano - 2; i += 2) {
            if (ranaS[i + 2] == 1) {
                salto = false;
                caida = i + 2;
                break;
            }
        }
        if (caida == 8) {
            caida++;
        }

        System.out.println(salto);
        if (!salto) {
            System.out.println(caida);
        }


    }
}
