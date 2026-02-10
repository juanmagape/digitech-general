package AppMedica;

class Paciente {
    public String nombre;
    public String apellidos;
    public int fechaNacimiento;
    public int dni;
    public String sexo;
    public String altura;
    public String peso;
    public String alergias;
    public String medicamientosRecetados;
    public String enfermedadesCronicas;
    public String operaciones;

    public Paciente(String nombre, String apellidos, int fechaNacimiento, int dni, String sexo, String altura, String peso, String alergias, String medicamientosRecetados, String enfermedadesCronicas, String operaciones) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento;
        this.dni = dni;
        this.sexo = sexo;
        this.altura = altura;
        this.peso = peso;
        this.alergias = alergias;
        this.medicamientosRecetados = medicamientosRecetados;
        this.enfermedadesCronicas = enfermedadesCronicas;
        this.operaciones = operaciones;
    }



    public static String mostrarPaciente(Paciente paciente) {
        return "Nombre: " + paciente.nombre + "\n" +
               "Apellidos: " + paciente.apellidos + "\n" +
               "Fecha de Nacimiento: " + paciente.fechaNacimiento + "\n" +
               "DNI: " + paciente.dni + "\n" +
               "Sexo: " + paciente.sexo + "\n" +
               "Altura: " + paciente.altura + "\n" +
               "Peso: " + paciente.peso + "\n" +
               "Alergias: " + paciente.alergias + "\n" +
               "Medicamentos Recetados: " + paciente.medicamientosRecetados + "\n" +
               "Enfermedades Crónicas: " + paciente.enfermedadesCronicas + "\n" +
               "Operaciones: " + paciente.operaciones;
    }

    public static float calcularIMC(Paciente paciente) {
        String alturaStr = paciente.altura.replace("m", "");
        String pesoStr = paciente.peso.replace("kg", "");
        float altura = Float.parseFloat(alturaStr);
        float peso = Float.parseFloat(pesoStr);
        return peso / (altura * altura);
    }
}

public class Main {
    public static void main(String[] args) {
        Paciente paciente1 = new Paciente("Juan", "Pérez", 1990, 12345678, "Masculino", "1.75m", "70kg", "Ninguna", "Ibuprofeno", "Ninguna", "Apendicectomía");
        Paciente paciente2 = new Paciente("María", "Gómez", 1985, 87654321, "Femenino", "1.65m", "60kg", "Penicilina", "Paracetamol", "Asma", "Ninguna");

        System.out.println(Paciente.mostrarPaciente(paciente1));
        System.out.println("<--------------------------------------------->");
        System.out.println(Paciente.mostrarPaciente(paciente2));

        System.out.println("<--------------------------------------------->");
        System.out.println("IMC de Juan Pérez: " + Paciente.calcularIMC(paciente1));
        System.out.println("IMC de María Gómez: " + Paciente.calcularIMC(paciente2));
    }
}
