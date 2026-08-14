package com.smartrouteai.traffic;

public class TrafficPrediction {

    // =========================================================
    // TRAFFIC LEVEL
    // =========================================================

    private String trafficLevel;


    // =========================================================
    // TRAFFIC PERCENTAGE
    // =========================================================

    private double trafficPercentage;


    // =========================================================
    // NORMAL SPEED
    // =========================================================

    private double normalSpeed;


    // =========================================================
    // TRAFFIC ADJUSTED SPEED
    // =========================================================

    private double trafficAdjustedSpeed;


    // =========================================================
    // SPEED MULTIPLIER
    // =========================================================

    private double speedMultiplier;


    // =========================================================
    // DEFAULT CONSTRUCTOR
    // =========================================================

    public TrafficPrediction() {

        this.trafficLevel = "";

        this.trafficPercentage = 0.0;

        this.normalSpeed = 0.0;

        this.trafficAdjustedSpeed = 0.0;

        this.speedMultiplier = 1.0;
    }


    // =========================================================
    // GET TRAFFIC LEVEL
    // =========================================================

    public String getTrafficLevel() {

        return trafficLevel;
    }


    // =========================================================
    // SET TRAFFIC LEVEL
    // =========================================================

    public void setTrafficLevel(String trafficLevel) {

        this.trafficLevel = trafficLevel;
    }


    // =========================================================
    // GET TRAFFIC PERCENTAGE
    // =========================================================

    public double getTrafficPercentage() {

        return trafficPercentage;
    }


    // =========================================================
    // SET TRAFFIC PERCENTAGE
    // =========================================================

    public void setTrafficPercentage(
            double trafficPercentage) {

        this.trafficPercentage =
                trafficPercentage;
    }


    // =========================================================
    // GET NORMAL SPEED
    // =========================================================

    public double getNormalSpeed() {

        return normalSpeed;
    }


    // =========================================================
    // SET NORMAL SPEED
    // =========================================================

    public void setNormalSpeed(double normalSpeed) {

        this.normalSpeed = normalSpeed;
    }


    // =========================================================
    // GET TRAFFIC ADJUSTED SPEED
    // =========================================================

    public double getTrafficAdjustedSpeed() {

        return trafficAdjustedSpeed;
    }


    // =========================================================
    // SET TRAFFIC ADJUSTED SPEED
    // =========================================================

    public void setTrafficAdjustedSpeed(
            double trafficAdjustedSpeed) {

        this.trafficAdjustedSpeed =
                trafficAdjustedSpeed;
    }


    // =========================================================
    // GET SPEED MULTIPLIER
    // =========================================================

    public double getSpeedMultiplier() {

        return speedMultiplier;
    }


    // =========================================================
    // SET SPEED MULTIPLIER
    // =========================================================

    public void setSpeedMultiplier(
            double speedMultiplier) {

        this.speedMultiplier =
                speedMultiplier;
    }


    // =========================================================
    // toString
    // =========================================================

    @Override
    public String toString() {

        return "TrafficPrediction{" +

                "trafficLevel='" +
                trafficLevel + '\'' +

                ", trafficPercentage=" +
                trafficPercentage +

                ", normalSpeed=" +
                normalSpeed +

                ", trafficAdjustedSpeed=" +
                trafficAdjustedSpeed +

                ", speedMultiplier=" +
                speedMultiplier +

                '}';
    }
}