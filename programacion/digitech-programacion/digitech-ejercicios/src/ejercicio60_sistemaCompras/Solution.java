package ejercicio60_sistemaCompras;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        int cantidadProductos = print.nextInt();
        int precio = print.nextInt();
        int dineroDisp = print.nextInt();
        int limiteProductos = print.nextInt();
        int envioGratis = print.nextInt();

        boolean res = (cantidadProductos < limiteProductos && precio < dineroDisp);
        boolean res2 = (precio * cantidadProductos >= envioGratis);
        float cambio = (dineroDisp - precio * cantidadProductos);

        System.out.println("Compra valida: " + res);
        System.out.println("Envio gratis: " + res2);
        System.out.println("Cambio: " + cambio);

    }
}



