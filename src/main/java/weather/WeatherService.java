package com.smartrouteai.weather;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClient;

import java.util.Map;

@Service
public class WeatherService {

    private final RestClient restClient;

    // ==========================================
    // Constructor
    // ==========================================

    public WeatherService() {

        restClient = RestClient.builder()
                .baseUrl("https://api.open-meteo.com")
                .build();
    }

    // ==========================================
    // Get Weather
    // ==========================================

    public WeatherData getWeather(
            double latitude,
            double longitude) {

        try {

            System.out.println(
                    "Requesting weather for: "
                            + latitude
                            + ", "
                            + longitude
            );

            Map response = restClient.get()
                    .uri(uriBuilder -> uriBuilder
                            .path("/v1/forecast")
                            .queryParam("latitude", latitude)
                            .queryParam("longitude", longitude)
                            .queryParam(
                                    "current",
                                    "temperature_2m,"
                                            + "relative_humidity_2m,"
                                            + "wind_speed_10m,"
                                            + "weather_code"
                            )
                            .build())
                    .retrieve()
                    .body(Map.class);

            // ==========================================
            // Check response
            // ==========================================

            if (response == null) {

                System.out.println(
                        "Weather API returned null response."
                );

                return null;
            }

            // ==========================================
            // Get current weather
            // ==========================================

            Map current =
                    (Map) response.get("current");

            if (current == null) {

                System.out.println(
                        "Weather API returned no current data."
                );

                return null;
            }

            // ==========================================
            // Temperature
            // ==========================================

            Object temperatureObject =
                    current.get("temperature_2m");

            if (temperatureObject == null) {

                System.out.println(
                        "Temperature data not found."
                );

                return null;
            }

            double temperature =
                    ((Number) temperatureObject)
                            .doubleValue();

            // ==========================================
            // Humidity
            // ==========================================

            Object humidityObject =
                    current.get("relative_humidity_2m");

            double humidity = 0.0;

            if (humidityObject != null) {

                humidity =
                        ((Number) humidityObject)
                                .doubleValue();
            }

            // ==========================================
            // Wind Speed
            // ==========================================

            Object windSpeedObject =
                    current.get("wind_speed_10m");

            double windSpeed = 0.0;

            if (windSpeedObject != null) {

                windSpeed =
                        ((Number) windSpeedObject)
                                .doubleValue();
            }

            // ==========================================
            // Weather Code
            // ==========================================

            Object weatherCodeObject =
                    current.get("weather_code");

            int weatherCode = 0;

            if (weatherCodeObject != null) {

                weatherCode =
                        ((Number) weatherCodeObject)
                                .intValue();
            }

            // ==========================================
            // Weather Description
            // ==========================================

            String description =
                    getWeatherDescription(
                            weatherCode
                    );

            // ==========================================
            // Create WeatherData
            // ==========================================

            WeatherData weatherData =
                    new WeatherData(
                            temperature,
                            windSpeed,
                            weatherCode,
                            description
                    );

            // Add humidity
            weatherData.setHumidity(
                    humidity
            );

            // ==========================================
            // Terminal Output
            // ==========================================

            System.out.println(
                    "Weather received:"
            );

            System.out.println(
                    "Temperature: "
                            + temperature
                            + " °C"
            );

            System.out.println(
                    "Humidity: "
                            + humidity
                            + " %"
            );

            System.out.println(
                    "Wind Speed: "
                            + windSpeed
                            + " km/h"
            );

            System.out.println(
                    "Weather Code: "
                            + weatherCode
            );

            System.out.println(
                    "Description: "
                            + description
            );

            return weatherData;

        } catch (Exception e) {

            System.out.println(
                    "Weather API error: "
                            + e.getMessage()
            );

            return null;
        }
    }

    // ==========================================
    // Weather Description
    // ==========================================

    private String getWeatherDescription(
            int code) {

        // Clear sky
        if (code == 0) {

            return "Clear sky";
        }

        // Mainly clear / partly cloudy / overcast
        if (code == 1 ||
                code == 2 ||
                code == 3) {

            return "Partly cloudy";
        }

        // Fog
        if (code == 45 ||
                code == 48) {

            return "Fog";
        }

        // Drizzle / rain
        if (code >= 51 &&
                code <= 67) {

            return "Rain";
        }

        // Snow
        if (code >= 71 &&
                code <= 77) {

            return "Snow";
        }

        // Rain showers
        if (code >= 80 &&
                code <= 82) {

            return "Rain showers";
        }

        // Thunderstorm
        if (code >= 95) {

            return "Thunderstorm";
        }

        return "Unknown";
    }
}