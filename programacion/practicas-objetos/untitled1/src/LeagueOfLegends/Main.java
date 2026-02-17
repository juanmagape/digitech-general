package LeagueOfLegends;

class Habilidad {
    public String nombre;
    public String descripcion;
    public int costeRecurso;
    public int enfriamiento;
    public int nivel;
    public String tecla;

    public Habilidad(String nombre, String descripcion, int costeRecurso, int enfriamiento, int nivel, String tecla) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.costeRecurso = costeRecurso;
        this.enfriamiento = enfriamiento;
        this.nivel = nivel;
        this.tecla = tecla;
    }
}

class Campeon {
    public String nombre;
    public String rolPrincipal;
    public String dificultad;
    public String recurso;
    public int vidaMaxima;
    public int danioAtaque;
    public int poderHabilidad;
    public int armadura;
    public int resistenciaMagica;

    public Habilidad pasiva;
    public Habilidad Q;
    public Habilidad W;
    public Habilidad E;
    public Habilidad R;

    public Campeon(String nombre, String rolPrincipal, String dificultad, String recurso,
                   int vidaMaxima, int danioAtaque, int poderHabilidad,
                   int armadura, int resistenciaMagica,
                   Habilidad pasiva, Habilidad Q, Habilidad W, Habilidad E, Habilidad R) {

        this.nombre = nombre;
        this.rolPrincipal = rolPrincipal;
        this.dificultad = dificultad;
        this.recurso = recurso;
        this.vidaMaxima = vidaMaxima;
        this.danioAtaque = danioAtaque;
        this.poderHabilidad = poderHabilidad;
        this.armadura = armadura;
        this.resistenciaMagica = resistenciaMagica;
        this.pasiva = pasiva;
        this.Q = Q;
        this.W = W;
        this.E = E;
        this.R = R;
    }

    public static String mostrarCampeon(Campeon campeon) {
        return "Nombre: " + campeon.nombre + "\n" +
                "Rol: " + campeon.rolPrincipal + "\n" +
                "Dificultad: " + campeon.dificultad + "\n" +
                "Recurso: " + campeon.recurso + "\n" +
                "Vida Máxima: " + campeon.vidaMaxima + "\n" +
                "Daño de Ataque: " + campeon.danioAtaque + "\n" +
                "Poder de Habilidad: " + campeon.poderHabilidad + "\n" +
                "Armadura: " + campeon.armadura + "\n" +
                "Resistencia Mágica: " + campeon.resistenciaMagica + "\n\n" +

                "=== HABILIDADES ===\n" +
                "Pasiva: " + campeon.pasiva.nombre + " (" + campeon.pasiva.tecla + ")\n" +
                "Q: " + campeon.Q.nombre + " (" + campeon.Q.tecla + ")\n" +
                "W: " + campeon.W.nombre + " (" + campeon.W.tecla + ")\n" +
                "E: " + campeon.E.nombre + " (" + campeon.E.tecla + ")\n" +
                "R: " + campeon.R.nombre + " (" + campeon.R.tecla + ")";
    }
}

public class Main {

    public static void main(String[] args) {

        Habilidad pasiva = new Habilidad("Pasiva Arcana", "Aumenta daño mágico", 0, 0, 1, "Pasiva");
        Habilidad Q = new Habilidad("Bola de Fuego", "Lanza una bola de fuego", 50, 5, 3, "Q");
        Habilidad W = new Habilidad("Escudo Mágico", "Otorga escudo", 40, 8, 2, "W");
        Habilidad E = new Habilidad("Teletransporte", "Se mueve rápidamente", 60, 12, 2, "E");
        Habilidad R = new Habilidad("Explosión Final", "Gran daño en área", 100, 60, 1, "R");

        Campeon campeon1 = new Campeon(
                "Ahri",
                "Mago",
                "Media",
                "Maná",
                600,
                50,
                80,
                20,
                30,
                pasiva, Q, W, E, R
        );

        System.out.println(Campeon.mostrarCampeon(campeon1));
    }
}
