import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner x = new Scanner(System.in);
        int a, b, c;
        double d;
        String z;
        System.out.println();
        a = x.nextInt();
        System.out.println();
        b = x.nextInt();
        System.out.println();
        z = x.next();
        if (z.equals("+")) {
            c = a + b;
            System.out.println(c);
        } else if (z.equals("-")) {
            c = a - b;
            System.out.println(c);
        } else if (z.equals("*")) {
            c = a * b;
            System.out.println(c);
        } else if (z.equals("/")) {
            d = (double)a / b;
            System.out.println(d);
        } else {
            System.out.println();
        }
    }
}