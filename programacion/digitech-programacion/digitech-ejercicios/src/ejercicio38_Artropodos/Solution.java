package ejercicio38_Artropodos;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int insectos = print.nextInt() * 6;
        int aracnidos = print.nextInt() * 8;
        int crustacis = print.nextInt() * 10;
        int miriapodos = print.nextInt() * 2;
        int  mirSeg = print.nextInt();
        int miriapodos4Patas = print.nextInt() * 4;
        int mirSeg4Patas = print.nextInt();

        int calculoTotal = insectos + aracnidos + crustacis + miriapodos;
        System.out.println(calculoTotal);    }
}
