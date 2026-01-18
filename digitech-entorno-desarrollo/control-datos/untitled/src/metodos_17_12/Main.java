package metodos_17_12;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static boolean seguirJuego = true;
    static int ataque = 0;
    static int vida = 100;
    static int defensa = 0;
    static int ataqueEnemigo = 0;
    static int vidaEnemigo;
    static int pocionesCurar;

    public static void main(String[] args) throws InterruptedException {
        Scanner print = new Scanner(System.in);
        Programa(print);
    }

    public static void Programa(Scanner print) throws InterruptedException {
        vidaEnemigo = (int) (Math.random() * 31 + 50);

        while (seguirJuego) {

            System.out.println("=================================================================");
            System.out.println("=================== SIMULADOR DE BATALLA ========================");
            System.out.println("=================================================================");

            Thread.sleep(1000);

            System.out.println("\n\n========================= MENÚ ==================================");
            System.out.println("[1] - Atacar");
            System.out.println("[2] - Escudo");
            System.out.println("[4] - Curarse");
            System.out.println("[4] - Mostrar estadísticas");
            System.out.println("[5] - Rendirse");

            System.out.println("=================================================================");

            System.out.println("\n\nESCOGE LA OPCIÓN A REALIZAR:");
            int eleccionMenu = 0;

            try {
                eleccionMenu = print.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("\nERROR: LA OPCIÓN DEBE SER UN NÚMERO DEL 1 AL 5");
                print.nextLine();
                continue;
            }

            switch (eleccionMenu) {
                case 1:
                    Ataque();
                    AtaqueEnemigo();
                    break;
                case 2:
                    Defensa();
                    AtaqueEnemigo();
                    break;
                case 3:
                    Curarse();
                    break;
                case 4:
                    MostrarEstadisticas();
                    break;
                case 5:
                    seguirJuego = false;
                    break;
                default:
                    System.out.println("\nERROR: OPCIÓN NO VÁLIDA. Elige un número del 1 al 5");
                    break;
            }

            System.out.println("\n=================================================================");

            Thread.sleep(1000);
            System.out.println("\n=================================================================");

            if (vida <= 0 || vidaEnemigo <= 0) {
                Final(print);
            }
        }
    }

    public static void Ataque() throws InterruptedException {
        ataque = (int) (Math.random() * 11 + 5);
        vidaEnemigo -= ataque;
        System.out.println("LE HAS QUITADO " + ataque + " DE VIDA, ACTUALMENTE TIENE " + vidaEnemigo + " DE VIDA");
        Thread.sleep(1000);
    }

    public static void AtaqueEnemigo() throws InterruptedException {
        ataqueEnemigo = (int) (Math.random() * 11 + 8); // 8–18
        System.out.println("=================================================================");

        if (defensa > 0) {
            System.out.println("\nHAS BLOQUEADO EL ATAQUE ENEMIGO");
            defensa -= ataqueEnemigo;
            defensa = 0;
        } else {
            System.out.println("EL ENEMIGO TE HA QUITADO " + ataqueEnemigo + " DE VIDA!");
            vida -= ataqueEnemigo;
        }

        System.out.println("\n=================================================================");
        Thread.sleep(1000);
    }

    public static void Defensa() throws InterruptedException {
        System.out.println("\n\n=================================================================");
        System.out.println("\nSE BLOQUEARA EL SIGUIENTE ATAQUE");
        defensa = 100;
        System.out.println("\n=================================================================");
        Thread.sleep(1000);
    }

    public static void Curarse() {
        pocionesCurar = (int) (Math.random() * 4 + 1);

        if (pocionesCurar == 0) {
            System.out.println("No tienes más pociones de cura");
        } else {
            pocionesCurar -= 1;
            int curacion = (int)(Math.random() * 16 + 10);
            vida += curacion;
            System.out.println("TE HAS CURADO " + curacion + " DE VIDA");
        }
    }

    public static void MostrarEstadisticas() {
        System.out.println("\n\n===================== ESTADÍSTICAS ===============================");
        System.out.println("\n[VIDA] - " + vida);
        System.out.println("[VIDA DEL ENEMIGO] - " + vidaEnemigo);
        System.out.println("\n=================================================================");
    }

    public static void Final(Scanner print) throws InterruptedException {
        int opcionJugar = 0;
        boolean entradaValida = false;

        System.out.println("=================================================================");

        if (vida <= 0) {
            System.out.println("Has perdido! ¿Quieres volver a jugar? (1 - SI / 2 - NO)");

            while (!entradaValida) {
                try {
                    opcionJugar = print.nextInt();

                    if (opcionJugar == 1) {
                        vida = 100;
                        vidaEnemigo = (int) (Math.random() * 31 + 50);
                        entradaValida = true;
                    } else if (opcionJugar == 2) {
                        seguirJuego = false;
                        entradaValida = true;
                    } else {
                        System.out.println("ERROR: Introduce 1 para SI o 2 para NO");
                        print.nextLine();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("ERROR: Debes introducir un número (1 o 2)");
                    print.nextLine();
                }
            }

        } else if (vidaEnemigo <= 0) {
            System.out.println("¡Has ganado!");
            System.out.println("¿Quieres volver a jugar? (1 - SI / 2 - NO)");

            while (!entradaValida) {
                try {
                    opcionJugar = print.nextInt();

                    if (opcionJugar == 1) {
                        vida = 100;
                        vidaEnemigo = (int) (Math.random() * 31 + 50);
                        entradaValida = true;
                    } else if (opcionJugar == 2) {
                        seguirJuego = false;
                        entradaValida = true;
                    } else {
                        System.out.println("ERROR: Introduce 1 para SI o 2 para NO");
                        print.nextLine();
                    }
                } catch (InputMismatchException e) {
                    System.out.println("ERROR: Debes introducir un número (1 o 2)");
                    print.nextLine();
                }
            }
        }

        System.out.println("\n=================================================================");
        Thread.sleep(1000);
    }
}
