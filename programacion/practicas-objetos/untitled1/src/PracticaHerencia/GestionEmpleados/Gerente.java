package PracticaHerencia.GestionEmpleados;

public class Gerente extends Empleado {
    private int bonus;
    private int empleadosACargo;

    public Gerente(String nombre, String apellido, int salarioBase, String departamento, int bonus, int empleadosACargo) {
        super(nombre, apellido, salarioBase, departamento);
        this.bonus = bonus;
        this.empleadosACargo = empleadosACargo;
    }

    public int getBonus() {
        return bonus;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

    public int getEmpleadosACargo() {
        return empleadosACargo;
    }

    public void setEmpleadosACargo(int empleadosACargo) {
        this.empleadosACargo = empleadosACargo;
    }

    public void mostrarGerente() {
        System.out.println("Nombre: " + super.getNombre());
        System.out.println("Apellido: " + super.getApellido());
        System.out.println("Salario Base: " + super.getSalarioBase());
        System.out.println("Departamento: " + super.getDepartamento());
        System.out.println("Bonus: " + this.getBonus());
        System.out.println("Empleados a cargo: " + this.getEmpleadosACargo());
        System.out.println("Salario total: " + (super.getSalarioBase() + this.getBonus()));
    }
}
