package AppMusica;

class Usuario {
    public String nombre;
    public String email;
    public String tipoCuenta;
    public int fechaRegistro;
    public String[] listaReproduccion;

    public Usuario(String nombre, String email, String tipoCuenta, int fechaRegistro, String[] listaReproduccion) {
    }
}

class Canciones extends Usuario {
    public String titulo;
    public String artista;
    public String album;
    public String genero;
    public int duracion;
    public int numReproducciones;

    public Canciones(String nombre, String email, String tipoCuenta, int fechaRegistro, String[] listaReproduccion, String titulo, String artista, String album, String genero, int duracion, int numReproducciones) {
        super(nombre, email, tipoCuenta, fechaRegistro, listaReproduccion);
        this.nombre = nombre;
        this.email = email;
        this.tipoCuenta = tipoCuenta;
        this.fechaRegistro = fechaRegistro;
        this.listaReproduccion = listaReproduccion;
        this.titulo = titulo;
        this.artista = artista;
        this.album = album;
        this.genero = genero;
        this.duracion = duracion;
        this.numReproducciones = numReproducciones;
    }
}

public class Main {
    static void main(String[] args) {
            Usuario usuario1 = new Usuario("Carlos", "carlitos@gmail.com", "Premium", 20200101, new String[]{"Canción A", "Canción B"});
            Canciones cancion1 = new Canciones("Carlos2", "carlitos2@gmail.com", "Premium", 20200101, new String[]{"Canción A", "Canción B"}, "Canción A", "Artista A", "Álbum A", "Pop", 210, 1000);

            System.out.println("Usuario: " + usuario1.nombre + ", Email: " + usuario1.email + ", Tipo de Cuenta: " + usuario1.tipoCuenta);
            System.out.println("Canción: " + cancion1.titulo + ", Artista: " + cancion1.artista + ", Álbum: " + cancion1.album + ", Género: " + cancion1.genero + ", Duración: " + cancion1.duracion + " segundos, Reproducciones: " + cancion1.numReproducciones);

    }
}
