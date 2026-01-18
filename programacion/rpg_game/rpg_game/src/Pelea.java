import java.util.ArrayList;
import java.util.Scanner;

public class Pelea {

    static String[] arrayEnemigos = {"Ogro", "Goblin", "Mago oscuro", "Slime", "Arbol encantado"};
    static String[] arrayInteraccion = {"normal", "esquivo", "critico"};
    static String[] arrayRecompensas = {"Poción de vida", "Poción mágica", "Poción de daño", "Poción de daño extremo"};

    static ArrayList<String> arrayInventario = new ArrayList<>(10);

    static double[] vidaBase = {90, 40, 55, 30, 100};
    static double vidaActualEnemigo;

    static boolean peleaAcabada = false;
    static int enemigo = (int) (Math.random() * 5);
    static boolean vivo = true;

    public static double generarVidaEnemigo(int id) {
        return vidaBase[id];
    }

    public static void pelea(String nombre, String clase, Scanner print, int oro, int mana, int danoMagico, int danoMelee, int vida) throws InterruptedException {

        vidaActualEnemigo = generarVidaEnemigo(enemigo);

        System.out.println("\n\n\nEnemigo por luchar: " + arrayEnemigos[enemigo]);
        System.out.println("Vida del enemigo: " + vidaActualEnemigo + "/" + vidaBase[enemigo]);
        System.out.println(nombre + ", clase " + clase);
        Thread.sleep(1000);
        while (vivo) {

            peleaAcabada = false;

            while (!peleaAcabada) {

                System.out.println("==================================================");
                System.out.println("Estado actual:");
                System.out.println("Maná actual: " + mana);
                System.out.println("Oro actual: " + oro);
                System.out.println("Vida enemigo: " + vidaActualEnemigo+ "/" + vidaBase[enemigo]);
                System.out.println("==================================================");
                Thread.sleep(1000);

                System.out.println("\n\n==================================================");

                System.out.println("\nEscoge una opción:");
                System.out.println("[1] - Atacar");
                System.out.println("[2] - Ataque mágico");
                System.out.println("[3] - Objetos");
                System.out.println("[4] - Rendirse");
                System.out.println("\n==================================================");

                int opcionPelea = print.nextInt();
                print.nextLine();

                switch (opcionPelea) {

                    case 1:
                        int inter = (int) (Math.random() * 3);
                        System.out.println("Estado: " + arrayInteraccion[inter]);

                        if (inter == 0) {
                            System.out.println("Ataque normal: " + danoMelee);
                            vidaActualEnemigo -= danoMelee;

                        } else if (inter == 1) {
                            System.out.println("El enemigo esquivó.");

                        } else if (inter == 2) {
                            double critico = danoMelee * 1.5;
                            System.out.println("Crítico: " + critico);
                            vidaActualEnemigo -= critico;
                        }
                        break;

                    case 2:
                        if (mana < 25) {
                            System.out.println("No tienes suficiente maná!");
                            break;
                        }

                        mana -= 25;
                        double danoMag = danoMagico * 1.5;
                        vidaActualEnemigo -= danoMag;
                        System.out.println("Ataque mágico (-25 maná) daño: " + danoMag);
                        break;

                    case 3:
                        if (arrayInventario.isEmpty()) {
                            System.out.println("Inventario vacío.");
                            break;
                        }

                        for (int i = 0; i < arrayInventario.size(); i++) {
                            System.out.println(i + " - " + arrayInventario.get(i));
                        }

                        System.out.println("Selecciona un objeto:");
                        int opInv = print.nextInt();

                        if (opInv < 0 || opInv >= arrayInventario.size()) {
                            System.out.println("Índice inválido.");
                            break;
                        }

                        String objeto = arrayInventario.get(opInv);

                        switch (objeto) {
                            case "Poción de vida":
                                vida += 25;
                                System.out.println("+25 vida");
                                break;

                            case "Poción mágica":
                                mana += 25;
                                System.out.println("+25 maná");
                                break;

                            case "Poción de daño":
                                danoMelee += 5;
                                System.out.println("+5 daño físico");
                                break;

                            case "Poción de daño extremo":
                                danoMelee = danoMagico * 2;
                                System.out.println("Daño físico x2");
                                break;
                        }

                        arrayInventario.remove(opInv);
                        break;

                    case 4:
                        System.out.println("Te rendiste. Pierdes 5 oro.");
                        oro -= 5;
                        peleaAcabada = true;
                        continue;
                }

                if (vidaActualEnemigo <= 0) {
                    peleaAcabada = true;
                    continue;
                }

                System.out.println("\nAtaque de " + arrayEnemigos[enemigo]);

                int danoEnemigo = (int) (Math.random() * 11) + 10;
                vida -= danoEnemigo;

                System.out.println("Daño enemigo: " + danoEnemigo);
                System.out.println("Vida actual: " + vida);

                if (vida <= 0) {
                    System.out.println("\nHas muerto en combate...");
                    vivo = false;
                    peleaAcabada = true;
                    break;
                }

                mana += 10;
                System.out.println("Recuperas +10 maná.");
            }

            if (!vivo) break;

            if (vidaActualEnemigo <= 0) {
                int recompensa = (int) (Math.random() * 4);
                int oroRandom = (int) (Math.random() * 4 + 1);

                oro += oroRandom;
                arrayInventario.add(arrayRecompensas[recompensa]);

                System.out.println("\nHas derrotado al enemigo!");
                System.out.println("Recompensa: " + arrayRecompensas[recompensa] + " + " + oroRandom + " oro.");
            }

            System.out.println("\nTras la batalla ves una taberna...");
            System.out.println("¿Entrar? (1 SI / 2 NO)");
            int opT = print.nextInt();

            if (opT == 1) {

                int obj1 = (int) (Math.random() * 4);
                int obj2 = (int) (Math.random() * 4);
                int obj3 = (int) (Math.random() * 4);

                int p1 = (int) (Math.random() * 10);
                int p2 = (int) (Math.random() * 6);
                int p3 = (int) (Math.random() * 8);

                System.out.println("Bienvenido a la taberna!");
                System.out.println("[1] - " + arrayRecompensas[obj1] + " | Precio: " + p1);
                System.out.println("[2] - " + arrayRecompensas[obj2] + " | Precio: " + p2);
                System.out.println("[3] - " + arrayRecompensas[obj3] + " | Precio: " + p3);

                System.out.println("Comprar algo? (1 SI / 2 NO)");
                int comprar = print.nextInt();

                if (comprar == 1) {
                    System.out.println("Opción a comprar:");
                    int opC = print.nextInt();

                    switch (opC) {
                        case 1:
                            arrayInventario.add(arrayRecompensas[obj1]);
                            oro -= p1;
                            break;
                        case 2:
                            arrayInventario.add(arrayRecompensas[obj2]);
                            oro -= p2;
                            break;
                        case 3:
                            arrayInventario.add(arrayRecompensas[obj3]);
                            oro -= p3;
                            break;
                    }
                }
            }

            enemigo = (int) (Math.random() * 5);
            vidaActualEnemigo = generarVidaEnemigo(enemigo);

            System.out.println("\nUn nuevo enemigo aparece: " + arrayEnemigos[enemigo] + " con " + vidaActualEnemigo + " de vida.");
        }

        System.out.println("\nHas muerto. ¿Quieres volver a jugar? (1 SI / 2 NO)");
        int opcionJugar = print.nextInt();

        if (opcionJugar == 1) {
            Main.Programa();
        }
    }
}
