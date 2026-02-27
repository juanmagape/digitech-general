package PracticaHerencia.GestionDeCoches;

public class Coche {
    private String marca;
    private String modelo;
    private int precio;
    private int velocidadMax;
    private Rueda[] ruedas;

    public Coche(String marca, String modelo, int precio, int velocidadMax) {
        this.marca = marca;
        this.modelo = modelo;
        this.precio = precio;
        this.velocidadMax = velocidadMax;

        this.ruedas = new Rueda[4];
        for (int i = 0; i < 4; i++) {
            this.ruedas[i] = new Rueda(0.0, "Nuevo");
        }
    }

    public void mostrarInformacion() {
        System.out.println("Marca: " + marca);
        System.out.println("Modelo: " + modelo);
        System.out.println("Precio: " + precio + "€");
        System.out.println("Velocidad Máxima: " + velocidadMax + " km/h");
        System.out.println("Estado de las ruedas:");
        for (int i = 0; i < ruedas.length; i++) {
            ruedas[i].mostrarInformacion();
        }
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
