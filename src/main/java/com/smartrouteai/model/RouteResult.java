package com.smartrouteai.model;

import com.smartrouteai.graph.City;
import com.smartrouteai.weather.WeatherData;
import com.smartrouteai.fuel.FuelPrediction;
import com.smartrouteai.traffic.TrafficPrediction;
import com.smartrouteai.toll.TollPrediction;

import java.util.ArrayList;
import java.util.List;

public class RouteResult {

    // =========================================================
    // ROUTE INFORMATION
    // =========================================================

    private List<City> route;

    private double totalDistance;

    private String vehicleType;


    // =========================================================
    // ACTUAL ROAD ROUTE
    // =========================================================

    /*
     * Coordinates are stored as:
     *
     * [latitude, longitude]
     *
     * Example:
     *
     * [13.0827, 80.2707]
     *
     * These coordinates are received from OSRM and converted
     * from [longitude, latitude] to [latitude, longitude]
     * inside RouteService.java.
     */

    private List<List<Double>> roadCoordinates;


    // =========================================================
    // FUEL INFORMATION
    // =========================================================

    private FuelPrediction fuelPrediction;

    private double mileage;

    private double fuelRequired;

    private double fuelCost;


    // =========================================================
    // TOLL INFORMATION
    // =========================================================

    private TollPrediction tollPrediction;

    private int tollCount;

    private double tollCost;


    // =========================================================
    // WEATHER INFORMATION
    // =========================================================

    private WeatherData weather;


    // =========================================================
    // TRAFFIC INFORMATION
    // =========================================================

    private TrafficPrediction trafficPrediction;


    // =========================================================
    // TRAVEL TIME
    // =========================================================

    private double estimatedTimeHours;


    // =========================================================
    // CURRENT TIME
    // =========================================================

    private String currentTime;


    // =========================================================
    // DEFAULT CONSTRUCTOR
    // =========================================================

    public RouteResult() {

        this.route = new ArrayList<>();

        this.roadCoordinates = new ArrayList<>();

        this.totalDistance = 0;

        this.vehicleType = "";

        this.mileage = 0;

        this.fuelRequired = 0;

        this.fuelCost = 0;

        this.tollCount = 0;

        this.tollCost = 0;

        this.estimatedTimeHours = 0;

        this.currentTime = "";
    }


    // =========================================================
    // CONSTRUCTOR
    // =========================================================

    public RouteResult(
            List<City> route,
            double totalDistance) {

        this.route =
                route != null
                        ? route
                        : new ArrayList<>();

        this.totalDistance =
                totalDistance;

        this.roadCoordinates =
                new ArrayList<>();

        this.vehicleType =
                "";

        this.mileage =
                0;

        this.fuelRequired =
                0;

        this.fuelCost =
                0;

        this.tollCount =
                0;

        this.tollCost =
                0;

        this.estimatedTimeHours =
                0;

        this.currentTime =
                "";
    }


    // =========================================================
    // ROUTE GETTER
    // =========================================================

    public List<City> getRoute() {

        return route;
    }


    // =========================================================
    // ROUTE SETTER
    // =========================================================

    public void setRoute(
            List<City> route) {

        this.route =
                route != null
                        ? route
                        : new ArrayList<>();
    }


    // =========================================================
    // TOTAL DISTANCE GETTER
    // =========================================================

    public double getTotalDistance() {

        return totalDistance;
    }


    // =========================================================
    // TOTAL DISTANCE SETTER
    // =========================================================

    public void setTotalDistance(
            double totalDistance) {

        this.totalDistance =
                totalDistance;
    }


    // =========================================================
    // VEHICLE TYPE GETTER
    // =========================================================

    public String getVehicleType() {

        return vehicleType;
    }


    // =========================================================
    // VEHICLE TYPE SETTER
    // =========================================================

    public void setVehicleType(
            String vehicleType) {

        this.vehicleType =
                vehicleType;
    }


    // =========================================================
    // ROAD COORDINATES GETTER
    // =========================================================

    public List<List<Double>> getRoadCoordinates() {

        return roadCoordinates;
    }


    // =========================================================
    // ROAD COORDINATES SETTER
    // =========================================================

    public void setRoadCoordinates(
            List<List<Double>> roadCoordinates) {

        this.roadCoordinates =
                roadCoordinates != null
                        ? roadCoordinates
                        : new ArrayList<>();
    }


    // =========================================================
    // FUEL PREDICTION GETTER
    // =========================================================

