package PracticaHerencia.GestionDeCoches;

public class CocheElectrico extends Coche {
    private int autonomia;
    private double tiempoCarga;

    public CocheElectrico(String marca, String modelo, int precio, int velocidadMax, int autonomia, double tiempoCarga) {
        super(marca, modelo, precio, velocidadMax);
        this.autonomia = autonomia;
        this.tiempoCarga = tiempoCarga;
    }

    public void mostrarInformacion() {
        super.mostrarInformacion();
        System.out.println("Autonomía: " + autonomia + " km");
        System.out.println("Tiempo de Carga: " + tiempoCarga + " horas");
    }

    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    public double getTiempoCarga() {
        return tiempoCarga;
    }

    public void setTiempoCarga(int tiempoCarga) {
        this.tiempoCarga = tiempoCarga;
    }
}
