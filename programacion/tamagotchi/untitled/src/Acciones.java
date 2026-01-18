import java.util.Scanner;
import java.util.Timer;

public class Acciones {

       static int energia = 20;
       static int hambre = 20;
       static int felicidad = 20;
       static int dinero = 20;
       static int cantidadComida = 5;
       static int cantidadBebida;
       static int cantidadJuguete;
       static boolean jugar = true;

    public static void acciones(Scanner print, String skin, String nombre) throws InterruptedException {

        if (energia == 0 || hambre == 0 || felicidad == 0) {
            System.out.println("El tamagotchi ha muerto");
            jugar = false;
        }

        while (jugar) {
            System.out.println("\n\n\n===========================================================\n");

            System.out.println(skin + " " + nombre);
            System.out.println( "🔥 Energia: " + energia + " | 🍔 Hambre: " + hambre + " | 🎉 Felicidad: " + felicidad + " | 💵 Dinero: " + dinero);
            System.out.println("\n===========================================================\n");

            System.out.println("\nQue quieres hacer?\n");

            System.out.println("{1} - Consumibles");
            System.out.println("{2} - Jugar");
            System.out.println("{3} - Dormir");
            System.out.println("{4} - Tienda");
            System.out.println("{5} - Ver estado");
            System.out.println("{6} - Salir");

            int eleccionAccion = print.nextInt();

            switch (eleccionAccion) {

                case 1:
                    System.out.println("\n\n\n===========================================================\n");

                    System.out.println("Has escogido la opción: Consumibles");
                    System.out.println("Que consumible quieres utilizar?");

                    System.out.println("\n\n{1} Comida: " + cantidadComida + " ( +3 Hambre, -1 Energia )");
                    System.out.println("{2} Bebida: " + cantidadBebida + " ( +1 Hambre, +2 Energia )");
                    System.out.println("{3} Juguete: " + cantidadJuguete + " ( +3 Felicidad, -1 Energia )");
                    System.out.println("{4} Ninguno");

                    int eleccionConsumible = print.nextInt();

                    switch (eleccionConsumible) {

                        case 1:
                            System.out.println("Has elegido el consumible comida");
                            if (cantidadComida == 0) {
                                System.out.println("No tienes comida, ves a comprarla a la tienda");
                            } else {
                                System.out.println("Le has dado de comer");
                                System.out.println("Reduce el hambre (+3), menos energia (-1) y menos cantidad de comida (-1)");
                                cantidadComida -= 1;

                                hambre += 3;
                                energia -= 1;
                            }
                            Thread.sleep(2000);

                            break;
                        case 2:
                            System.out.println("Has elegido el consumible bebida");
                            if (cantidadBebida == 0) {
                                System.out.println("No tienes bebida, ves a comprarla a la tienda");
                            } else {
                                System.out.println("Le has dado de beber");
                                System.out.println("Reduce el hambre (+1), y tiene más energia (+2)");
                                cantidadBebida -= 1;

                                hambre += 1;
                                energia += 2;
                            }
                            Thread.sleep(2000);

                            break;
                        case 3:
                            System.out.println("Has elegido el consumible juguete");
                            if (cantidadJuguete == 0) {
                                System.out.println("No tienes juguetes, ves a comprarlos a la tienda");
                            } else {
                                System.out.println("Le has dado el juguete");
                                System.out.println("Aumenta la felicidad (+3), menos energia (-1)");
                                cantidadJuguete -= 1;

                                felicidad += 3;
                                energia -= 1;
                            }
                            Thread.sleep(2000);

                            break;
                        case 4:
                            System.out.println("Has decidido no utilizar consumibles.");
                            break;
                        default:
                            System.out.println("Número introducido incorrecto");
                            Thread.sleep(2000);

                            break;

                    }

                    System.out.println("\n===========================================================\n");

                    Thread.sleep(1000);
                    break;
                case 2:

                    System.out.println("\n\n\n===========================================================\n");

                    System.out.println("Has escogido la opción: Jugar");
                    System.out.println("Que juego quieres jugar? (1: Dados / 2: Piedra Papel Tijera / 3: Pulso Digital)");
                    int eleccionJuego = print.nextInt();
                    if (eleccionJuego == 1) {
                        dados();
                    } else if (eleccionJuego == 2) {
                        piedraPapelTijera(print);
                    } else if (eleccionJuego == 3){
                        PulsoDigital();
                    } else {
                        System.out.println("Número introducido incorrecto");
                    }
                    System.out.println("\n===========================================================\n");

                    Thread.sleep(2000);
                    break;
                case 3:
                    System.out.println("\n\n\n===========================================================\n");
                    System.out.println("Has escogido la opción dormir");
                    System.out.println("La energia aumenta +4 y la felicidad se reduce -1");

                    energia += 4;
                    felicidad -= 1;
                    System.out.println("\n===========================================================\n");

                    Thread.sleep(2000);
                    break;
                case 4:
                    System.out.println("\n\n\n===========================================================\n");

                    System.out.println("Bienvenido a la tienda");
                    System.out.println("\nDinero actual: " + dinero);

                    System.out.println("Quieres comprar {1} o vender {2}");
                    int eleccion = print.nextInt();

                    if (eleccion == 1) {
                        System.out.println("\n\n{1} Comida: 3 monedas ( +3 Hambre, -1 Energia )");
                        System.out.println("{2} Bebida: 2 monedas ( +1 Hambre, +2 Energia )");
                        System.out.println("{3} Juguete: 3 monedas ( +3 Felicidad, -1 Energia )");

                        System.out.println("\nQue quieres comprar?");
                        int eleccionTienda = print.nextInt();
                        int cantidadCompra;

                        switch (eleccionTienda) {

                            case 1:
                                System.out.println("Has elegido comprar comida, cuanta cantidad quieres comprar?");
                                cantidadCompra = print.nextInt();
                                if (cantidadCompra * 3 > dinero) {
                                    System.out.println("No tienes suficiente dinero");
                                } else {
                                    System.out.println("Comida comprada");
                                    cantidadComida += cantidadCompra;
                                    dinero -= cantidadCompra * 3;
                                }
                                break;
                            case 2:
                                System.out.println("Has elegido comprar bebida, cuanta cantidad quieres comprar?");
                                cantidadCompra = print.nextInt();

                                if (cantidadCompra * 2 > dinero) {
                                    System.out.println("No tienes suficiente dinero");
                                } else {
                                    System.out.println("Bebida comprada");
                                    cantidadBebida += cantidadCompra;
                                    dinero -= cantidadCompra * 3;
                                }
                                break;
                            case 3:
                                System.out.println("Has elegido comprar juguetes, cuanta cantidad quieres comprar?");
                                cantidadCompra = print.nextInt();

                                if (cantidadCompra * 3 > dinero) {
                                    System.out.println("No tienes suficiente dinero");
                                } else {
                                    System.out.println("Juguete comprado");
                                    cantidadJuguete += cantidadCompra;
                                    dinero -= cantidadCompra * 3;
                                }
                                break;
                            default:
                                System.out.println("Opción introducida incorrecta.");
                                break;
                        }
                    } else if (eleccion == 2) {
                        System.out.println("Que objeto quieres vender?");
                        System.out.println("\n\n{1} Comida: 3 monedas ( Tienes: " + cantidadComida + " )");
                        System.out.println("{2} Bebida: 2 monedas ( Tienes: " + cantidadBebida +  " )");
                        System.out.println("{3} Juguete: 3 monedas ( Tienes: " + cantidadJuguete + " )");

                        int eleccionTienda = print.nextInt();
                        int cantidadVenta;

                        switch (eleccionTienda) {

                            case 1:
                                System.out.println("Has elegido vender comida, cuanta cantidad quieres vender?");
                                cantidadVenta = print.nextInt();
                                if (cantidadVenta > cantidadComida) {
                                    System.out.println("No tienes suficiente comida");
                                } else {
                                    System.out.println("Comida vendida");
                                    cantidadComida -= cantidadVenta;
                                    dinero += cantidadVenta * 3;
                                }
                                break;
                            case 2:
                                System.out.println("Has elegido vender bebidas, cuanta cantidad quieres vender?");
                                cantidadVenta = print.nextInt();
                                if (cantidadVenta > cantidadBebida) {
                                    System.out.println("No tienes suficiente bebida");
                                } else {
                                    System.out.println("Bebida vendida");
                                    cantidadBebida -= cantidadVenta;
                                    dinero += cantidadVenta * 3;
                                }
                                break;
                            case 3:
                                System.out.println("Has elegido vender juguetes, cuanta cantidad quieres vender?");
                                cantidadVenta = print.nextInt();
                                if (cantidadVenta > cantidadJuguete) {
                                    System.out.println("No tienes suficiente juguetes");
                                } else {
                                    System.out.println("Juguetes vendidos");
                                    cantidadJuguete -= cantidadVenta;
                                    dinero += cantidadVenta * 3;
                                }
                                break;
                            default:
                                System.out.println("Opción introducida incorrecta.");
                                break;
                        }

                    } else {
                            System.out.println("Opción introducida incorrecta.");
                    }


                            System.out.println("\n===========================================================\n");

                            Thread.sleep(2000);
                            break;
                        case 5:
                            System.out.println("\n===========================================================\n");

                            System.out.println("Estadisticas actuales: \n");

                            System.out.println("🔥 Energia: " + energia);
                            System.out.println("🍔 Hambre: " + hambre);
                            System.out.println("🎉 Felicidad: " + felicidad);
                            System.out.println("💵 Dinero: " + dinero +"\n");

                            if (felicidad > 7 && hambre > 4 && energia > 5) {
                                System.out.println(skin + " " + nombre + ": Feliz y activo 😁");
                            } else if (energia > 7 && hambre < 5) {
                                System.out.println(skin + " " + nombre + ": Está hiperactivo 🫨");
                            } else if (felicidad <= 3 && energia <= 3 && hambre <= 3){
                                System.out.println(skin + " " + nombre + ": Está en las ultimas 😵");
                            }

                            if (hambre <= 3) {
                                System.out.println(skin + " " + nombre + ": Tiene hambre, deberias darle de comer 🍥");
                            }
                            if (energia <= 3) {
                                System.out.println(skin + " " + nombre + ": Está muy cansado, necesita dormir 😴");
                            }
                            if (felicidad <= 3) {
                                System.out.println(skin + " " +nombre + ": Está triste, juega con él 🛝");
                            }
                            System.out.println("\n===========================================================\n");

                            Thread.sleep(4000);
                            break;
                        case 6:
                            System.out.println("\n\n\n===========================================================\n");

                            System.out.println("Saliendo del programa");

                            System.out.println("\n===========================================================\n");

                            jugar = false;
                            Thread.sleep(2000);
                            break;
                        default:
                            System.out.println("Opción escogida incorrecta");
                            break;
                    }
            energia = Math.min(energia, 20);
            hambre = Math.min(hambre, 20);
            felicidad = Math.min(felicidad, 20);
        }
    }

