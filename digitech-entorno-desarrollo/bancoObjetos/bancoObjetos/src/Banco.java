import java.util.Scanner;

class DetallesPersona {
    private String nombre;
    private int dinero;
    private int dni;

    public DetallesPersona(String nombre, int dinero, int dni) {
        this.nombre = nombre;
        this.dinero = dinero;
        this.dni = dni;
    }

    public int getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public int getDinero() {
        return dinero;
    }

    public void setDinero(int dinero) {
        this.dinero = dinero;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}

public class Banco {
    public static void main(String[] args) throws InterruptedException {
        Scanner scanner = new Scanner(System.in);
        boolean seguir = true;
        DetallesPersona persona = new DetallesPersona("Pepe Reina", 0, 12345678);
        boolean accesoCuenta = true;

        System.out.println("================================");
        System.out.println("       Bienvenido al Banco      ");
        System.out.println("================================");
        Thread.sleep(500);

        while(accesoCuenta) {
            System.out.println("Para acceder a su cuenta porfavor, introduzca su DNI:");
            int dniInput = scanner.nextInt();
            scanner.nextLine();

            if (dniInput != persona.getDni()) {
                System.out.println("DNI incorrecto. Acceso denegado.");
            } else {
                System.out.println("DNI correcto. Acceso concedido.");
                accesoCuenta = false;
            }
        }


        System.out.println("\n\n================================");
        System.out.println("Bienvenido, " + persona.getNombre());
        System.out.println("================================");
        Thread.sleep(1000);

        while (seguir) {
            MostrarMenu();

            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    DepositarDinero(scanner, persona);
                    break;
                case 2:
                    RetirarDinero(scanner, persona);
                    break;
                case 3:
                    ConsultarSaldo(scanner, persona);
                    break;
                case 4:
                    SalirBanco();
                    break;
            }
        }


        scanner.close();
    }

    public static void MostrarMenu() {
            System.out.println("================================");
            System.out.println("Que gestión desea realizar?");
            System.out.println("\n[1] - Depositar Dinero\n[2] - Retirar Dinero\n[3] - Consultar Saldo\n[4] - Salir");
            System.out.println("================================");
        }

    public static void DepositarDinero(Scanner scanner, DetallesPersona persona) throws InterruptedException{
            System.out.println("\n\n================================");
            System.out.println("Has escogido la opción de Depositar Dinero");
            System.out.println("Ingrese la cantidad a depositar [MIN: 10€ | MAX: 100.000€]:");
            int dineroDepositar = scanner.nextInt();

            if (dineroDepositar > 10 && dineroDepositar < 100000) {
                persona.setDinero(dineroDepositar);
                System.out.println("Depósito exitoso. Su nuevo saldo es: " + persona.getDinero());
            } else {
                System.out.println("Cantidad inválida. Debe ser entre 10€ y 100,000€.");
            }
            System.out.println("\n================================");
            Thread.sleep(500);
        }

    public static void RetirarDinero(Scanner scanner, DetallesPersona persona) throws InterruptedException{
            if (persona.getDinero() <= 0) {
                    System.out.println("No tiene fondos para retirar. Por favor, deposite dinero primero.");
                    Thread.sleep(500);
                    return;
            }
            System.out.println("\n\n================================");
            System.out.println("Has escogido la opción de Retirar Dinero");
            System.out.println("Ingrese la cantidad a retirar [MIN: 10€ | MAX: 100.000€]:");
            int dineroRetirar = scanner.nextInt();

            if (dineroRetirar > 10 && dineroRetirar < 100000) {
                if (dineroRetirar <= persona.getDinero()) {
                    persona.setDinero(persona.getDinero() - dineroRetirar);
                    System.out.println("Retiro exitoso. Su nuevo saldo es: " + persona.getDinero());
                } else {
                    System.out.println("Fondos insuficientes para este retiro.");
                }
            } else {
                System.out.println("Cantidad inválida. Debe ser entre 10€ y 100,000€.");
            }
            System.out.println("\n================================");
            Thread.sleep(500);
        }

    public static void ConsultarSaldo(Scanner scanner, DetallesPersona persona) throws InterruptedException{
            System.out.println("\n\n================================");
            System.out.println("Has escogido la opción de Consultar Saldo");
            System.out.println("Su saldo actual es: " + persona.getDinero() + "€");
            scanner.nextLine();
            System.out.println("================================");
            Thread.sleep(500);
        }

    public static void SalirBanco() throws InterruptedException{
            System.out.println("\n\n================================");
            System.out.println("Gracias por usar nuestro servicio.");
            System.out.println("================================");
            Thread.sleep(500);
            System.exit(0);
        }
}
