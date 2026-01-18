package ejercicio88_InterpreteAritmetico;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        float num1 = print.nextFloat();
        String oper = print.next();
        float num2 = print.nextFloat();

        switch (oper) {
            case "+":
                System.out.println((float) num1 + num2);
            break;
            case "-":
                System.out.println((float) num1 - num2);
                break;
            case "*":
                System.out.println((float) num1 * num2);
                break;
            case "/":
                System.out.println((float) num1 / num2);
                break;
            case "%":
                System.out.println((float) num1 % num2);
                break;
            default :
                System.out.println("Error: operation not permitted");
                ;
        }
    }
}