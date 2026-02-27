package PracticaHerencia.GestionDeCoches;

public class CocheDeportivo extends Coche{
    private int caballos;
    private boolean modoCarrera;

    public CocheDeportivo(String marca, String modelo, int precio, int velocidadMax, int caballos, boolean modoCarrera) {
        super(marca, modelo, precio, velocidadMax);
        this.caballos = caballos;
        this.modoCarrera = modoCarrera;
    }

    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Caballos de fuerza: " + caballos + " CV");
        System.out.println("Modo Carrera: " + (modoCarrera ? "Activado" : "Desactivado"));
    }
}
