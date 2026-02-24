package PracticaHerencia.GestionEmpleados;

public class Main {
    static void main(String[] args) {

        Programador programador = new Programador("Dersh", "Dershi", 3000, "Programador", "C++", 10);
        programador.mostrarProgramador();

        Gerente gerente = new Gerente("Pepe", "Domingo", 3000, "Informatica", 200, 10);
        gerente.mostrarGerente();
    }
}
