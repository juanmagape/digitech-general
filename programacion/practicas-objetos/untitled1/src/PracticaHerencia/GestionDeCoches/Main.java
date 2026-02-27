package PracticaHerencia.GestionDeCoches;

public class Main {
    static void main(String[] args) {
        CocheElectrico tesla = new CocheElectrico("Tesla", "Model S", 85000, 250, 600, 4.5);
        CocheDeportivo ferrari = new CocheDeportivo("Ferrari", "F8 Tributo", 250000, 340, 710, true);

        tesla.mostrarInformacion();

        ferrari.mostrarInformacion();
    }
}
