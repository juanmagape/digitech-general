package org.example.aplicaciondeltiempo;

import org.json.JSONObject;
import java.net.URI;
import java.net.http.*;
import java.util.Scanner;

public class ApiTiempo {
    public Tiempo servicioApi(String ciudad) throws Exception {

        String geoUrl = "https://geocoding-api.open-meteo.com/v1/search?name="
                + ciudad.replace(" ", "%20") + "&count=1&language=es&format=json";

        HttpClient client = HttpClient.newHttpClient();
        HttpRequest geoRequest = HttpRequest.newBuilder().uri(URI.create(geoUrl)).build();
        HttpResponse<String> geoResponse = client.send(geoRequest, HttpResponse.BodyHandlers.ofString());

        String geoJson = geoResponse.body();
        int latIdx = geoJson.indexOf("\"latitude\":") + 11;
        int lonIdx = geoJson.indexOf("\"longitude\":") + 12;
        String lat = geoJson.substring(latIdx, geoJson.indexOf(",", latIdx));
        String lon = geoJson.substring(lonIdx, geoJson.indexOf(",", lonIdx));

        String url = "https://api.open-meteo.com/v1/forecast?latitude=" + lat
                + "&longitude=" + lon
                + "&current=temperature_2m,relative_humidity_2m,wind_speed_10m,weather_code"
                + "&timezone=auto";

        HttpRequest request = HttpRequest.newBuilder().uri(URI.create(url)).build();
        HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

        String json = response.body();

        JSONObject respuestaJSON = new JSONObject(json);
        JSONObject current = respuestaJSON.getJSONObject("current");

        return new Tiempo (
                current.getDouble("temperature_2m"),
                current.getInt("relative_humidity_2m"),
                current.getDouble("wind_speed_10m"),
                current.getInt("weather_code")
        );
    }
}