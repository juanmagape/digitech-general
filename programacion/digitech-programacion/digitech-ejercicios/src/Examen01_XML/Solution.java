package Examen01_XML;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        String nombre = print.nextLine();
        String edad = print.nextLine();
        String ciudad = print.nextLine();


        System.out.println("<?xml version=1.0 encoding=UTF-8?>\n");
        System.out.println("<persona>");
        System.out.println("<nombre>" + nombre + "  </nombre>");
        System.out.println("<edad>" + edad + "</edad>");
        System.out.println("<ciudad>" + ciudad + "</ciudad>");
        System.out.println("</persona>");


    }
}




