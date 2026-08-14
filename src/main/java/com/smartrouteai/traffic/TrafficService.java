package com.smartrouteai.traffic;

import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class TrafficService {

    // =========================================================
    // TRAFFIC LIMITS
    // =========================================================

    private static final double LOW_TRAFFIC_LIMIT = 30.0;

    private static final double MEDIUM_TRAFFIC_LIMIT = 60.0;


    // =========================================================
    // DEFAULT NORMAL SPEED
    // =========================================================

    private static final double DEFAULT_NORMAL_SPEED = 60.0;


    // =========================================================
    // NO-ARGUMENT TRAFFIC PREDICTION
    // =========================================================

    /*
     * This method is required because RouteService currently
     * calls:
     *
     * trafficService.predictTraffic();
     *
     * It uses the current hour to estimate the traffic level.
     */

    public TrafficPrediction predictTraffic() {

        int currentHour =
                LocalDateTime.now().getHour();


        double trafficPercentage;


        // -----------------------------------------------------
        // MORNING PEAK
        // -----------------------------------------------------

        if (
                currentHour >= 7
                        &&
                        currentHour <= 10
        ) {

            trafficPercentage = 70.0;
        }


        // -----------------------------------------------------
        // EVENING PEAK
        // -----------------------------------------------------

        else if (
                currentHour >= 17
                        &&
                        currentHour <= 21
        ) {

            trafficPercentage = 80.0;
        }


        // -----------------------------------------------------
        // AFTERNOON
        // -----------------------------------------------------

        else if (
                currentHour >= 11
                        &&
                        currentHour <= 16
        ) {

            trafficPercentage = 40.0;
        }


        // -----------------------------------------------------
        // NIGHT / EARLY MORNING
        // -----------------------------------------------------

        else {

            trafficPercentage = 20.0;
        }


        return predictTraffic(
                DEFAULT_NORMAL_SPEED,
                trafficPercentage
        );
    }


    // =========================================================
    // TRAFFIC PREDICTION
    // =========================================================

    public TrafficPrediction predictTraffic(
            double normalSpeed,
            double trafficPercentage) {

        // -----------------------------------------------------
        // VALIDATE NORMAL SPEED
        // -----------------------------------------------------

        if (normalSpeed < 0) {

            normalSpeed = 0;
        }


        // -----------------------------------------------------
        // LIMIT TRAFFIC PERCENTAGE
        // -----------------------------------------------------

        trafficPercentage =
                Math.max(
                        0.0,
                        Math.min(
                                trafficPercentage,
                                100.0
                        )
                );


        // -----------------------------------------------------
        // DETERMINE TRAFFIC LEVEL
        // -----------------------------------------------------

        String trafficLevel;


        if (
                trafficPercentage <
                        LOW_TRAFFIC_LIMIT
        ) {

            trafficLevel = "Low";
        }

        else if (
                trafficPercentage <
                        MEDIUM_TRAFFIC_LIMIT
        ) {

            trafficLevel = "Medium";
        }

        else {

            trafficLevel = "High";
        }


        // -----------------------------------------------------
        // SPEED MULTIPLIER
        // -----------------------------------------------------

        /*
         *
         * Traffic 20%
         * Multiplier = 0.80
         *
         * Traffic 50%
         * Multiplier = 0.50
         *
         * Traffic 80%
         * Multiplier = 0.20
         *
         */

        double speedMultiplier =
                1.0 -
                        (
                                trafficPercentage
                                        /
                                        100.0
                        );


        if (speedMultiplier < 0) {

            speedMultiplier = 0;
        }


        // -----------------------------------------------------
        // CALCULATE ADJUSTED SPEED
        // -----------------------------------------------------

        double adjustedSpeed =
                normalSpeed
                        *
                        speedMultiplier;


        // -----------------------------------------------------
        // CREATE RESULT
        // -----------------------------------------------------

        TrafficPrediction prediction =
                new TrafficPrediction();


        prediction.setTrafficLevel(
                trafficLevel
        );


        prediction.setTrafficPercentage(
                trafficPercentage
        );


        prediction.setNormalSpeed(
                normalSpeed
        );


        prediction.setTrafficAdjustedSpeed(
                adjustedSpeed
        );


        prediction.setSpeedMultiplier(
                speedMultiplier
        );


        return prediction;
    }


    // =========================================================
    // TRAFFIC PREDICTION USING DISTANCE
    // =========================================================

    public TrafficPrediction predictTrafficFromDistance(
            double normalSpeed,
            double distance) {

        if (normalSpeed < 0) {

            normalSpeed = 0;
        }


        if (distance < 0) {

            distance = 0;
        }


        double trafficPercentage;


        // -----------------------------------------------------
        // SHORT DISTANCE
        // -----------------------------------------------------

        if (distance < 50) {

            trafficPercentage = 20.0;
        }


        // -----------------------------------------------------
        // MEDIUM DISTANCE
        // -----------------------------------------------------

        else if (distance < 150) {

            trafficPercentage = 35.0;
        }


        // -----------------------------------------------------
        // LONG DISTANCE
        // -----------------------------------------------------

        else if (distance < 250) {

            trafficPercentage = 50.0;
        }


        // -----------------------------------------------------
        // VERY LONG DISTANCE
        // -----------------------------------------------------

        else {

            trafficPercentage = 65.0;
        }


        return predictTraffic(
                normalSpeed,
                trafficPercentage
        );
    }


    // =========================================================
    // TRAFFIC PREDICTION USING TIME
    // =========================================================

    public TrafficPrediction predictTrafficByTime(
            double normalSpeed,
            int hour) {

        // -----------------------------------------------------
        // VALIDATE HOUR
        // -----------------------------------------------------

        if (hour < 0) {

            hour = 0;
        }


        if (hour > 23) {

            hour = 23;
        }


        double trafficPercentage;


        // -----------------------------------------------------
        // MORNING PEAK
        // -----------------------------------------------------

        if (
                hour >= 7
                        &&
                        hour <= 10
        ) {

            trafficPercentage = 70.0;
        }


        // -----------------------------------------------------
        // EVENING PEAK
        // -----------------------------------------------------

        else if (
                hour >= 17
                        &&
                        hour <= 21
        ) {

            trafficPercentage = 80.0;
        }


        // -----------------------------------------------------
        // AFTERNOON
        // -----------------------------------------------------

        else if (
                hour >= 11
                        &&
                        hour <= 16
        ) {

            trafficPercentage = 40.0;
        }


        // -----------------------------------------------------
        // NIGHT
        // -----------------------------------------------------

        else {

            trafficPercentage = 20.0;
        }


        return predictTraffic(
                normalSpeed,
                trafficPercentage
        );
    }


    // =========================================================
    // DISTANCE + TIME TRAFFIC PREDICTION
    // =========================================================

    public TrafficPrediction predictTraffic(
            double normalSpeed,
            double distance,
            int hour) {

        // -----------------------------------------------------
        // VALIDATE SPEED
        // -----------------------------------------------------

        if (normalSpeed < 0) {

            normalSpeed = 0;
        }


        // -----------------------------------------------------
        // VALIDATE DISTANCE
        // -----------------------------------------------------

        if (distance < 0) {

            distance = 0;
        }


        // -----------------------------------------------------
        // VALIDATE HOUR
        // -----------------------------------------------------

        if (hour < 0) {

            hour = 0;
        }


        if (hour > 23) {

            hour = 23;
        }


        // -----------------------------------------------------
        // DISTANCE TRAFFIC
        // -----------------------------------------------------

        double distanceTraffic;


        if (distance < 50) {

            distanceTraffic = 20.0;
        }

        else if (distance < 150) {

            distanceTraffic = 35.0;
        }

        else if (distance < 250) {

            distanceTraffic = 50.0;
        }

        else {

            distanceTraffic = 65.0;
        }


        // -----------------------------------------------------
        // TIME TRAFFIC
        // -----------------------------------------------------

        double timeTraffic;


        if (
                hour >= 7
                        &&
                        hour <= 10
        ) {

            timeTraffic = 70.0;
        }

        else if (
                hour >= 17
                        &&
                        hour <= 21
        ) {

            timeTraffic = 80.0;
        }

        else if (
                hour >= 11
                        &&
                        hour <= 16
        ) {

            timeTraffic = 40.0;
        }

        else {

            timeTraffic = 20.0;
        }


        // -----------------------------------------------------
        // COMBINE DISTANCE AND TIME
        // -----------------------------------------------------

        /*
         * Distance contributes 40%.
         *
         * Current time contributes 60%.
         */

        double trafficPercentage =
                (
                        distanceTraffic
                                *
                                0.40
                )
                        +
                        (
                                timeTraffic
                                        *
                                        0.60
                        );


        return predictTraffic(
                normalSpeed,
                trafficPercentage
        );
    }


    // =========================================================
    // GET TRAFFIC LEVEL
    // =========================================================

    public String getTrafficLevel(
            double trafficPercentage) {

        trafficPercentage =
                Math.max(
                        0.0,
                        Math.min(
                                trafficPercentage,
                                100.0
                        )
                );


        if (
                trafficPercentage <
                        LOW_TRAFFIC_LIMIT
        ) {

            return "Low";
        }


        if (
                trafficPercentage <
                        MEDIUM_TRAFFIC_LIMIT
        ) {

            return "Medium";
        }


        return "High";
    }


    // =========================================================
    // GET ADJUSTED SPEED
    // =========================================================

    public double getAdjustedSpeed(
            double normalSpeed,
            double trafficPercentage) {

        if (normalSpeed < 0) {

            normalSpeed = 0;
        }


        trafficPercentage =
                Math.max(
                        0.0,
                        Math.min(
                                trafficPercentage,
                                100.0
                        )
                );


        double speedMultiplier =
                1.0 -
                        (
                                trafficPercentage
                                        /
                                        100.0
                        );


        return normalSpeed
                *
                speedMultiplier;
    }


    // =========================================================
    // GET SPEED MULTIPLIER
    // =========================================================

    public double getSpeedMultiplier(
            double trafficPercentage) {

        trafficPercentage =
                Math.max(
                        0.0,
                        Math.min(
                                trafficPercentage,
                                100.0
                        )
                );


        return 1.0 -
                (
                        trafficPercentage
                                /
                                100.0
                );
    }


    // =========================================================
    // TRAFFIC DESCRIPTION
    // =========================================================

    public String getTrafficDescription(
            double trafficPercentage) {

        trafficPercentage =
                Math.max(
                        0.0,
                        Math.min(
                                trafficPercentage,
                                100.0
                        )
                );


        if (
                trafficPercentage < 30
        ) {

            return
                    "Traffic is light. "
                            +
                            "Normal travel conditions.";
        }


        if (
                trafficPercentage < 60
        ) {

            return
                    "Moderate traffic is expected. "
                            +
                            "Travel speed may be reduced.";
        }


        return
                "Heavy traffic is expected. "
                        +
                        "Significant travel delay may occur.";
    }
}