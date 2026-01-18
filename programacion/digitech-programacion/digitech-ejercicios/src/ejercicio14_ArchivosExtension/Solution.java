package ejercicio14_ArchivosExtension;

import java.util.Locale;
import java.util.Scanner;

public class Solution {
    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        String ext = print.next();
        String archivo = print.nextLine();

        String ext2 = print.next();
        String archivo2 = print.nextLine();

        String ext3 = print.next();
        String archivo3 = print.nextLine();

        String ext4 = print.next();
        String archivo4 = print.nextLine();

        System.out.println(archivo4 + " " + ext4);
        System.out.println(archivo3 + " " + ext3);
        System.out.println(archivo2 + " " + ext2);
        System.out.println(archivo + " " + ext);


    }
}