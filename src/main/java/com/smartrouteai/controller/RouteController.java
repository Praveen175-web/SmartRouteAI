package com.smartrouteai.controller;

import com.smartrouteai.firebase.FirebaseService;
import com.smartrouteai.firebase.SearchHistory;
import com.smartrouteai.model.RouteResult;
import com.smartrouteai.service.RouteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RouteController {

    @Autowired
    private RouteService routeService;

    @Autowired
    private FirebaseService firebaseService;


    // =========================================================
    // FIND ROUTE
    // =========================================================

    @PostMapping("/find-route")
    public String findRoute(

            @RequestParam("source")
            String source,

            @RequestParam("destination")
            String destination,

            @RequestParam(
                    value = "vehicleType",
                    required = false
            )
            String vehicleType,

            Model model) {

        System.out.println("==========================================");
        System.out.println("          FIND ROUTE REQUEST");
        System.out.println("==========================================");

        System.out.println("Source      : " + source);
        System.out.println("Destination : " + destination);
        System.out.println("Vehicle     : " + vehicleType);


        // =====================================================
        // VALIDATE SOURCE
        // =====================================================

        if (source == null || source.isBlank()) {

            model.addAttribute(
                    "error",
                    "Please select a source city."
            );

            return "journey";
        }


        // =====================================================
        // VALIDATE DESTINATION
        // =====================================================

        if (destination == null || destination.isBlank()) {

            model.addAttribute(
                    "error",
                    "Please select a destination city."
            );

            return "journey";
        }


        // =====================================================
        // CLEAN INPUT
        // =====================================================

        source = source.trim();
        destination = destination.trim();


        // =====================================================
        // DEFAULT VEHICLE
        // =====================================================

        if (vehicleType == null || vehicleType.isBlank()) {

            vehicleType = "Bike";
        }

        vehicleType = vehicleType.trim();


        // =====================================================
        // SAME CITY CHECK
        // =====================================================

        if (source.equalsIgnoreCase(destination)) {

            model.addAttribute(
                    "error",
                    "Source and destination cannot be the same."
            );

            return "journey";
        }


        // =====================================================
        // FIND ROUTE
        // =====================================================

        RouteResult result;

        try {

            result = routeService.findRoute(
                    source,
                    destination,
                    vehicleType
            );

        } catch (Exception e) {

            System.out.println(
                    "Route service error:"
            );

            e.printStackTrace();

            model.addAttribute(
                    "error",
                    "Unable to calculate route. Please try again."
            );

            return "journey";
        }


        // =====================================================
        // CHECK RESULT
        // =====================================================

        if (result == null) {

            model.addAttribute(
                    "error",
                    "No route information available."
            );

            return "journey";
        }


        // =====================================================
        // DEBUG RESULT
        // =====================================================

        System.out.println("==========================================");
        System.out.println("          ROUTE RESULT");
        System.out.println("==========================================");

        System.out.println(
                "Distance : "
                        + result.getTotalDistance()
        );

        System.out.println(
                "Vehicle  : "
                        + result.getVehicleType()
        );


        // =====================================================
        // PRINT ROUTE
        // =====================================================

        if (result.getRoute() != null) {

            System.out.println("Route:");

            result.getRoute().forEach(
                    city -> {

                        if (city != null) {

                            System.out.println(
                                    " -> "
                                            + city.getName()
                            );
                        }
                    }
            );
        }


        // =====================================================
        // PRINT FUEL
        // =====================================================

        System.out.println(
                "Fuel Required : "
                        + result.getFuelRequired()
        );

        System.out.println(
                "Fuel Cost : ₹"
                        + result.getFuelCost()
        );


        // =====================================================
        // PRINT TOLL
        // =====================================================

        System.out.println(
                "Toll Count : "
                        + result.getTollCount()
        );

        System.out.println(
                "Toll Cost : ₹"
                        + result.getTollCost()
        );


        // =====================================================
        // PRINT TRAVEL TIME
        // =====================================================

        System.out.println(
                "Estimated Time : "
                        + result.getEstimatedTimeHours()
                        + " hours"
        );


        // =====================================================
        // PRINT TRAFFIC
        // =====================================================

        if (result.getTrafficPrediction() != null) {

            System.out.println(
                    "Traffic Level : "
                            + result
                            .getTrafficPrediction()
                            .getTrafficLevel()
            );

            System.out.println(
                    "Traffic Percentage : "
                            + result
                            .getTrafficPrediction()
                            .getTrafficPercentage()
            );
        }


        // =====================================================
        // PRINT WEATHER
        // =====================================================

        if (result.getWeather() != null) {

            System.out.println(
                    "Temperature : "
                            + result
                            .getWeather()
                            .getTemperature()
            );

            System.out.println(
                    "Weather : "
                            + result
                            .getWeather()
                            .getDescription()
            );
        }


        // =====================================================
        // IMPORTANT
        // SEND COMPLETE RESULT TO result.html
        // =====================================================

        model.addAttribute(
                "routeResult",
                result
        );


        // =====================================================
        // ALSO SEND BASIC VALUES
        // =====================================================

        model.addAttribute(
                "source",
                source
        );

        model.addAttribute(
                "destination",
                destination
        );

        model.addAttribute(
                "vehicleType",
                vehicleType
        );


        // =====================================================
        // SAVE SEARCH HISTORY
        // =====================================================

        try {

            SearchHistory history =
                    new SearchHistory();


            // -------------------------------------------------
            // BASIC
            // -------------------------------------------------

            history.setSource(
                    source
            );

            history.setDestination(
                    destination
            );

            history.setVehicleType(
                    vehicleType
            );


            // -------------------------------------------------
            // DISTANCE
            // -------------------------------------------------

            history.setDistance(
                    result.getTotalDistance()
            );


            // -------------------------------------------------
            // FUEL
            // -------------------------------------------------

            history.setFuelRequired(
                    result.getFuelRequired()
            );

            history.setFuelCost(
                    result.getFuelCost()
            );


            // -------------------------------------------------
            // TRAVEL TIME
            // -------------------------------------------------

            history.setEstimatedTime(
                    result.getEstimatedTimeHours()
            );


            // -------------------------------------------------
            // TRAFFIC
            // -------------------------------------------------

            if (result.getTrafficPrediction() != null) {

                history.setTrafficLevel(
                        result
                                .getTrafficPrediction()
                                .getTrafficLevel()
                );

                history.setTrafficPercentage(
                        result
                                .getTrafficPrediction()
                                .getTrafficPercentage()
                );

            } else {

                history.setTrafficLevel(
                        "Unavailable"
                );

                history.setTrafficPercentage(
                        0
                );
            }


            // -------------------------------------------------
            // WEATHER
            // -------------------------------------------------

            if (result.getWeather() != null) {

                history.setWeather(
                        result
                                .getWeather()
                                .getDescription()
                );

                history.setTemperature(
                        result
                                .getWeather()
                                .getTemperature()
                );

            } else {

                history.setWeather(
                        "Unavailable"
                );

                history.setTemperature(
                        0
                );
            }


            // -------------------------------------------------
            // CURRENT TIME
            // -------------------------------------------------

            history.setCurrentTime(
                    result.getCurrentTime()
            );


            // -------------------------------------------------
            // SAVE
            // -------------------------------------------------

            firebaseService.saveSearchHistory(
                    history
            );

            System.out.println(
                    "=========================================="
            );

            System.out.println(
                    "SEARCH HISTORY SAVED TO FIREBASE"
            );

            System.out.println(
                    "Source: " + source
            );

            System.out.println(
                    "Destination: " + destination
            );

            System.out.println(
                    "Vehicle: " + vehicleType
            );

            System.out.println(
                    "=========================================="
            );

        } catch (Exception e) {

            System.out.println(
                    "Firebase history error:"
            );

            e.printStackTrace();

            // Firebase failure should NOT
            // prevent result.html from opening.
        }


        // =====================================================
        // FINAL
        // =====================================================

        System.out.println(
                "=========================================="
        );

        System.out.println(
                "Route calculation completed."
        );

        System.out.println(
                "Opening result.html"
        );

        System.out.println(
                "=========================================="
        );


        return "result";
    }
}