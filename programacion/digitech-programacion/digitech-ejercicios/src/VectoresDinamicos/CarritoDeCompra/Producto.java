package VectoresDinamicos.CarritoDeCompra;

public class Producto {
    private String nombreProducto;
    private double precio;
    private int cantidad;

    public void Productos(String nombreProducto, double precio, int cantidad) {
        this.nombreProducto = nombreProducto;
        this.precio = precio;
        this.cantidad = cantidad;
    }

    public String getNombreProducto() {
        return nombreProducto;
    }

    public double getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    @Override
    public String toString() {
        return "Producto: " + nombreProducto + ", Precio: $" + precio + ", Cantidad: " + cantidad;
    }
}
