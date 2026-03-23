public class Jugador2 extends Personaje {
    private int cantManaJug2;
    private int danoCuerpoaCuerpoJug2;
    private int danoMagiaJug2;
    private int vidaJug2;

    public Jugador2(String nombre, int skillPoints, int cantManaJug2, int danoCuerpoaCuerpoJug2, int danoMagiaJug2, int vidaJug2) {
        super(nombre, skillPoints);
        this.cantManaJug2 = cantManaJug2;
        this.danoCuerpoaCuerpoJug2 = danoCuerpoaCuerpoJug2;
        this.danoMagiaJug2 = danoMagiaJug2;
        this.vidaJug2 = vidaJug2;
    }

    public void mostrarEstadisticasJug2() {
        System.out.println("Nombre:");
    }
}
