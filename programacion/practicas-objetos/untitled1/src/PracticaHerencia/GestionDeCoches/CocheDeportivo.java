package PracticaHerencia.GestionDeCoches;

public class CocheDeportivo extends Coche{
    private int caballos;
    private int modoCarrera;

    public CocheDeportivo(String marca, String modelo, int precio, int velocidadMax, int caballos, int modoCarrera) {
        super(marca, modelo, precio, velocidadMax);
        this.caballos = caballos;
        this.modoCarrera = modoCarrera;
    }
}
