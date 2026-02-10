package Magic;

class Carta {
    public String nombre;
    public int costeMana;
    public String imagen;
    public String tipo;
    public String habilidad;
    public String rareza;
    public String expansion;
    public String artista;
    public String Fuerza;
    public String subtipo;

    public Carta(String nombre, int costeMana, String imagen, String tipo, String habilidad, String rareza, String expansion, String artista, String fuerza, String subtipo) {
        this.nombre = nombre;
        this.costeMana = costeMana;
        this.imagen = imagen;
        this.tipo = tipo;
        this.habilidad = habilidad;
        this.rareza = rareza;
        this.expansion = expansion;
        this.artista = artista;
        this.Fuerza = fuerza;
        this.subtipo = subtipo;
    }

    public static String mostrarCarta(Carta carta) {
        return "Nombre: " + carta.nombre + "\n" +
               "Coste de Mana: " + carta.costeMana + "\n" +
               "Tipo: " + carta.tipo + "\n" +
               "Habilidad: " + carta.habilidad + "\n" +
               "Rareza: " + carta.rareza + "\n" +
               "Expansión: " + carta.expansion + "\n" +
               "Artista: " + carta.artista + "\n" +
               "Fuerza/Resistencia: " + carta.Fuerza + "\n" +
               "Subtipo: " + carta.subtipo;
    }
}

public class Main {
    public static void main(String[] args) {
        Carta carta1 = new Carta("Giant Growth", 1, "https://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=12345&type=card", "Instantáneo", "Hasta el final del turno, una criatura objetivo obtiene +3/+3.", "Común", "Core Set 2020", "John Doe", "", "");
        Carta carta2 = new Carta("Serra Angel", 5, "https://gatherer.wizards.com/Handlers/Image.ashx?multiverseid=67890&type=card", "Criatura - Ángel", "Vuela. No puede atacar ni bloquear a menos que pagues {W}.", "Rara", "Core Set 2020", "Jane Smith", "4/4", "Ángel");

        System.out.println(Carta.mostrarCarta(carta1));
        System.out.println("<--------------------------------------------->");
        System.out.println(Carta.mostrarCarta(carta2));

    }
}
