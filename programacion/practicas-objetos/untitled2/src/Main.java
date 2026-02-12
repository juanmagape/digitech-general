public class Main {
    public static void main(String[] args) {
        Cliente cliente1 = new Cliente("Dershi", "dershi@seaserio.com", "Calle Dershi Dersh");

        Producto p1 = new Producto("Play", 12000.50, 10);
        Producto p2 = new Producto("Mouse", 250.99, 50);
        Producto p3 = new Producto("Teclado", 450.45, 30);

        Pedido pedido1 = new Pedido(cliente1);

        pedido1.agregarProducto(p1);
        pedido1.agregarProducto(p2);
        pedido1.agregarProducto(p3);

        System.out.println("Productos comprados:");

        pedido1.showPedido();
    }
}