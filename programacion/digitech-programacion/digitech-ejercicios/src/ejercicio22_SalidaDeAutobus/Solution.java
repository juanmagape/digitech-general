package ejercicio22_SalidaDeAutobus;

import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        int autobus1 = print.nextInt();
        int autobus2 = print.nextInt();
        int pasajeros = print.nextInt();

        int autobuses = autobus1 + autobus2;

        int pasarejosPorBus = autobuses * pasajeros;

        System.out.println(pasarejosPorBus);


    }
}

