package ejercicio59_clasificadorDeTriangulos;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        int lado1 = print.nextInt();
        int lado2 = print.nextInt();
        int lado3 = print.nextInt();

        boolean equilatero = lado1 == lado2 && lado2 == lado3;
        boolean isosceles = lado1 == lado2 && lado3 != lado2 || lado2 == lado3 && lado3 != lado1 || lado3 == lado1 && lado1 != lado2;
        boolean escaleno = lado1 != lado3 && lado1 != lado2;

        System.out.println("Equilatero: " + equilatero);
        System.out.println("Isosceles: " + isosceles);
        System.out.println("Escaleno: " + escaleno);

    }
}