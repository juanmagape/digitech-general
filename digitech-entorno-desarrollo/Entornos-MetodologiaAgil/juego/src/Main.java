import java.util.Scanner;

public class Main {
    public static Scanner sc = new Scanner(System.in);
    public static Personaje personaje1 = new Personaje("Jugador 1", 100, 100, 10, 15, 200);
    public static Personaje personaje2 = new Personaje("Jugador 2", 100, 100, 10, 15, 200);

    public static void main(String[] args) {
        crearPersonaje1();
        crearPersonaje2();
        iniciarPelea();
    }

    static void crearPersonaje1() {
        personaje1.mostrarEstadisticasJug();
        while (personaje1.getSkillPoints() > 0) {
            System.out.println("Reparte los puntos de habilidad entre los siguientes atributos: ");
            System.out.println("1. Cantidad de mana");
            System.out.println("2. Daño cuerpo a cuerpo");
            System.out.println("3. Daño magia");
            System.out.println("4. Vida");
            System.out.println("Puntos de habilidad restantes: " + personaje1.getSkillPoints());

            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("¿Cuántos puntos de habilidad quieres asignar a la cantidad de mana?");
                    int puntosMana = sc.nextInt();
                    personaje1.setCantMana((personaje1.getCantMana() + (puntosMana * 2)));
                    personaje1.setSkillPoints(personaje1.getSkillPoints() - puntosMana);
                    break;
                case 2:
                    System.out.println("¿Cuántos puntos de habilidad quieres asignar al daño cuerpo a cuerpo?");
                    int puntosCuerpoaCuerpo = sc.nextInt();
                    personaje1.setDanoCuerpoaCuerpo((int) (personaje1.getDanoCuerpoaCuerpo() + (puntosCuerpoaCuerpo * 0.5)));
                    personaje1.setSkillPoints(personaje1.getSkillPoints() - puntosCuerpoaCuerpo);
                    break;
                case 3:
                    System.out.println("¿Cuántos puntos de habilidad quieres asignar al daño magia?");
                    int puntosDanoMagia = sc.nextInt();
                    personaje1.setDanoMagia((int) (personaje1.getDanoMagia() + (puntosDanoMagia * 0.5)));
                    personaje1.setSkillPoints(personaje1.getSkillPoints() - puntosDanoMagia);
                    break;
                case 4:
                    System.out.println("¿Cuántos puntos de habilidad quieres asignar a la vida?");
                    int puntosVida = sc.nextInt();
                    personaje1.setVida((personaje1.getVida() + (puntosVida * 3)));
                    personaje1.setSkillPoints(personaje1.getSkillPoints() - puntosVida);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del 1 al 4.");
                    break;
            }
            personaje1.mostrarEstadisticasJug();
        }
    }

    static void crearPersonaje2() {
        personaje2.mostrarEstadisticasJug();
        while (personaje2.getSkillPoints() > 0) {
            System.out.println("Reparte los puntos de habilidad entre los siguientes atributos: ");
            System.out.println("1. Cantidad de mana");
            System.out.println("2. Daño cuerpo a cuerpo");
            System.out.println("3. Daño magia");
            System.out.println("4. Vida");
            System.out.println("Puntos de habilidad restantes: " + personaje2.getSkillPoints());

            int opcion = sc.nextInt();
            switch (opcion) {
                case 1:
                    System.out.println("¿Cuántos puntos de habilidad quieres asignar a la cantidad de mana?");
                    int puntosMana = sc.nextInt();
                    personaje2.setCantMana((personaje2.getCantMana() + (puntosMana * 2)));
                    personaje2.setSkillPoints(personaje2.getSkillPoints() - puntosMana);
                    break;
                case 2:
                    System.out.println("¿Cuántos puntos de habilidad quieres asignar al daño cuerpo a cuerpo?");
                    int puntosCuerpoaCuerpo = sc.nextInt();
                    personaje2.setDanoCuerpoaCuerpo((int) (personaje2.getDanoCuerpoaCuerpo() + (puntosCuerpoaCuerpo * 0.5)));
                    personaje2.setSkillPoints(personaje2.getSkillPoints() - puntosCuerpoaCuerpo);
                    break;
                case 3:
                    System.out.println("¿Cuántos puntos de habilidad quieres asignar al daño magia?");
                    int puntosDanoMagia = sc.nextInt();
                    personaje2.setDanoMagia((int) (personaje2.getDanoMagia() + (puntosDanoMagia * 0.5)));
                    personaje2.setSkillPoints(personaje2.getSkillPoints() - puntosDanoMagia);
                    break;
                case 4:
                    System.out.println("¿Cuántos puntos de habilidad quieres asignar a la vida?");
                    int puntosVida = sc.nextInt();
                    personaje2.setVida((personaje2.getVida() + (puntosVida * 3)));
                    personaje2.setSkillPoints(personaje2.getSkillPoints() - puntosVida);
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, elige una opción del 1 al 4.");
                    break;
            }
            personaje2.mostrarEstadisticasJug();
        }
    }

    static void ataqueNormal(Personaje atacante, Personaje defensor) {
        int probabilidadAcierto = (int) (Math.random() * 100) + 1;

        if (probabilidadAcierto <= 80) {
            defensor.setVida(defensor.getVida() - atacante.getDanoCuerpoaCuerpo());
            System.out.println(atacante.getNombre() + " acierta el golpe y quita " + atacante.getDanoCuerpoaCuerpo() + " de vida.");
        } else {
            System.out.println(atacante.getNombre() + " intento golpear a " + defensor.getNombre() + " pero fallo.");
        }
    }

    static void ataqueMagico(Personaje atacante, Personaje defensor) {
        int costeMana = 20;

        if (costeMana > atacante.getCantMana()) {
            System.out.println(atacante.getNombre() + " no tiene suficiente mana para el ataque magico.");
            return;
        }

        atacante.setCantMana(atacante.getCantMana() - costeMana);
        defensor.setVida(defensor.getVida() - atacante.getDanoMagia());

        System.out.println(atacante.getNombre() + " lanza un hechizo y hace " + atacante.getDanoMagia() + " de daño magico.");
    }

    static void curarse(Personaje jugador) {
        int costeCuracion = 50;

        if (costeCuracion > jugador.getCantMana()) {
            System.out.println(jugador.getNombre() + " no tiene suficiente mana para curarse.");
            return;
        }

        int cantidadCurada = (int) (Math.random() * 21) + 40;

        jugador.setCantMana(jugador.getCantMana() - costeCuracion);
        int nuevaVida = jugador.getVida() + cantidadCurada;

        if (nuevaVida > 200) {
            nuevaVida = 200;
        }

        jugador.setVida(nuevaVida);

        System.out.println(jugador.getNombre() + " se ha curado " + cantidadCurada + " puntos de vida.");
    }

    static void iniciarPelea() {
        System.out.println("\nLa pelea ha comenzado.");

        boolean turnoJugador1 = true;

        while (personaje1.getVida() > 0 && personaje2.getVida() > 0) {

            Personaje atacante;
            Personaje defensor;

            if (turnoJugador1) {
                atacante = personaje1;
                defensor = personaje2;
            } else {
                atacante = personaje2;
                defensor = personaje1;
            }

            System.out.println("\nTurno de: " + atacante.getNombre());
            System.out.println("Vida de " + defensor.getNombre() + ": " + defensor.getVida());
            System.out.println("Mana de " + atacante.getNombre() + ": " + atacante.getCantMana());
            System.out.println("Vida de " + atacante.getNombre() + ": " + atacante.getVida());
            System.out.println("1. Ataque Cuerpo a Cuerpo");
            System.out.println("2. Ataque Magico");
            System.out.println("3. Curarse");
            System.out.print("Elige tu accion: ");

            int accion = sc.nextInt();

            if (accion == 1) {
                ataqueNormal(atacante, defensor);
            } else if (accion == 2) {
                ataqueMagico(atacante, defensor);
            } else if (accion == 3) {
                curarse(atacante);
            } else {
                System.out.println("Opcion no valida. Pierdes tu turno.");
            }

            if (defensor.getVida() <= 0) {
                System.out.println(defensor.getNombre() + " ha sido derrotado.");
                System.out.println(atacante.getNombre() + " ha ganado.");
                break;
            }

            turnoJugador1 = !turnoJugador1;
        }
    }
}