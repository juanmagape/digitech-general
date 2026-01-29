package MatricesLibre;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static String[] palabras = {
            "altar", "amigo", "ancho", "angel", "antes", "arroz", "atlas", "avaro", "avion", "baile",
            "balsa", "banda", "barco", "barro", "bicho", "blusa", "bomba", "borde", "brazo", "breve",
            "bruto", "bucle", "buena", "buque", "burro", "cable", "calle", "campo", "canto", "carga",
            "carta", "casco", "causa", "caida", "censo", "cerdo", "cesta", "chico", "chile", "cielo",
            "cinta", "claro", "cobre", "coche", "colmo", "comer", "coral", "corto", "costa", "cruce",
            "cuero", "danza", "denso", "diosa", "dolor", "donde", "dosis", "ducha", "enano", "enema",
            "epico", "error", "estar", "etapa", "falta", "fango", "farol", "fauna", "favor", "feria",
            "ficha", "final", "firme", "flaco", "fondo", "forma", "frase", "fuego", "fumar", "gafas",
            "gallo", "ganso", "gasto", "genio", "gente", "girar", "globo", "golpe", "gordo", "grado",
            "grano", "grito", "grupo", "guapo", "guiso", "haber", "hacer", "hacha", "hacia", "hasta",
            "hielo", "hogar", "hondo", "hueso", "humor", "ideal", "igual", "ileso", "jalea", "jamon",
            "jaula", "joven", "juego", "junta", "justo", "labio", "lacio", "lamer", "lapiz", "largo",
            "laser", "leche", "lecho", "legal", "lento", "letal", "letra", "lider", "limon", "lince",
            "lista", "llama", "llave", "local", "lucha", "lucir", "lugar", "lunar", "mango", "manos",
            "manta", "manto", "marca", "marco", "marea", "matiz", "mayor", "mejor", "menor", "mente",
            "miedo", "miope", "mirar", "mismo", "mitad", "molar", "monje", "moral", "morir", "mosto",
            "mover", "mucho", "muela", "mujer", "museo", "nacer", "nadie", "naipe", "nariz", "necio",
            "negar", "nieve", "nivel", "noble", "noche", "norte", "novio", "nueva", "nuevo", "nunca",
            "obeso", "obvio", "ocaso", "odiar", "oeste", "oidor", "ojota", "oliva", "opaco", "optar",
            "orden", "oreja", "ostra", "oveja", "oxido", "ozono", "pacto", "padre", "pagar", "palco",
            "palma", "panal", "panda", "panel", "panza", "papel", "parar", "parca", "pared", "parir",
            "paseo", "pasta", "pasto", "patio", "pausa", "pauta", "pavor", "peaje", "pecho", "pedal",
            "peine", "pelar", "penal", "perro", "pesar", "peste", "pilar", "pinta", "piojo", "pisar",
            "pista", "pizca", "placa", "plano", "plata", "plato", "playa", "plaza", "plomo", "pobre",
            "poder", "poema", "poeta", "pollo", "polvo", "poner", "posar", "poste", "potro", "prisa",
            "pudor", "pulga", "pulir", "pulpo", "punto", "queso", "quiza", "rabia", "rango", "rapaz",
            "rapto", "rasgo", "raton", "recto", "rehen", "reino", "reloj", "remar", "salir", "santa",
            "santo", "serio", "sobre", "tanta", "tanto", "tener", "usted", "viene", "zebra"
    };

    public static int numIntentos = 6;
    public static int longPal = 5;
    public static Scanner print = new Scanner(System.in);

    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_RED = "\u001B[31m";

    public static char[][] matrizwordle = new char[numIntentos][longPal];

    public static void main(String[] args) {
        while (true) {
            Random();
            System.out.println("---- Nuevo Juego ----");
        }
    }

    public static void Random() {
        int numRandom = new Random().nextInt(palabras.length);
        String palabra = palabras[numRandom];

        for(int i=0; i<numIntentos; i++){
            for(int j=0; j<longPal; j++){
                matrizwordle[i][j] = ' ';
            }
        }

        System.out.println("¡Adivina la palabra de 5 letras!");

        boolean ganado = false;
        for (int i = 0; i < numIntentos; i++) {
            boolean acierto = Intento(palabra, i);

            Tablero(palabra);

            if (acierto) {
                System.out.println("Has ganado.");
                ganado = true;
                break;
            }
        }

        if (!ganado) {
            System.out.println("Has perdido. La palabra era: " + palabra);
        }
    }

    public static boolean Intento(String palabra, int fila) {
        String intento;

        while(true) {
            System.out.print("Intento " + (fila+1) + ": ");
            intento = print.nextLine().toLowerCase();
            if (intento.length() == palabra.length()) {
                break;
            }
            System.out.println("La palabra tiene que ser de " + palabra.length() + " letras.");
        }

        for (int j = 0; j < palabra.length(); j++) {
            char letraUsuario = intento.charAt(j);

            matrizwordle[fila][j] = letraUsuario;

            if (letraUsuario == palabra.charAt(j)) {
            }
        }

        return intento.equals(palabra);
    }

    public static void Tablero(String palabra) {
        for (int i = 0; i < numIntentos; i++) {
            for (int j = 0; j < palabra.length(); j++) {

                char letra = matrizwordle[i][j];
                String color = "";

                if (letra != ' ') {
                    if (letra == palabra.charAt(j)) {
                        color = ANSI_GREEN;
                    } else if (palabra.indexOf(letra) != -1) {
                        color = ANSI_YELLOW;
                    } else {
                        color = ANSI_RED;
                    }
                }

                System.out.print("[" + color + letra + ANSI_RESET + "]");
            }
            System.out.println();
        }
    }
}