    public FuelPrediction getFuelPrediction() {

        return fuelPrediction;
    }


    // =========================================================
    // FUEL PREDICTION SETTER
    // =========================================================

    public void setFuelPrediction(
            FuelPrediction fuelPrediction) {

        this.fuelPrediction =
                fuelPrediction;
    }


    // =========================================================
    // MILEAGE GETTER
    // =========================================================

    public double getMileage() {

        return mileage;
    }


    // =========================================================
    // MILEAGE SETTER
    // =========================================================

    public void setMileage(
            double mileage) {

        this.mileage =
                mileage;
    }


    // =========================================================
    // FUEL REQUIRED GETTER
    // =========================================================

    public double getFuelRequired() {

        return fuelRequired;
    }


    // =========================================================
    // FUEL REQUIRED SETTER
    // =========================================================

    public void setFuelRequired(
            double fuelRequired) {

        this.fuelRequired =
                fuelRequired;
    }


    // =========================================================
    // FUEL COST GETTER
    // =========================================================

    public double getFuelCost() {

        return fuelCost;
    }


    // =========================================================
    // FUEL COST SETTER
    // =========================================================

    public void setFuelCost(
            double fuelCost) {

        this.fuelCost =
                fuelCost;
    }


    // =========================================================
    // TOLL PREDICTION GETTER
    // =========================================================

    public TollPrediction getTollPrediction() {

        return tollPrediction;
    }


    // =========================================================
    // TOLL PREDICTION SETTER
    // =========================================================

    public void setTollPrediction(
            TollPrediction tollPrediction) {

        this.tollPrediction =
                tollPrediction;
    }


    // =========================================================
    // TOLL COUNT GETTER
    // =========================================================

    public int getTollCount() {

        return tollCount;
    }


    // =========================================================
    // TOLL COUNT SETTER
    // =========================================================

    public void setTollCount(
            int tollCount) {

        this.tollCount =
                tollCount;
    }


    // =========================================================
    // TOLL COST GETTER
    // =========================================================

    public double getTollCost() {

        return tollCost;
    }


    // =========================================================
    // TOLL COST SETTER
    // =========================================================

    public void setTollCost(
            double tollCost) {

        this.tollCost =
                tollCost;
    }


    // =========================================================
    // WEATHER GETTER
    // =========================================================

    public WeatherData getWeather() {

        return weather;
    }


    // =========================================================
    // WEATHER SETTER
    // =========================================================

    public void setWeather(
            WeatherData weather) {

        this.weather =
                weather;
    }


    // =========================================================
    // TRAFFIC PREDICTION GETTER
    // =========================================================

    public TrafficPrediction getTrafficPrediction() {

        return trafficPrediction;
    }


    // =========================================================
    // TRAFFIC PREDICTION SETTER
    // =========================================================

    public void setTrafficPrediction(
            TrafficPrediction trafficPrediction) {

        this.trafficPrediction =
                trafficPrediction;
    }


    // =========================================================
    // ESTIMATED TIME GETTER
    // =========================================================

    public double getEstimatedTimeHours() {

        return estimatedTimeHours;
    }


    // =========================================================
    // ESTIMATED TIME SETTER
    // =========================================================

    public void setEstimatedTimeHours(
            double estimatedTimeHours) {

        this.estimatedTimeHours =
                estimatedTimeHours;
    }


    // =========================================================
    // CURRENT TIME GETTER
    // =========================================================

    public String getCurrentTime() {

        return currentTime;
    }


    // =========================================================
    // CURRENT TIME SETTER
    // =========================================================

    public void setCurrentTime(
            String currentTime) {

        this.currentTime =
                currentTime;
    }


    // =========================================================
    // toString()
    // =========================================================

    @Override
    public String toString() {

        return "RouteResult{" +

                "route=" + route +

                ", totalDistance=" +
                totalDistance +

                ", vehicleType='" +
                vehicleType + '\'' +

                ", roadCoordinates=" +
                (roadCoordinates != null
                        ? roadCoordinates.size()
                        : 0)
                + " points" +

                ", mileage=" +
                mileage +

                ", fuelRequired=" +
                fuelRequired +

                ", fuelCost=" +
                fuelCost +

                ", tollCount=" +
                tollCount +

                ", tollCost=" +
                tollCost +

                ", weather=" +
                weather +

                ", trafficPrediction=" +
                trafficPrediction +

                ", estimatedTimeHours=" +
                estimatedTimeHours +

                ", currentTime='" +
                currentTime + '\'' +

                '}';
    }
}