public class Main {
    public static void main(String[] args) {
        Tienda miTienda = new Tienda();

        Cliente c1 = new Cliente("Dershi", "dershi@email.com", "Dershi dersh 123");
        Producto p1 = new Producto("Play 5", 12000.50, 10);
        Producto p2 = new Producto("Mouse", 250.00, 50);

        miTienda.agregarCliente(c1);
        miTienda.agregarProducto(p1);
        miTienda.agregarProducto(p2);

        Pedido pedido1 = new Pedido(c1);
        pedido1.agregarProducto(p1, 1);
        pedido1.agregarProducto(p2, 2);

        miTienda.agregarPedido(pedido1);

        miTienda.listarProductos();
        miTienda.listarClientes();
        miTienda.listarPedidos();
    }
}