package PracticaHerencia.GestionDeCoches;

public class CocheElectrico extends Coche {
    private int autonomia;
    private int tiempoCarga;

    public CocheElectrico(String marca, String modelo, int precio, int velocidadMax, int autonomia, int tiempoCarga) {
        super(marca, modelo, precio, velocidadMax);
        this.autonomia = autonomia;
        this.tiempoCarga = tiempoCarga;
    }

    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    public int getTiempoCarga() {
        return tiempoCarga;
    }

    public void setTiempoCarga(int tiempoCarga) {
        this.tiempoCarga = tiempoCarga;
    }
}
