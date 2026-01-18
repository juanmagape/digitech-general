package ejercicio70_SistemaRecompensa;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        String piratasStr = "7";
        int botinTotal = 1000;

        int piratas = Integer.parseInt(piratasStr);
        double partePorPirata = (double) botinTotal / piratas;


        System.out.println("A cada pirata le tocan: " + partePorPirata + " monedas");

    }
}