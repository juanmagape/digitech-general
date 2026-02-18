import java.util.ArrayList;
import java.util.Date;

public class Pedido {
    private Cliente cliente;
    private ArrayList<LineaProducto> lineas;
    private Date fecha;
    private double costeTotal;
    public Pedido(Cliente cliente) {
        this.cliente = cliente;
        this.lineas = new ArrayList<>();
        this.fecha = new Date();
        this.costeTotal = 0.0;
    }

    public void agregarProducto(Producto producto, int cantidad) {
        LineaProducto linea = new LineaProducto(producto, cantidad);
        lineas.add(linea);

        costeTotal = costeTotal + linea.getPrecioTotal();
    }

    public void showPedido() {
        System.out.println("Fecha: " + fecha);
        System.out.println("Cliente: " + cliente.getNombre());

        for (int i = 0; i < lineas.size(); i++) {
            LineaProducto linea = lineas.get(i);
            System.out.println("- " + linea.getProducto().getNombre() +
                    " x" + linea.getCantidad() +
                    " unidades. (Subtotal: " + linea.getPrecioTotal() + ")");
        }
        System.out.println("coste total: " + costeTotal);
    }

    public Cliente getCliente() { return cliente; }
}