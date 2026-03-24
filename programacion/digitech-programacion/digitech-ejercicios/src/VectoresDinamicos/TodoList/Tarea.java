package VectoresDinamicos.TodoList;

public class Tarea {
    private String nombreTarea;
    private String autor;
    private String descripcion;
    private int duracionAprox;
    private String estado;

    public Tarea(String nombreTarea, String autor, String descripcion, int duracionAprox, String estado) {
        this.nombreTarea = nombreTarea;
        this.autor = autor;
        this.descripcion = descripcion;
        this.duracionAprox = duracionAprox;
        this.estado = estado;
    }

    public String getNombreTarea() {
        return nombreTarea;
    }

    public String getEstado() {
        return estado;
    }

    @Override
    public String toString() {
        return "\n========================================" +
                "\n TAREA: " + nombreTarea.toUpperCase() +
                "\n========================================" +
                "\n Autor:       " + autor +
                "\n Descripción: " + descripcion +
                "\n Duración:    " + duracionAprox + " h" +
                "\n Estado:      " + estado +
                "\n========================================";
    }
}
