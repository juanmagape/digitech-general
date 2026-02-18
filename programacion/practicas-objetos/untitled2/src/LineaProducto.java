public class LineaProducto {
    private Producto producto;
    private int cantidad;
    private double precioTotal;

    public LineaProducto(Producto producto, int cantidad) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.precioTotal = producto.getPrecio() * cantidad;
    }

    public Producto getProducto() { return producto; }
    public int getCantidad() { return cantidad; }
    public double getPrecioTotal() { return precioTotal; }
}