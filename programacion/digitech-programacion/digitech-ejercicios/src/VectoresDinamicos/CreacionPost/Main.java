package VectoresDinamicos.CreacionPost;

import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        HashMap<String, String> post = new HashMap<>();

        System.out.println("================================");
        System.out.println("JSON a HashMap");
        System.out.println("================================");

        System.out.println("\n\n================================");
        System.out.println("Datos del servidor");
        System.out.println("================================");
        System.out.println("IP del servidor:");
        String ip = print.nextLine();
        System.out.println("Puerto del servidor:");
        String puerto = print.nextLine();
        System.out.println("================================");

        System.out.println("\n\n\n================================");
        System.out.println("Datos a enviar");
        System.out.println("================================");
        System.out.println("Nombre del post:");
        post.put("nombrePost", print.nextLine());
        System.out.println("Autor del post:");
        post.put("autor", print.nextLine());
        System.out.println("Foto para el post:");
        post.put("foto", print.nextLine());
        System.out.println("================================");

        String post1 = String.valueOf(new Post(post.get("nombrePost"), post.get("autor"), post.get("foto")));

        String json = post1;


        try {
            String urlCompleta = "http://" + ip + ":" + puerto + "/api/posts";

            URL url = new URL(urlCompleta);

            HttpURLConnection conn = (HttpURLConnection) url.openConnection();

            conn.setRequestMethod("POST");
            conn.setRequestProperty("Content-Type", "application/json");
            conn.setDoOutput(true);

            try (OutputStream os = conn.getOutputStream()) {
                os.write(json.getBytes());
                os.flush();
            }

            int respuesta = conn.getResponseCode();
            if (respuesta == 200) {
                System.out.println("Enviado");
            } else {
                System.out.println("Error " + respuesta);
            }
            conn.disconnect();
        } catch (Exception e) {

            System.out.println(" Error al conectar: " + e.getMessage());

        }

    }
}
