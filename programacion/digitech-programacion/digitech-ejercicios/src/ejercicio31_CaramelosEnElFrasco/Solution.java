package ejercicio31_CaramelosEnElFrasco;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        int alto = print.nextInt();
        int ancho = print.nextInt();
        int profundo = print.nextInt();
        int tamanoCaramelo = print.nextInt();

        int tamanoFrasco = alto * ancho * profundo;

        int caramelosDentro = tamanoFrasco / tamanoCaramelo;


        System.out.println(caramelosDentro);
    }
}