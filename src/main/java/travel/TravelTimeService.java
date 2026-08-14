package com.smartrouteai.travel;

import org.springframework.stereotype.Service;

@Service
public class TravelTimeService {

    public TravelTimePrediction calculateTravelTime(
            double distanceKm,
            String vehicleType) {

        double averageSpeed;

        if ("Bike".equalsIgnoreCase(vehicleType)) {

            averageSpeed = 50.0;

        } else if ("Car".equalsIgnoreCase(vehicleType)) {

            averageSpeed = 55.0;

        } else if ("Diesel Car".equalsIgnoreCase(vehicleType)) {

            averageSpeed = 55.0;

        } else {

            averageSpeed = 50.0;
        }

        double travelTimeHours =
                distanceKm / averageSpeed;

        int totalMinutes =
                (int) Math.round(travelTimeHours * 60);

        int hours = totalMinutes / 60;
        int minutes = totalMinutes % 60;

        String formattedTime;

        if (hours > 0) {

            formattedTime =
                    hours + " hours "
                            + minutes + " minutes";

        } else {

            formattedTime =
                    minutes + " minutes";
        }

        return new TravelTimePrediction(
                averageSpeed,
                travelTimeHours,
                totalMinutes,
                formattedTime
        );
    }
}