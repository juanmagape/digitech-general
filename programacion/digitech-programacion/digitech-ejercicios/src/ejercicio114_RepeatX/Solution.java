package ejercicio114_RepeatX;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int num = print.nextInt();

        for (int i = 0; i < num; i++) {
            System.out.print(num);
        }
    }
}