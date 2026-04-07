package VectoresDinamicos.MiniRedSocial;


import java.util.ArrayList;

public class Usuario {
    private String correo;
    private String contrasena;
    private ArrayList<String> publicaciones;

    public Usuario(String correo, String contrasena) {
        this.correo = correo;
        this.contrasena = contrasena;
        this.publicaciones = new ArrayList<>();
    }

    public String getCorreo() {
        return correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public ArrayList<String> getPublicaciones() {
        return publicaciones;
    }

    public void agregarPublicacion(String publicacion) {
        publicaciones.add(publicacion);
    }
}