package Examen03_Bucles;
import java.util.Scanner;

public class Solution2 {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int stockBotellas = print.nextInt();
        float precio = print.nextFloat();
        boolean seguirPrograma = true;
        float balanceFinal = 0;
        float balanceInicial = 0;

        while(seguirPrograma) {
            String operacion = print.next();

            float balance = 0;
            float cantidadInsertada = 0;

            switch (operacion) {
                case "INSERT":
                    if (balance == 0) {
                        System.out.println("Insert coin");
                    }
                    cantidadInsertada = print.nextFloat();
                    balanceInicial = balance + cantidadInsertada;
                    System.out.println("Balance:" + balanceInicial);

                    break;
                case "EXPEND":
                    if (balance < precio) {
                        System.out.println("Your water, thanks");
                        balanceFinal = balanceInicial - precio;
                        System.out.println("Balance:" + balanceFinal);
                    } else {
                        System.out.println("Price: " + precio);
                        System.out.println("Balance:" + balance);
                    }
                    break;
                case "REFUND":
                    System.out.println("Refund:" + balanceFinal);
                    balanceInicial = 0;
                    System.out.println("Insert coin");
                    break;
                case "OFF":
                    seguirPrograma = false;
                    break;
            }
        }
    }
}