package Examen02_Bolos;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        int bolosD1 = print.nextInt();
        int bolosD2 = print.nextInt();

        int bolosDerribados = bolosD1 + bolosD2;
        boolean plenoOS = bolosD1 == 10 || bolosDerribados == 10;

        System.out.println("Pleno/semipleno: " + plenoOS);
        System.out.println("Bolos derribados: " + bolosDerribados);

    }
}