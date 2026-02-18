import java.util.ArrayList;

public class Tienda {
    private ArrayList<Producto> productos = new ArrayList<>();
    private ArrayList<Cliente> clientes = new ArrayList<>();
    private ArrayList<Pedido> pedidos = new ArrayList<>();

    public void agregarProducto(Producto p) { productos.add(p); }
    public void agregarCliente(Cliente c) { clientes.add(c); }
    public void agregarPedido(Pedido p) { pedidos.add(p); }

    public void listarProductos() {
        System.out.println("--- PRODUCTOS EN TIENDA ---");
        for (Producto p : productos) {
            System.out.println(p.getNombre() + " - Stock: " + p.getStock() + " - Precio: " + p.getPrecio());
        }
    }

    public void listarClientes() {
        System.out.println("\n--- CLIENTES REGISTRADOS ---");
        for (Cliente c : clientes) {
            System.out.println(c.getNombre() + " (" + c.getEmail() + ")");
        }
    }

    public void listarPedidos() {
        System.out.println("\n--- PEDIDOS REALIZADOS ---");
        for (Pedido p : pedidos) {
            p.showPedido();
            System.out.println("----------------");
        }
    }
}