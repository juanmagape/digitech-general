package ejercicio96_Caracol;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int alturaPalo = print.nextInt();
        int mEscalados = print.nextInt();
        int mResbalados = print.nextInt();

        if (alturaPalo == mEscalados) {
            System.out.println("1");
        } else {
            int res = (alturaPalo - mEscalados + mEscalados - mResbalados - 1) / (mEscalados - mResbalados) + 1;
            System.out.println(res);
        }
    }
}