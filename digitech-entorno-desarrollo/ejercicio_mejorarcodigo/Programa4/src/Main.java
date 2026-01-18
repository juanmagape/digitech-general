import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Random r = new Random();

        int v = 30, m = 30, d = 5, x = 0;
        boolean a = true;

        while (a) {
            int o = s.nextInt();

            if (o == 0) break;

            if (o == 1) {
                v -= 3 + r.nextInt(5);
                x += 5 + r.nextInt(7);
                if (x >= 50 && x % 50 < 10) d += 2;
            }

            if (o == 2) {
                v += 10;
                if (v > m) v = m;
            }

            if (o == 3) v = m;

            if (o == 4) {
                x += 5 + r.nextInt(7);
                d += x / 100;
            }

            if (v <= 0) a = false;
        }


}
}
