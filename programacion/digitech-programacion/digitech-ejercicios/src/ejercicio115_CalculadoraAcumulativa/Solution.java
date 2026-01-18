package ejercicio115_CalculadoraAcumulativa;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        float acumulador = 0;
        int contador = 0;

        while (true) {

            String op = print.next();

            if (op.equals("END")) {
                if (contador == 0) {
                    System.out.println("0.0");
                }
                break;
            }

            float num = print.nextFloat();

            switch (op) {
                case "+":
                    acumulador += num;
                    break;
                case "-":
                    acumulador -= num;
                    break;
                case "*":
                    acumulador *= num;
                    break;
                case "/":
                    acumulador /= num;
                    break;
            }
            System.out.println(acumulador);
            contador++;
        }
    }
}