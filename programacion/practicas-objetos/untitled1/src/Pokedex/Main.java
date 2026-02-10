package Pokedex;

class Pokedex {
    public String nombre;
    public String tipo;
    public String generacion;
    public boolean capturado;
    public int id;
    public String evolucion;
    public String involucion;

    public Pokedex(String nombre, String tipo, String generacion, boolean capturado, int id, String evolucion, String involucion) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.generacion = generacion;
        this.capturado = capturado;
        this.id = id;
        this.evolucion = evolucion;
        this.involucion = involucion;
    }

    public static String evolucionar(Pokedex pokemon) {
        return pokemon.nombre + " ha evolucionado a " + pokemon.evolucion;
    }

    public static String involucionar(Pokedex pokemon) {
        return pokemon.nombre + " ha involucionado a " + pokemon.involucion;
    }
}

public class Main {

    public static void main(String[] args) {

        Pokedex pokemon1 = new Pokedex("Ivysaur", "Planta/Veneno", "Primera", true, 1, "Venusaur", "Bulbasaur");

        System.out.println("Nombre: " + pokemon1.nombre);
        System.out.println("Tipo: " + pokemon1.tipo);
        System.out.println("Generación: " + pokemon1.generacion);
        System.out.println("Capturado: " + pokemon1.capturado);
        System.out.println("ID: " + pokemon1.id);
        System.out.println("Evolución: " + Pokedex.evolucionar(pokemon1));
        System.out.println("Involución: " + Pokedex.involucionar(pokemon1));


    }
}