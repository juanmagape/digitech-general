package ejercicio58_DosReinas1;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {

        Scanner print = new Scanner(System.in);

        int xReina1 = print.nextInt();
        int yReina1 = print.nextInt();
        int xReina2 = print.nextInt();
        int yReina2 = print.nextInt();

        boolean res = (xReina1 == xReina2) || (yReina1 == yReina2) || (xReina1 - xReina2) == (yReina1 - yReina2) || (xReina1 - xReina2) == -(yReina1 - yReina2);
        System.out.println(res);
    }
}



