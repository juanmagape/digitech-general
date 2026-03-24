package VectoresDinamicos.JSONaHashMap;

import java.security.spec.RSAOtherPrimeInfo;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
    static void main(String[] args) {
        Scanner print = new Scanner(System.in);
        HashMap<String , String> datosPokemon = new HashMap<>();

        System.out.println("================================");
        System.out.println("POKEAPI");
        System.out.println("================================");

        System.out.println("\n\n================================");
        System.out.println("Introduce el ID o el nombre del pokemon");
        String pokemon = print.nextLine();
        System.out.println("================================");

        String respuestaApi = Api.obtenerJSONApi(pokemon);

        String habilidad = extraerDatos(respuestaApi, "abilities", "name");
        String forma = extraerDatos(respuestaApi, "forms", "name");
        String ataque = extraerDatos(respuestaApi, "moves", "name");
        String peso = extraerNumero(respuestaApi, "weight");

        datosPokemon.put("Habilidad", habilidad);
        datosPokemon.put("Forma", forma);
        datosPokemon.put("Primer Ataque", ataque);
        datosPokemon.put("Peso", peso);

        System.out.println("Habilidad Principal: " + datosPokemon.get("Habilidad"));
        System.out.println("Forma: " + datosPokemon.get("Forma"));
        System.out.println("Primer Ataque: " + datosPokemon.get("Primer Ataque"));
        System.out.println("Peso: " + datosPokemon.get("Peso"));

    }

    public static String extraerDatos(String json, String seccion, String clave) {
        try {
            int indiceSeccion = json.indexOf("\"" + seccion + "\"");
            if (indiceSeccion == -1) return "No encontrado";

            int indiceClave = json.indexOf("\"" + clave + "\"", indiceSeccion);
            int inicioValor = json.indexOf("\"", indiceClave + clave.length() + 3) + 1;
            int finValor = json.indexOf("\"", inicioValor);

            return json.substring(inicioValor, finValor);
        } catch (Exception e) {
            return "Error al buscar";
        }
    }

    private static String extraerNumero(String json, String clave) {
        try {
            int indiceClave = json.indexOf("\"" + clave + "\":");
            if (indiceClave == -1) return "No encontrado";

            int inicioValor = indiceClave + clave.length() + 3;
            int finValor = json.indexOf(",", inicioValor);

            return json.substring(inicioValor, finValor);
        } catch (Exception e) {
            return "Error al buscar";
        }
    }

    private static String extraerDañoAtaque(String json) {
        try {
            int indiceAtaque = json.indexOf("\"name\":\"attack\"");
            if (indiceAtaque == -1) return "No encontrado";

            int indiceBaseStat = json.lastIndexOf("\"base_stat\":", indiceAtaque);
            int inicioValor = indiceBaseStat + 12;
            int finValor = json.indexOf(",", inicioValor);

            return json.substring(inicioValor, finValor);
        } catch (Exception e) {
            return "Error al buscar";
        }
    }
}
