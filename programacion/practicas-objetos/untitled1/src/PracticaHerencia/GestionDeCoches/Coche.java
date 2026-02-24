package PracticaHerencia.GestionDeCoches;

public class Coche {
    private String marca;
    private String modelo;
    private int precio;
    private int velocidadMax;

    public Coche(String marca, String modelo, int precio, int velocidadMax) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.velocidadMax = velocidadMax;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getPrecio() {
        return precio;
    }

    public void setPrecio(int precio) {
        this.precio = precio;
    }

    public int getVelocidadMax() {
        return velocidadMax;
    }

    public void setVelocidadMax(int velocidadMax) {
        this.velocidadMax = velocidadMax;
    }
}
