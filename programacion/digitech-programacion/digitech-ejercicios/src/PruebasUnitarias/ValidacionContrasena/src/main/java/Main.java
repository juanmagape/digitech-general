import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ValidacionContrasena val = new ValidacionContrasena();

        System.out.println("======================================");
        System.out.println("====== Validador de contraseñas ======");
        System.out.println("======================================");

        while (true) {
            System.out.println("======================================");
            System.out.println("Ingrese una contraseña para validar:");
            String contrasena = sc.nextLine();
            System.out.println("======================================");

            val.Validacion(contrasena);

            System.out.println("======================================");
            System.out.println("Quieres intentar otra contraseña? (S/N)");
            String opc = sc.nextLine();

            if (opc.equalsIgnoreCase("N")) {
                System.exit(0);
            }
        }


    }
}
