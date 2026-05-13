package org.example.aplicaciondeltiempo;

public class Tiempo {
    private double temperatura;
    private int humedad;
    private double viento;
    private int weatherCode;

    public Tiempo(double temperatura, int humedad, double viento, int weatherCode) {
        this.temperatura = temperatura;
        this.humedad = humedad;
        this.viento = viento;
        this.weatherCode = weatherCode;
    }

    public double getTemperatura() { return temperatura; }
    public int getHumedad() { return humedad; }
    public double getViento() { return viento; }
    public int getWeatherCode() { return weatherCode; }
}