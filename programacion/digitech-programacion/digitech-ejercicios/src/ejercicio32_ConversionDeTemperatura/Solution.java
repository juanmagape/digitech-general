package ejercicio32_ConversionDeTemperatura;

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner print = new Scanner(System.in);

        float gradosC = print.nextInt();

        float fahrenheit = gradosC * 9/5 + 32;
        float kelvin = gradosC + 273.15f;


        System.out.println("Fahrenheit: " + fahrenheit);
        System.out.println("Kelvin: " + kelvin);
    }
}
