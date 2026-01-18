package ejercicio51_login;
import java.util.Scanner;

public class Solution {
    public static void main() {
        Scanner sc = new Scanner(System.in);

        String usuario = "Admin123";
        String passw = "sudopsswd";

        String userInput = sc.nextLine();
        String passInput = sc.nextLine();

        System.out.println(userInput.equals(usuario) && passInput.equals(passw));
    }
}
