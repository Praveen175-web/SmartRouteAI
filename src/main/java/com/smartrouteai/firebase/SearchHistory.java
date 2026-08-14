package com.smartrouteai.firebase;

public class SearchHistory {

    private String source;
    private String destination;
    private String vehicleType;

    private double distance;
    private double fuelRequired;
    private double fuelCost;
    private double estimatedTime;

    private String trafficLevel;
    private double trafficPercentage;

    private String weather;
    private double temperature;

    private String currentTime;

    public SearchHistory() {
    }

    public String getSource() { return source; }
    public void setSource(String source) { this.source = source; }

    public String getDestination() { return destination; }
    public void setDestination(String destination) { this.destination = destination; }

    public String getVehicleType() { return vehicleType; }
    public void setVehicleType(String vehicleType) { this.vehicleType = vehicleType; }

    public double getDistance() { return distance; }
    public void setDistance(double distance) { this.distance = distance; }

    public double getFuelRequired() { return fuelRequired; }
    public void setFuelRequired(double fuelRequired) { this.fuelRequired = fuelRequired; }

    public double getFuelCost() { return fuelCost; }
    public void setFuelCost(double fuelCost) { this.fuelCost = fuelCost; }

    public double getEstimatedTime() { return estimatedTime; }
    public void setEstimatedTime(double estimatedTime) { this.estimatedTime = estimatedTime; }

    public String getTrafficLevel() { return trafficLevel; }
    public void setTrafficLevel(String trafficLevel) { this.trafficLevel = trafficLevel; }

    public double getTrafficPercentage() { return trafficPercentage; }
    public void setTrafficPercentage(double trafficPercentage) {
        this.trafficPercentage = trafficPercentage;
    }

    public String getWeather() { return weather; }
    public void setWeather(String weather) { this.weather = weather; }

    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }

    public String getCurrentTime() { return currentTime; }
    public void setCurrentTime(String currentTime) { this.currentTime = currentTime; }
}
