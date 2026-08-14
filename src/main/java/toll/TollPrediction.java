package com.smartrouteai.toll;

public class TollPrediction {

    private int tollCount;

    private double totalTollCost;

    private String vehicleType;

    public TollPrediction() {
    }

    public TollPrediction(
            int tollCount,
            double totalTollCost,
            String vehicleType) {

        this.tollCount = tollCount;
        this.totalTollCost = totalTollCost;
        this.vehicleType = vehicleType;
    }

    public int getTollCount() {
        return tollCount;
    }

    public void setTollCount(int tollCount) {
        this.tollCount = tollCount;
    }

    public double getTotalTollCost() {
        return totalTollCost;
    }

    public void setTotalTollCost(double totalTollCost) {
        this.totalTollCost = totalTollCost;
    }

    public String getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(String vehicleType) {
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {

        return "TollPrediction{" +
                "tollCount=" + tollCount +
                ", totalTollCost=" + totalTollCost +
                ", vehicleType='" + vehicleType + '\'' +
                '}';
    }
}