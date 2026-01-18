package ejericio69_SumaNumeros;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        String a = print.next();
        String b = print.next();

        int n1 = Integer.parseInt(a);
        int n2 = Integer.parseInt(b);

        System.out.println(n1 + n2);

    }
}