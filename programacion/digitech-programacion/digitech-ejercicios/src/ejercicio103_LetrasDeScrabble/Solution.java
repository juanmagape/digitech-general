package ejercicio103_LetrasDeScrabble;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        String a = print.nextLine();

        if (a.equals("A") || a.equals("E") || a.equals("I") || a.equals("O") || a.equals("U") || a.equals("L") || a.equals("N") || a.equals("R") || a.equals("S") || a.equals("T")) {
            System.out.println("1");
        } else if (a.equals("D") || a.equals("G")){
            System.out.println("2");
        } else if (a.equals("B") || a.equals("C") || a.equals("M") || a.equals("P")){
            System.out.println("3");
        } else if (a.equals("F") || a.equals("H") || a.equals("V") || a.equals("W") || a.equals("Y")) {
            System.out.println("4");
        } else if (a.equals("K")) {
            System.out.println("5");
        } else if (a.equals("J") || a.equals("X")) {
            System.out.println("8");
        } else if (a.equals("Q") || a.equals("Z")) {
            System.out.println("10");
        }
    }
}