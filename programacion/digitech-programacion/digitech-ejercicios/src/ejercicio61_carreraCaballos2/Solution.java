package ejercicio61_carreraCaballos2;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        int velMax = print.nextInt();
        int resis = print.nextInt();
        int peso = print.nextInt();
        int inicioCarrera = print.nextInt();

        int velMax2 = print.nextInt();
        int resis2 = print.nextInt();
        int peso2 = print.nextInt();
        int inicioCarrera2 = print.nextInt();

        int velMax3 = print.nextInt();
        int resis3 = print.nextInt();
        int peso3 = print.nextInt();
        int inicioCarrera3 = print.nextInt();

        int velMax4 = print.nextInt();
        int resis4 = print.nextInt();
        int peso4 = print.nextInt();
        int inicioCarrera4 = print.nextInt();

        int sumaCab1 = (velMax + resis + peso + inicioCarrera) - peso;
        int sumaCab2 = (velMax2 + resis2 + peso2 + inicioCarrera2) - peso2;
        int sumaCab3 = (velMax3 + resis3 + peso3 + inicioCarrera3) - peso3;
        int sumaCab4 = (velMax4 + resis4 + peso4 + inicioCarrera4) - peso4;

        boolean res1 = sumaCab1 > sumaCab2 && sumaCab1 > sumaCab3 && sumaCab1 > sumaCab4;
        boolean res2 = sumaCab2 > sumaCab1 && sumaCab2 > sumaCab3 && sumaCab2 > sumaCab4;
        boolean res3 = sumaCab3 > sumaCab1 && sumaCab3 > sumaCab2 && sumaCab3 > sumaCab4;
        boolean res4 = sumaCab4 > sumaCab1 && sumaCab4 > sumaCab2 && sumaCab4 > sumaCab3;

        System.out.println("Caballo 1: " + res1);
        System.out.println("Caballo 2: " + res2);
        System.out.println("Caballo 3: " + res3);
        System.out.println("Caballo 4: " + res4);
    }
}



