package Tienda;

import Personajes.Personaje;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class EnemigoIA {
    private ArrayList<Personaje> inventario; // Máximo 10 personajes
    private ArrayList<Personaje> equipoCombate; // Los 5 que salen a pelear
    private Random random;
    private final int MAX_INV = 10;

    public EnemigoIA() {
        this.inventario = new ArrayList<>();
        this.equipoCombate = new ArrayList<>();
        this.random = new Random();
    }


    public void comprarDeTienda(Tienda tienda) {
        tienda.hacerRoll(); //Llamamos al metodo para obtener personajes que hicieron Juanma y Lex

        // Obtenemos la lista actual de la tienda
        List<Personaje> slotsDisponibles = tienda.getSlotsPersonajes(); //

        int limiteCompra = Math.min(3, slotsDisponibles.size());

        for (int i = 0; i < limiteCompra; i++) {
            if (inventario.size() < MAX_INV) {
                // Cogemos el personaje del slot correspondiente (0, 1 o 2) NO ESCOGEMOS AL AZAR SINO LOS TRES PRIMEROS
                Personaje p = slotsDisponibles.get(i);
                if (p != null) {
                    inventario.add(p);
                }
            }
        }

    }

    //Elige los personajes que tenemos en inventario (Si tenemos 10 escogera 5) al comenzar con 3 no hay problema.
    public void seleccionarEquipoCombate() {
        equipoCombate.clear();
        ArrayList<Personaje> copia = new ArrayList<>(this.inventario);

        int aElegir = Math.min(5, copia.size());

        for (int i = 0; i < aElegir; i++) {
            int indice = random.nextInt(copia.size());
            equipoCombate.add(copia.remove(indice)); // Selección manual
        }
        System.out.println("El enemigo sale con " + equipoCombate.size() + " personajes.");
    }

    public ArrayList<Personaje> getEquipoCombate() {
        return equipoCombate;
    }
}