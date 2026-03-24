package VectoresDinamicos.JSONaHashMap;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;

public class Api {
    public static String obtenerJSONApi(String pokemon) {

        try {
            URL url = new URL("https://pokeapi.co/api/v2/pokemon/" + pokemon);
            BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));

            String respuesta = br.readLine();
            br.close();

            return respuesta;

        } catch (Exception e) {
            System.out.println("error obteniendo pal");
        }
        return null;
    }
}
