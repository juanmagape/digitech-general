package PracticaHerencia.GestionEmpleados;

public class Programador extends Empleado {
    private String lenguajePrincipal;
    private double horasExtra;

    public Programador(String nombre, String apellido, int salarioBase, String departamento, String lenguajePrincipal, int horasExtra) {
        super(nombre, apellido, salarioBase, departamento);
        this.lenguajePrincipal = lenguajePrincipal;
        this.horasExtra = horasExtra;
    }

    public String getLenguajePrincipal() {
        return lenguajePrincipal;
    }

    public void setLenguajePrincipal(String lenguajePrincipal) {
        this.lenguajePrincipal = lenguajePrincipal;
    }

    public double getHorasExtra() {
        return horasExtra;
    }

    public void setHorasExtra(double horasExtra) {
        this.horasExtra = horasExtra;
    }

    public void mostrarProgramador() {
        System.out.println("Nombre: " + super.getNombre());
        System.out.println("Apellido: " + super.getApellido());
        System.out.println("Salario Base: " + super.getSalarioBase());
        System.out.println("Departamento: " + super.getDepartamento());
        System.out.println("Lenguaje principal: " + this.getLenguajePrincipal());
        System.out.println("Horas extra: " + this.horasExtra);
        System.out.println("Salario total: " + (super.getSalarioBase() + (this.horasExtra * 8)));
    }


}