    public static void dados() throws InterruptedException {

        int jugador = (int) (Math.random() * 6) + 1;
        int tamagotchi = (int) (Math.random() * 6) + 1;

        System.out.println("Jugador: " + jugador);
        System.out.println("Tamagotchi: " + tamagotchi);

        if (jugador > tamagotchi) {
            System.out.println("Has ganado!");
            System.out.println("+2 de felicidad | +3 monedas | -2 de energia");

            felicidad += 2;
            dinero += 3;
            energia -= 2;

            Thread.sleep(1000);
        } else if (jugador < tamagotchi) {
            System.out.println("Has perdido!");
            System.out.println("-1 de Felicidad");
            Thread.sleep(1000);

            felicidad -= 1;

        } else {
            System.out.println("Empate, no ha pasado nada");
            Thread.sleep(1000);
        }

    }

    public static void piedraPapelTijera(Scanner print) throws InterruptedException {
        System.out.println("\nIntroduce tu jugada");
        System.out.println("1 - Piedra");
        System.out.println("2 - Papel");
        System.out.println("3 - Tijera");

        int jugada = print.nextInt();
        int jugadaTama = (int) (Math.random() * 2) + 1;
        Thread.sleep(1000);

        System.out.println(jugada);
        System.out.println(jugadaTama);
        Thread.sleep(1000);

        if (jugada == jugadaTama) {
            System.out.println("Empate, no ha pasado nada");
            Thread.sleep(1000);
        } else if (jugada == 1 && jugadaTama == 3 || jugada == 2 && jugadaTama == 1 || jugada == 3 && jugadaTama == 2){
            System.out.println("Has ganado!");
            System.out.println("+2 de felicidad | +3 monedas | -2 de energia");

            felicidad += 2;
            dinero += 3;
            energia -= 2;

            Thread.sleep(1000);

        } else {
            System.out.println("Has perdido!");
            System.out.println("-1 de Felicidad");

            felicidad -= 1;

            Thread.sleep(1000);

        }
    }

    public static void PulsoDigital() {
        System.out.println("\n\n\n===========================================================\n");
        System.out.println("Pulso digital");

        System.out.println("\nFuerza mínima: 1 - Fuerza máxima 5\n\n");
        int jugada = (int) (Math.random() * 5) + 1;
        int jugadaTama = (int) (Math.random() * 5) + 1;

        System.out.println("Jugador: " + jugada);
        System.out.println("Tamagotchi: " + jugadaTama);

        if (jugada == jugadaTama) {
            System.out.println("\nEmpate, no ha pasado nada.");
        } else if (jugada > jugadaTama) {
            System.out.println("\nHas ganado!");

            System.out.println("+2 de felicidad | +3 monedas | -2 de energia");

            felicidad += 2;
            dinero += 3;
            energia -= 2;
        } else {
            System.out.println("\nHas perdido!");
            System.out.println("-1 de Felicidad");

            felicidad -= 1;
        }
    }

}