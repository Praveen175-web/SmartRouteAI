package com.smartrouteai.travel;

public class TravelTimePrediction {

    private double averageSpeed;
    private double travelTimeHours;
    private int travelTimeMinutes;
    private String formattedTime;

    public TravelTimePrediction() {
    }

    public TravelTimePrediction(
            double averageSpeed,
            double travelTimeHours,
            int travelTimeMinutes,
            String formattedTime) {

        this.averageSpeed = averageSpeed;
        this.travelTimeHours = travelTimeHours;
        this.travelTimeMinutes = travelTimeMinutes;
        this.formattedTime = formattedTime;
    }

    public double getAverageSpeed() {
        return averageSpeed;
    }

    public void setAverageSpeed(double averageSpeed) {
        this.averageSpeed = averageSpeed;
    }

    public double getTravelTimeHours() {
        return travelTimeHours;
    }

    public void setTravelTimeHours(double travelTimeHours) {
        this.travelTimeHours = travelTimeHours;
    }

    public int getTravelTimeMinutes() {
        return travelTimeMinutes;
    }

    public void setTravelTimeMinutes(int travelTimeMinutes) {
        this.travelTimeMinutes = travelTimeMinutes;
    }

    public String getFormattedTime() {
        return formattedTime;
    }

    public void setFormattedTime(String formattedTime) {
        this.formattedTime = formattedTime;
    }
}
