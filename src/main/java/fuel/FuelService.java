package com.smartrouteai.fuel;

import org.springframework.stereotype.Service;

@Service
public class FuelService {

    // =========================================================
    // CALCULATE FUEL COST
    // =========================================================

    public FuelPrediction calculateFuelCost(
            double distanceKm,
            String vehicleType) {

        // -----------------------------------------------------
        // Default values
        // -----------------------------------------------------

        double mileage;
        double fuelPrice;
        String fuelType;


        // -----------------------------------------------------
        // Validate distance
        // -----------------------------------------------------

        if (distanceKm < 0) {

            distanceKm = 0;
        }


        // -----------------------------------------------------
        // Default vehicle
        // -----------------------------------------------------

        if (vehicleType == null ||
                vehicleType.isBlank()) {

            vehicleType = "Bike";
        }


        vehicleType = vehicleType.trim();


        // =====================================================
        // BIKE
        // =====================================================

        if ("Bike".equalsIgnoreCase(vehicleType)) {

            mileage = 50.0;

            fuelPrice = 102.0;

            fuelType = "Petrol";
        }


        // =====================================================
        // PETROL CAR
        // =====================================================

        else if ("Car".equalsIgnoreCase(vehicleType)) {

            mileage = 15.0;

            fuelPrice = 102.0;

            fuelType = "Petrol";
        }


        // =====================================================
        // DIESEL CAR
        // =====================================================

        else if ("Diesel Car".equalsIgnoreCase(vehicleType)) {

            mileage = 20.0;

            fuelPrice = 92.0;

            fuelType = "Diesel";
        }


        // =====================================================
        // DEFAULT
        // =====================================================

        else {

            mileage = 50.0;

            fuelPrice = 102.0;

            fuelType = "Petrol";

            vehicleType = "Bike";
        }


        // =====================================================
        // FUEL REQUIRED
        // =====================================================

        double fuelRequired =
                distanceKm / mileage;


        // =====================================================
        // TOTAL FUEL COST
        // =====================================================

        double totalFuelCost =
                fuelRequired * fuelPrice;


        // =====================================================
        // ROUND VALUES
        // =====================================================

        fuelRequired =
                Math.round(
                        fuelRequired * 100.0
                ) / 100.0;


        totalFuelCost =
                Math.round(
                        totalFuelCost * 100.0
                ) / 100.0;


        // =====================================================
        // CREATE FUEL PREDICTION
        // =====================================================

        return new FuelPrediction(
                mileage,
                fuelPrice,
                fuelRequired,
                totalFuelCost,
                fuelType
        );
    }
}