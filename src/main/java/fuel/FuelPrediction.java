package com.smartrouteai.fuel;

public class FuelPrediction {

    // =========================================================
    // FUEL REQUIRED
    // =========================================================

    private double fuelRequired;


    // =========================================================
    // FUEL COST
    // =========================================================

    private double fuelCost;


    // =========================================================
    // FUEL PRICE
    // =========================================================

    private double fuelPrice;


    // =========================================================
    // MILEAGE
    // =========================================================

    private double mileage;


    // =========================================================
    // VEHICLE TYPE
    // =========================================================

    private String vehicleType;


    // =========================================================
    // DEFAULT CONSTRUCTOR
    // =========================================================

    public FuelPrediction() {

        this.fuelRequired = 0.0;

        this.fuelCost = 0.0;

        this.fuelPrice = 0.0;

        this.mileage = 0.0;

        this.vehicleType = "";
    }


    // =========================================================
    // FIVE-ARGUMENT CONSTRUCTOR
    // =========================================================

    public FuelPrediction(
            double fuelRequired,
            double fuelCost,
            double fuelPrice,
            double mileage,
            String vehicleType) {

        this.fuelRequired =
                fuelRequired;

        this.fuelCost =
                fuelCost;

        this.fuelPrice =
                fuelPrice;

        this.mileage =
                mileage;

        this.vehicleType =
                vehicleType;
    }


    // =========================================================
    // GET FUEL REQUIRED
    // =========================================================

    public double getFuelRequired() {

        return fuelRequired;
    }


    // =========================================================
    // SET FUEL REQUIRED
    // =========================================================

    public void setFuelRequired(
            double fuelRequired) {

        this.fuelRequired =
                fuelRequired;
    }


    // =========================================================
    // GET FUEL COST
    // =========================================================

    public double getFuelCost() {

        return fuelCost;
    }


    // =========================================================
    // SET FUEL COST
    // =========================================================

    public void setFuelCost(
            double fuelCost) {

        this.fuelCost =
                fuelCost;
    }


    // =========================================================
    // GET FUEL PRICE
    // =========================================================

    public double getFuelPrice() {

        return fuelPrice;
    }


    // =========================================================
    // SET FUEL PRICE
    // =========================================================

    public void setFuelPrice(
            double fuelPrice) {

        this.fuelPrice =
                fuelPrice;
    }


    // =========================================================
    // GET FUEL PRICE PER LITRE
    // =========================================================

    public double getFuelPricePerLitre() {

        return fuelPrice;
    }


    // =========================================================
    // SET FUEL PRICE PER LITRE
    // =========================================================

    public void setFuelPricePerLitre(
            double fuelPricePerLitre) {

        this.fuelPrice =
                fuelPricePerLitre;
    }


    // =========================================================
    // GET MILEAGE
    // =========================================================

    public double getMileage() {

        return mileage;
    }


    // =========================================================
    // SET MILEAGE
    // =========================================================

    public void setMileage(
            double mileage) {

        this.mileage =
                mileage;
    }


    // =========================================================
    // GET VEHICLE TYPE
    // =========================================================

    public String getVehicleType() {

        return vehicleType;
    }


    // =========================================================
    // SET VEHICLE TYPE
    // =========================================================

    public void setVehicleType(
            String vehicleType) {

        this.vehicleType =
                vehicleType;
    }


    // =========================================================
    // GET TOTAL FUEL COST
    // =========================================================

    public double getTotalFuelCost() {

        return fuelCost;
    }


    // =========================================================
    // SET TOTAL FUEL COST
    // =========================================================

    public void setTotalFuelCost(
            double totalFuelCost) {

        this.fuelCost =
                totalFuelCost;
    }


    // =========================================================
    // toString
    // =========================================================

    @Override
    public String toString() {

        return "FuelPrediction{" +

                "fuelRequired=" +
                fuelRequired +

                ", fuelCost=" +
                fuelCost +

                ", fuelPrice=" +
                fuelPrice +

                ", mileage=" +
                mileage +

                ", vehicleType='" +
                vehicleType + '\'' +

                '}';
    }
}