import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    private Cliente cliente;
    private ArrayList<Producto> productos;
    private Date fecha;

    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.productos = new ArrayList<>();
        this.fecha = new Date();
    }

    public void agregarProducto(Producto producto) {
        this.productos.add(producto);
    }

    public Cliente getCliente() { return cliente; }
    public ArrayList<Producto> getProductos() { return productos; }
    public Date getFecha() { return fecha; }

    public void showPedido() {

        for (int i = 0; i < productos.size(); i++) {
            System.out.println((i + 1) + " - " + productos.get(i).getNombre() + ": $" + productos.get(i).getPrecio());
        }
    }
}