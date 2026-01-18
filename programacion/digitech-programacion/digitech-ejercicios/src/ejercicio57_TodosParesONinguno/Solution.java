package ejercicio57_TodosParesONinguno;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        float num1 = print.nextFloat();
        float num2 = print.nextFloat();
        float num3 = print.nextFloat();

        int num1Int = (int) num1 % 2;
        int num2Int = (int) num2 % 2;
        int num3Int = (int) num3 % 2;

        boolean num1C = num1Int == 0;
        boolean num2C = num3Int == 0;
        boolean num3C = num2Int == 0;

        boolean valorFinal = (num1C && num2C && num3C || !num1C && !num2C && !num3C);

        System.out.println(valorFinal);

    }
}



