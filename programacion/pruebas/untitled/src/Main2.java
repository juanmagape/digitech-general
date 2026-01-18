import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int tamanoUrinal = print.nextInt();
        String[] urinales = new String[tamanoUrinal];
        boolean dispo = true;

        for (int i = 0; i < tamanoUrinal; i++) {
            urinales[i] = print.next();
        }

        int urinalComprobar = print.nextInt();

        for (int i = 0; i < tamanoUrinal; i++) {

            for (int j = urinalComprobar + 1; j < tamanoUrinal; j++) {
                if (urinales[j].equals("X") || urinales[j - 2].equals("X")) {
                    dispo = false;
                } else {
                    dispo = true;
                }
            }
        }

        if (!dispo) {
            System.out.println("No disponible");
        } else {
            System.out.println("Disponible");
        }

        int contador = 0;

        for (int j = 0; j < tamanoUrinal - 2; j++) {
            contador++;

            if (urinales[j + 2].equals("X")){
                contador += contador;
            }
            if (urinales[j + 2].equals("O") && urinales[j + 1].equals("O")) {
                System.out.println(contador);
            }

        }
    }
}
