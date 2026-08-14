package com.smartrouteai.toll;

import org.springframework.stereotype.Service;

@Service
public class TollService {

    public TollPrediction calculateTollCost(
            String source,
            String destination,
            String vehicleType) {

        if (source == null ||
                destination == null ||
                vehicleType == null) {

            return new TollPrediction(
                    0,
                    0,
                    vehicleType
            );
        }

        source = source.trim();
        destination = destination.trim();
        vehicleType = vehicleType.trim();

        int tollCount = 0;
        double tollCostPerToll = 0;

        /*
         * ==========================================
         * CHENNAI ROUTES
         * ==========================================
         */

        if (isRoute(source, destination,
                "Chennai", "Vellore")) {

            tollCount = 2;

        } else if (isRoute(source, destination,
                "Chennai", "Salem")) {

            tollCount = 3;

        } else if (isRoute(source, destination,
                "Chennai", "Trichy")) {

            tollCount = 3;

        } else if (isRoute(source, destination,
                "Chennai", "Madurai")) {

            tollCount = 4;

        } else if (isRoute(source, destination,
                "Chennai", "Coimbatore")) {

            tollCount = 4;
        }


        /*
         * ==========================================
         * VELLORE ROUTES
         * ==========================================
         */

        else if (isRoute(source, destination,
                "Vellore", "Salem")) {

            tollCount = 2;

        } else if (isRoute(source, destination,
                "Vellore", "Trichy")) {

            tollCount = 2;

        } else if (isRoute(source, destination,
                "Vellore", "Madurai")) {

            tollCount = 3;

        } else if (isRoute(source, destination,
                "Vellore", "Coimbatore")) {

            tollCount = 2;
        }


        /*
         * ==========================================
         * SALEM ROUTES
         * ==========================================
         */

        else if (isRoute(source, destination,
                "Salem", "Trichy")) {

            tollCount = 1;

        } else if (isRoute(source, destination,
                "Salem", "Madurai")) {

            tollCount = 2;

        } else if (isRoute(source, destination,
                "Salem", "Coimbatore")) {

            tollCount = 1;
        }


        /*
         * ==========================================
         * TRICHY ROUTES
         * ==========================================
         */

        else if (isRoute(source, destination,
                "Trichy", "Madurai")) {

            tollCount = 1;

        } else if (isRoute(source, destination,
                "Trichy", "Coimbatore")) {

            tollCount = 2;
        }


        /*
         * ==========================================
         * MADURAI - COIMBATORE
         * ==========================================
         */

        else if (isRoute(source, destination,
                "Madurai", "Coimbatore")) {

            tollCount = 2;
        }


        /*
         * ==========================================
         * VEHICLE TOLL RATE
         * ==========================================
         */

        if ("Bike".equalsIgnoreCase(vehicleType)) {

            /*
             * Bikes generally have lower toll
             * charges on many toll roads.
             */
            tollCostPerToll = 30.0;

        } else if ("Car".equalsIgnoreCase(vehicleType)) {

            tollCostPerToll = 90.0;

        } else if ("Diesel Car".equalsIgnoreCase(vehicleType)) {

            tollCostPerToll = 90.0;

        } else {

            tollCostPerToll = 90.0;
        }


        double totalTollCost =
                tollCount * tollCostPerToll;


        totalTollCost =
                Math.round(
                        totalTollCost * 100.0
                ) / 100.0;


        return new TollPrediction(
                tollCount,
                totalTollCost,
                vehicleType
        );
    }


    /*
     * ==========================================
     * ROUTE COMPARISON
     * ==========================================
     */

    private boolean isRoute(
            String source,
            String destination,
            String city1,
            String city2) {

        return
                (source.equalsIgnoreCase(city1)
                        && destination.equalsIgnoreCase(city2))

                        ||

                        (source.equalsIgnoreCase(city2)
                                && destination.equalsIgnoreCase(city1));
    }
}