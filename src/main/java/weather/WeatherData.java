package com.smartrouteai.weather;

public class WeatherData {

    private double temperature;
    private double windSpeed;
    private int weatherCode;
    private String description;
    private double humidity;

    // ==========================================
    // Default Constructor
    // ==========================================

    public WeatherData() {
    }

    // ==========================================
    // Constructor
    // ==========================================

    public WeatherData(
            double temperature,
            double windSpeed,
            int weatherCode,
            String description) {

        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.weatherCode = weatherCode;
        this.description = description;
        this.humidity = 0.0;
    }

    // ==========================================
    // Temperature
    // ==========================================

    public double getTemperature() {
        return temperature;
    }

    public void setTemperature(double temperature) {
        this.temperature = temperature;
    }

    // ==========================================
    // Wind Speed
    // ==========================================

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    // ==========================================
    // Weather Code
    // ==========================================

    public int getWeatherCode() {
        return weatherCode;
    }

    public void setWeatherCode(int weatherCode) {
        this.weatherCode = weatherCode;
    }

    // ==========================================
    // Description
    // ==========================================

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    // ==========================================
    // Humidity
    // ==========================================

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    // ==========================================
    // ToString
    // ==========================================

    @Override
    public String toString() {

        return "WeatherData{" +
                "temperature=" + temperature +
                ", windSpeed=" + windSpeed +
                ", weatherCode=" + weatherCode +
                ", description='" + description + '\'' +
                ", humidity=" + humidity +
                '}';
    }
}