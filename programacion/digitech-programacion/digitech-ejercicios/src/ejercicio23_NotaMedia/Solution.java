package ejercicio23_NotaMedia;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        float nota1 = print.nextFloat();
        float nota2 = print.nextFloat();
        float nota3 = print.nextFloat();

        float sumaNotas = nota1 + nota2 + nota3;

        float notaMedia = sumaNotas / 3;

        System.out.println(notaMedia);


    }
}

