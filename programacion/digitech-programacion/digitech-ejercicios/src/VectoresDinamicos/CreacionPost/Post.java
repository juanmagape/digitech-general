package VectoresDinamicos.CreacionPost;

public class Post {
    private String nombrePost;
    private String autor;
    private String foto;

    public Post(String nombrePost, String autor, String foto) {
        this.nombrePost = nombrePost;
        this.autor = autor;
        this.foto = foto;
    }

    @Override
    public String toString() {
        return "{\"nombrePost\":\"" + nombrePost + "\",\"autor\":\"" + autor + "\",\"foto\":\"" + foto + "\"}";
    }
}
