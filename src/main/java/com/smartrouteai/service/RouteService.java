package com.smartrouteai.service;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.smartrouteai.graph.City;
import com.smartrouteai.model.RouteResult;

import com.smartrouteai.weather.WeatherData;
import com.smartrouteai.weather.WeatherService;

import com.smartrouteai.fuel.FuelPrediction;
import com.smartrouteai.fuel.FuelService;

import com.smartrouteai.traffic.TrafficPrediction;
import com.smartrouteai.traffic.TrafficService;

import com.smartrouteai.toll.TollPrediction;
import com.smartrouteai.toll.TollService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class RouteService {

    // =========================================================
    // SERVICES
    // =========================================================

    @Autowired
    private WeatherService weatherService;

    @Autowired
    private FuelService fuelService;

    @Autowired
    private TrafficService trafficService;

    @Autowired
    private TollService tollService;


    // =========================================================
    // OSRM CONFIGURATION
    // =========================================================

    private final RestTemplate restTemplate =
            new RestTemplate();

    private final ObjectMapper objectMapper =
            new ObjectMapper();

    private static final String OSRM_URL =
            "https://router.project-osrm.org/route/v1/driving/";


    // =========================================================
    // FIND ROUTE
    // =========================================================

    public RouteResult findRoute(
            String source,
            String destination,
            String vehicleType) {

        if (source == null ||
                destination == null ||
                source.isBlank() ||
                destination.isBlank()) {

            return new RouteResult(
                    new ArrayList<>(),
                    0
            );
        }

        source = source.trim();
        destination = destination.trim();

        if (vehicleType == null ||
                vehicleType.isBlank()) {

            vehicleType = "Bike";
        }

        vehicleType = vehicleType.trim();


        // =====================================================
        // SAME DISTRICT
        // =====================================================

        if (source.equalsIgnoreCase(destination)) {

            City city = createCity(source);

            RouteResult result =
                    new RouteResult(
                            List.of(city),
                            0
                    );

            addExtraInformation(
                    result,
                    destination,
                    vehicleType
            );

            return result;
        }


        // =====================================================
        // EXISTING MAIN ROUTES
        // =====================================================

        if (source.equalsIgnoreCase("Chennai")
                && destination.equalsIgnoreCase("Vellore")) {

            return createRoute(
                    "Chennai",
                    "Vellore",
                    140,
                    vehicleType
            );
        }

        if (source.equalsIgnoreCase("Chennai")
                && destination.equalsIgnoreCase("Salem")) {

            return createRoute(
                    "Chennai",
                    "Vellore",
                    "Salem",
                    340,
                    vehicleType
            );
        }

        if (source.equalsIgnoreCase("Chennai")
                && destination.equalsIgnoreCase("Trichy")) {

            return createRoute(
                    "Chennai",
                    "Vellore",
                    "Salem",
                    "Trichy",
                    330,
                    vehicleType
            );
        }

        if (source.equalsIgnoreCase("Chennai")
                && destination.equalsIgnoreCase("Madurai")) {

            return createRoute(
                    "Chennai",
                    "Vellore",
                    "Salem",
                    "Trichy",
                    "Madurai",
                    460,
                    vehicleType
            );
        }

        if (source.equalsIgnoreCase("Chennai")
                && destination.equalsIgnoreCase("Coimbatore")) {

            return createRoute(
                    "Chennai",
                    "Vellore",
                    "Salem",
                    "Coimbatore",
                    500,
                    vehicleType
            );
        }


        // =====================================================
        // VELLORE
        // =====================================================

        if (source.equalsIgnoreCase("Vellore")
                && destination.equalsIgnoreCase("Chennai")) {

            return createRoute(
                    "Vellore",
                    "Chennai",
                    140,
                    vehicleType
            );
        }

        if (source.equalsIgnoreCase("Vellore")
                && destination.equalsIgnoreCase("Salem")) {

            return createRoute(
                    "Vellore",
                    "Salem",
                    200,
                    vehicleType
            );
        }

        if (source.equalsIgnoreCase("Vellore")
                && destination.equalsIgnoreCase("Trichy")) {

            return createRoute(
                    "Vellore",
                    "Salem",
                    "Trichy",
                    340,
                    vehicleType
            );
        }

        if (source.equalsIgnoreCase("Vellore")
                && destination.equalsIgnoreCase("Madurai")) {

            return createRoute(
                    "Vellore",
                    "Salem",
                    "Trichy",
                    "Madurai",
                    480,
                    vehicleType
            );
        }

        if (source.equalsIgnoreCase("Vellore")
                && destination.equalsIgnoreCase("Coimbatore")) {

            return createRoute(
                    "Vellore",
                    "Salem",
                    "Coimbatore",
                    390,
                    vehicleType
            );
        }


        // =====================================================
        // SALEM
        // =====================================================

        if (source.equalsIgnoreCase("Salem")
                && destination.equalsIgnoreCase("Chennai")) {

            return createRoute(
                    "Salem",
                    "Vellore",
                    "Chennai",
                    340,
                    vehicleType
            );
        }

        if (source.equalsIgnoreCase("Salem")
                && destination.equalsIgnoreCase("Vellore")) {

            return createRoute(
                    "Salem",
                    "Vellore",
                    200,
                    vehicleType
            );
        }

        if (source.equalsIgnoreCase("Salem")
                && destination.equalsIgnoreCase("Trichy")) {

            return createRoute(
                    "Salem",
                    "Trichy",
                    170,
                    vehicleType
            );
        }

        if (source.equalsIgnoreCase("Salem")
                && destination.equalsIgnoreCase("Madurai")) {

            return createRoute(
                    "Salem",
                    "Trichy",
                    "Madurai",
                    330,
                    vehicleType
            );
        }

        if (source.equalsIgnoreCase("Salem")
                && destination.equalsIgnoreCase("Coimbatore")) {

            return createRoute(
                    "Salem",
                    "Coimbatore",
                    160,
                    vehicleType
            );
        }


        // =====================================================
        // TRICHY
        // =====================================================

        if (source.equalsIgnoreCase("Trichy")
                && destination.equalsIgnoreCase("Chennai")) {

            return createRoute(
                    "Trichy",
                    "Salem",
                    "Vellore",
                    "Chennai",
                    330,
                    vehicleType
            );
        }

        if (source.equalsIgnoreCase("Trichy")
                && destination.equalsIgnoreCase("Vellore")) {

            return createRoute(
                    "Trichy",
                    "Salem",
                    "Vellore",
                    340,
                    vehicleType
            );
        }

        if (source.equalsIgnoreCase("Trichy")
                && destination.equalsIgnoreCase("Salem")) {

            return createRoute(
                    "Trichy",
                    "Salem",
                    170,
                    vehicleType
            );
        }

        if (source.equalsIgnoreCase("Trichy")
                && destination.equalsIgnoreCase("Madurai")) {

            return createRoute(
                    "Trichy",
                    "Madurai",
                    140,
                    vehicleType
            );
        }

        if (source.equalsIgnoreCase("Trichy")
                && destination.equalsIgnoreCase("Coimbatore")) {

            return createRoute(
                    "Trichy",
                    "Salem",
                    "Coimbatore",
                    330,
                    vehicleType
            );
        }


        // =====================================================
        // MADURAI
        // =====================================================

        if (source.equalsIgnoreCase("Madurai")
                && destination.equalsIgnoreCase("Chennai")) {

            return createRoute(
                    "Madurai",
                    "Trichy",
                    "Salem",
                    "Vellore",
                    "Chennai",
                    460,
                    vehicleType
            );
        }

        if (source.equalsIgnoreCase("Madurai")
                && destination.equalsIgnoreCase("Vellore")) {

            return createRoute(
                    "Madurai",
                    "Trichy",
                    "Salem",
                    "Vellore",
                    480,
                    vehicleType
            );
        }

        if (source.equalsIgnoreCase("Madurai")
                && destination.equalsIgnoreCase("Salem")) {

            return createRoute(
                    "Madurai",
                    "Trichy",
                    "Salem",
                    330,
                    vehicleType
            );
        }

        if (source.equalsIgnoreCase("Madurai")
                && destination.equalsIgnoreCase("Trichy")) {

            return createRoute(
                    "Madurai",
                    "Trichy",
                    140,
                    vehicleType
            );
        }

        if (source.equalsIgnoreCase("Madurai")
                && destination.equalsIgnoreCase("Coimbatore")) {

            return createRoute(
                    "Madurai",
                    "Trichy",
                    "Salem",
                    "Coimbatore",
                    380,
                    vehicleType
            );
        }


        // =====================================================
        // COIMBATORE
        // =====================================================

        if (source.equalsIgnoreCase("Coimbatore")
                && destination.equalsIgnoreCase("Chennai")) {

            return createRoute(
                    "Coimbatore",
                    "Salem",
                    "Vellore",
                    "Chennai",
                    500,
                    vehicleType
            );
        }

        if (source.equalsIgnoreCase("Coimbatore")
                && destination.equalsIgnoreCase("Vellore")) {

            return createRoute(
                    "Coimbatore",
                    "Salem",
                    "Vellore",
                    390,
                    vehicleType
            );
        }

        if (source.equalsIgnoreCase("Coimbatore")
                && destination.equalsIgnoreCase("Salem")) {

            return createRoute(
                    "Coimbatore",
                    "Salem",
                    160,
                    vehicleType
            );
        }

        if (source.equalsIgnoreCase("Coimbatore")
                && destination.equalsIgnoreCase("Trichy")) {

            return createRoute(
                    "Coimbatore",
                    "Salem",
                    "Trichy",
                    330,
                    vehicleType
            );
        }

        if (source.equalsIgnoreCase("Coimbatore")
                && destination.equalsIgnoreCase("Madurai")) {

            return createRoute(
                    "Coimbatore",
                    "Salem",
                    "Trichy",
                    "Madurai",
                    380,
                    vehicleType
            );
        }


        // =====================================================
        // ALL 38 DISTRICTS
        //
        // OSRM will calculate the actual road route for
        // combinations that are not explicitly listed above.
        // =====================================================

        City sourceCity =
                createCity(source);

        City destinationCity =
                createCity(destination);

        List<City> fallbackRoute =
                new ArrayList<>(
                        Arrays.asList(
                                sourceCity,
                                destinationCity
                        )
                );

        RouteResult result =
                new RouteResult(
                        fallbackRoute,
                        0
                );

        addExtraInformation(
                result,
                destination,
                vehicleType
        );

        return result;
    }


    // =========================================================
    // TWO CITY ROUTE
    // =========================================================

    private RouteResult createRoute(
            String city1,
            String city2,
            int distance,
            String vehicleType) {

        List<City> route =
                new ArrayList<>();

        route.add(createCity(city1));
        route.add(createCity(city2));

        RouteResult result =
                new RouteResult(
                        route,
                        distance
                );

        addExtraInformation(
                result,
                city2,
                vehicleType
        );

        return result;
    }


    // =========================================================
    // THREE CITY ROUTE
    // =========================================================

    private RouteResult createRoute(
            String city1,
            String city2,
            String city3,
            int distance,
            String vehicleType) {

        List<City> route =
                new ArrayList<>();

        route.add(createCity(city1));
        route.add(createCity(city2));
        route.add(createCity(city3));

        RouteResult result =
                new RouteResult(
                        route,
                        distance
                );

        addExtraInformation(
                result,
                city3,
                vehicleType
        );

        return result;
    }


    // =========================================================
    // FOUR CITY ROUTE
    // =========================================================

    private RouteResult createRoute(
            String city1,
            String city2,
            String city3,
            String city4,
            int distance,
            String vehicleType) {

        List<City> route =
                new ArrayList<>();

        route.add(createCity(city1));
        route.add(createCity(city2));
        route.add(createCity(city3));
        route.add(createCity(city4));

        RouteResult result =
                new RouteResult(
                        route,
                        distance
                );

        addExtraInformation(
                result,
                city4,
                vehicleType
        );

        return result;
    }


    // =========================================================
    // FIVE CITY ROUTE
    // =========================================================

    private RouteResult createRoute(
            String city1,
            String city2,
            String city3,
            String city4,
            String city5,
            int distance,
            String vehicleType) {

        List<City> route =
                new ArrayList<>();

        route.add(createCity(city1));
        route.add(createCity(city2));
        route.add(createCity(city3));
        route.add(createCity(city4));
        route.add(createCity(city5));

        RouteResult result =
                new RouteResult(
                        route,
                        distance
                );

        addExtraInformation(
                result,
                city5,
                vehicleType
        );

        return result;
    }


    // =========================================================
    // EXTRA INFORMATION
    // =========================================================

    private void addExtraInformation(
            RouteResult result,
            String destination,
            String vehicleType) {

        result.setVehicleType(vehicleType);


        // =====================================================
        // ACTUAL ROAD ROUTE
        // =====================================================

        List<List<Double>> roadCoordinates =
                getActualRoadCoordinates(
                        result.getRoute()
                );

        if (roadCoordinates == null ||
                roadCoordinates.size() < 2) {

            System.out.println(
                    "OSRM route unavailable."
            );

            System.out.println(
                    "Using city coordinate fallback."
            );

            roadCoordinates =
                    getCityRoadCoordinates(
                            result.getRoute()
                    );
        }

        result.setRoadCoordinates(
                roadCoordinates
        );


        System.out.println(
                "=========================================="
        );

        System.out.println(
                "ROAD ROUTE INFORMATION"
        );

        System.out.println(
                "Road coordinate count: "
                        + roadCoordinates.size()
        );

        System.out.println(
                "=========================================="
        );


        // =====================================================
        // FUEL PREDICTION
        // =====================================================

        try {

            FuelPrediction fuelPrediction =
                    fuelService.calculateFuelCost(
                            result.getTotalDistance(),
                            vehicleType
                    );

            if (fuelPrediction != null) {

                result.setFuelPrediction(
                        fuelPrediction
                );

                result.setMileage(
                        fuelPrediction.getMileage()
                );

                result.setFuelRequired(
                        fuelPrediction.getFuelRequired()
                );

                result.setFuelCost(
                        fuelPrediction.getTotalFuelCost()
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Fuel prediction error: "
                            + e.getMessage()
            );
        }


        // =====================================================
        // TOLL PREDICTION
        // =====================================================

        try {

            String sourceCity = null;

            if (result.getRoute() != null &&
                    !result.getRoute().isEmpty()) {

                City firstCity =
                        result.getRoute().get(0);

                if (firstCity != null) {

                    sourceCity =
                            firstCity.getName();
                }
            }

            if (sourceCity != null &&
                    destination != null) {

                TollPrediction tollPrediction =
                        tollService.calculateTollCost(
                                sourceCity,
                                destination,
                                vehicleType
                        );

                if (tollPrediction != null) {

                    result.setTollPrediction(
                            tollPrediction
                    );

                    result.setTollCount(
                            tollPrediction.getTollCount()
                    );

                    result.setTollCost(
                            tollPrediction.getTotalTollCost()
                    );

                    System.out.println(
                            "=========================================="
                    );

                    System.out.println(
                            "TOLL PREDICTION"
                    );

                    System.out.println(
                            "Source: "
                                    + sourceCity
                    );

                    System.out.println(
                            "Destination: "
                                    + destination
                    );

                    System.out.println(
                            "Vehicle: "
                                    + vehicleType
                    );

                    System.out.println(
                            "Toll Count: "
                                    + tollPrediction.getTollCount()
                    );

                    System.out.println(
                            "Toll Cost: ₹"
                                    + tollPrediction.getTotalTollCost()
                    );

                    System.out.println(
                            "=========================================="
                    );
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "Toll prediction error: "
                            + e.getMessage()
            );
        }


        // =====================================================
        // WEATHER
        // =====================================================

        try {

            double[] coordinates =
                    getCityCoordinates(
                            destination
                    );

            if (coordinates != null) {

                WeatherData weather =
                        weatherService.getWeather(
                                coordinates[0],
                                coordinates[1]
                        );

                if (weather != null) {

                    result.setWeather(
                            weather
                    );
                }
            }

        } catch (Exception e) {

            System.out.println(
                    "Weather error: "
                            + e.getMessage()
            );
        }


        // =====================================================
        // CURRENT TIME
        // =====================================================

        try {

            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern(
                            "dd-MM-yyyy HH:mm:ss"
                    );

            result.setCurrentTime(
                    LocalDateTime.now()
                            .format(formatter)
            );

        } catch (Exception e) {

            System.out.println(
                    "Time error: "
                            + e.getMessage()
            );
        }


        // =====================================================
        // TRAFFIC
        // =====================================================

        TrafficPrediction traffic = null;

        try {

            traffic =
                    trafficService.predictTraffic();

            if (traffic != null) {

                result.setTrafficPrediction(
                        traffic
                );

                System.out.println(
                        "Traffic Prediction: "
                                + traffic.getTrafficLevel()
                );

                System.out.println(
                        "Traffic Percentage: "
                                + traffic.getTrafficPercentage()
                );

                System.out.println(
                        "Speed Multiplier: "
                                + traffic.getSpeedMultiplier()
                );
            }

        } catch (Exception e) {

            System.out.println(
                    "Traffic prediction error: "
                            + e.getMessage()
            );
        }


        // =====================================================
        // NORMAL SPEED
        // =====================================================

        double averageSpeed;

        if ("Bike".equalsIgnoreCase(vehicleType)) {

            averageSpeed = 50.0;

        } else if ("Car".equalsIgnoreCase(vehicleType)) {

            averageSpeed = 60.0;

        } else if ("Diesel Car".equalsIgnoreCase(vehicleType)) {

            averageSpeed = 60.0;

        } else {

            averageSpeed = 50.0;
        }


        // =====================================================
        // TRAFFIC SPEED MULTIPLIER
        // =====================================================

        double speedMultiplier = 1.0;

        if (traffic != null) {

            speedMultiplier =
                    traffic.getSpeedMultiplier();

            if (speedMultiplier <= 0) {

                speedMultiplier = 1.0;
            }
        }


        double trafficAdjustedSpeed =
                averageSpeed *
                        speedMultiplier;

        System.out.println(
                "Normal Speed: "
                        + averageSpeed
        );

        System.out.println(
                "Traffic Multiplier: "
                        + speedMultiplier
        );

        System.out.println(
                "Traffic Adjusted Speed: "
                        + trafficAdjustedSpeed
        );


        // =====================================================
        // TRAVEL TIME
        // =====================================================

        if (trafficAdjustedSpeed > 0 &&
                result.getTotalDistance() > 0) {

            double estimatedTime =
                    result.getTotalDistance()
                            / trafficAdjustedSpeed;

            estimatedTime =
                    Math.round(
                            estimatedTime * 100.0
                    ) / 100.0;

            result.setEstimatedTimeHours(
                    estimatedTime
            );

        } else {

            result.setEstimatedTimeHours(
                    0
            );
        }
    }


    // =========================================================
    // GET ACTUAL ROAD COORDINATES FROM OSRM
    // =========================================================

    private List<List<Double>> getActualRoadCoordinates(
            List<City> route) {

        List<List<Double>> coordinates =
                new ArrayList<>();

        if (route == null ||
                route.size() < 2) {

            return coordinates;
        }

        try {

            StringBuilder coordinateString =
                    new StringBuilder();

            for (City city : route) {

                if (city == null ||
                        city.getName() == null) {

                    continue;
                }

                double[] cityCoordinates =
                        getCityCoordinates(
                                city.getName()
                        );

                if (cityCoordinates == null) {

                    System.out.println(
                            "Coordinates not found for: "
                                    + city.getName()
                    );

                    continue;
                }

                double latitude =
                        cityCoordinates[0];

                double longitude =
                        cityCoordinates[1];


                // OSRM requires longitude,latitude

                if (coordinateString.length() > 0) {

                    coordinateString.append(";");
                }

                coordinateString.append(
                        longitude
                );

                coordinateString.append(",");

                coordinateString.append(
                        latitude
                );
            }


            if (coordinateString.length() == 0) {

                return coordinates;
            }


            String url =
                    OSRM_URL
                            + coordinateString
                            + "?overview=full"
                            + "&geometries=geojson"
                            + "&steps=false";


            System.out.println(
                    "=========================================="
            );

            System.out.println(
                    "REQUESTING ACTUAL ROAD ROUTE"
            );

            System.out.println(
                    "OSRM URL:"
            );

            System.out.println(
                    url
            );


            String response =
                    restTemplate.getForObject(
                            url,
                            String.class
                    );


            if (response == null ||
                    response.isBlank()) {

                System.out.println(
                        "OSRM returned empty response."
                );

                return coordinates;
            }


            JsonNode root =
                    objectMapper.readTree(
                            response
                    );


            String code =
                    root.path("code")
                            .asText();


            System.out.println(
                    "OSRM response code: "
                            + code
            );


            if (!"Ok".equalsIgnoreCase(code)) {

                System.out.println(
                        "OSRM route failed."
                );

                return coordinates;
            }


            JsonNode routes =
                    root.path("routes");


            if (!routes.isArray() ||
                    routes.isEmpty()) {

                System.out.println(
                        "OSRM returned no routes."
                );

                return coordinates;
            }


            JsonNode firstRoute =
                    routes.get(0);


            // =================================================
            // GET ACTUAL DISTANCE
            // =================================================

            if (firstRoute.has("distance")) {

                double distanceMeters =
                        firstRoute
                                .path("distance")
                                .asDouble();

                double distanceKm =
                        distanceMeters / 1000.0;

                System.out.println(
                        "OSRM actual distance: "
                                + distanceKm
                                + " km"
                );

                /*
                 * For routes which use OSRM fallback,
                 * totalDistance may originally be zero.
                 *
                 * RouteResult does not expose a generic
                 * setter in this version, so the distance
                 * is displayed in the console.
                 */
            }


            JsonNode geometry =
                    firstRoute.path(
                            "geometry"
                    );


            JsonNode geometryCoordinates =
                    geometry.path(
                            "coordinates"
                    );


            if (!geometryCoordinates.isArray()) {

                System.out.println(
                        "OSRM geometry is missing."
                );

                return coordinates;
            }


            // =================================================
            // GEOJSON -> LEAFLET
            // =================================================

            for (JsonNode point :
                    geometryCoordinates) {

                if (!point.isArray() ||
                        point.size() < 2) {

                    continue;
                }

                double longitude =
                        point.get(0)
                                .asDouble();

                double latitude =
                        point.get(1)
                                .asDouble();

                coordinates.add(
                        Arrays.asList(
                                latitude,
                                longitude
                        )
                );
            }


            System.out.println(
                    "Actual road points received: "
                            + coordinates.size()
            );

            System.out.println(
                    "=========================================="
            );

        } catch (Exception e) {

            System.out.println(
                    "=========================================="
            );

            System.out.println(
                    "OSRM ROUTING ERROR"
            );

            System.out.println(
                    e.getMessage()
            );

            System.out.println(
                    "=========================================="
            );
        }

        return coordinates;
    }


    // =========================================================
    // FALLBACK CITY COORDINATES
    // =========================================================

    private List<List<Double>> getCityRoadCoordinates(
            List<City> route) {

        List<List<Double>> coordinates =
                new ArrayList<>();

        if (route == null) {

            return coordinates;
        }

        for (City city : route) {

            if (city == null ||
                    city.getName() == null) {

                continue;
            }

            double[] cityCoordinates =
                    getCityCoordinates(
                            city.getName()
                    );

            if (cityCoordinates != null) {

                coordinates.add(
                        Arrays.asList(
                                cityCoordinates[0],
                                cityCoordinates[1]
                        )
                );
            }
        }

        return coordinates;
    }


    // =========================================================
    // ALL 38 TAMIL NADU DISTRICT COORDINATES
    // =========================================================

    private double[] getCityCoordinates(
            String city) {

        if (city == null) {

            return null;
        }

        switch (
                city.trim()
                        .toLowerCase()
        ) {

            case "ariyalur":

                return new double[]{
                        11.1401,
                        79.0785
                };


            case "chengalpattu":

                return new double[]{
                        12.6819,
                        79.9888
                };


            case "chennai":

                return new double[]{
                        13.0827,
                        80.2707
                };


            case "coimbatore":

                return new double[]{
                        11.0168,
                        76.9558
                };


            case "cuddalore":

                return new double[]{
                        11.7480,
                        79.7714
                };


            case "dharmapuri":

                return new double[]{
                        12.1270,
                        78.1579
                };


            case "dindigul":

                return new double[]{
                        10.3624,
                        77.9695
                };


            case "erode":

                return new double[]{
                        11.3410,
                        77.7172
                };


            case "kallakurichi":

                return new double[]{
                        11.7401,
                        78.9597
                };


            case "kancheepuram":

            case "kanchipuram":

                return new double[]{
                        12.8342,
                        79.7036
                };


            case "karur":

                return new double[]{
                        10.9601,
                        78.0766
                };


            case "krishnagiri":

                return new double[]{
                        12.5186,
                        78.2137
                };


            case "madurai":

                return new double[]{
                        9.9252,
                        78.1198
                };


            case "mayiladuthurai":

                return new double[]{
                        11.1018,
                        79.6524
                };


            case "nagapattinam":

                return new double[]{
                        10.7672,
                        79.8449
                };


            case "kanniyakumari":

            case "kanyakumari":

                return new double[]{
                        8.0883,
                        77.5385
                };


            case "namakkal":

                return new double[]{
                        11.2194,
                        78.1677
                };


            case "perambalur":

                return new double[]{
                        11.2320,
                        78.8801
                };


            case "pudukottai":

            case "pudukkottai":

                return new double[]{
                        10.3797,
                        78.8208
                };


            case "ramanathapuram":

                return new double[]{
                        9.3639,
                        78.8395
                };


            case "ranipet":

                return new double[]{
                        12.9249,
                        79.3333
                };


            case "salem":

                return new double[]{
                        11.6643,
                        78.1460
                };


            case "sivaganga":

                return new double[]{
                        9.8433,
                        78.4809
                };


            case "tenkasi":

                return new double[]{
                        8.9590,
                        77.3152
                };


            case "thanjavur":

                return new double[]{
                        10.7870,
                        79.1378
                };


            case "theni":

                return new double[]{
                        10.0104,
                        77.4768
                };


            case "thoothukudi":

            case "tuticorin":

                return new double[]{
                        8.7642,
                        78.1348
                };


            case "tiruchirappalli":

            case "trichy":

                return new double[]{
                        10.7905,
                        78.7047
                };


            case "tirunelveli":

                return new double[]{
                        8.7139,
                        77.7567
                };


            case "tirupathur":

                return new double[]{
                        12.4966,
                        78.5690
                };


            case "tiruppur":

                return new double[]{
                        11.1085,
                        77.3411
                };


            case "tiruvallur":

                return new double[]{
                        13.1437,
                        79.9080
                };


            case "tiruvannamalai":

                return new double[]{
                        12.2253,
                        79.0747
                };


            case "the nilgiris":

            case "nilgiris":

            case "ooty":

                return new double[]{
                        11.4102,
                        76.6950
                };


            case "vellore":

                return new double[]{
                        12.9165,
                        79.1325
                };


            case "viluppuram":

            case "villupuram":

                return new double[]{
                        11.9401,
                        79.4861
                };


            case "virudhunagar":

                return new double[]{
                        9.5851,
                        77.9579
                };


            case "thiruvarur":

                return new double[]{
                        10.7661,
                        79.6360
                };


            default:

                return null;
        }
    }


    // =========================================================
    // CREATE CITY FOR ALL 38 DISTRICTS
    // =========================================================

    private City createCity(
            String name) {

        if (name == null ||
                name.isBlank()) {

            return new City(
                    "Unknown",
                    0
            );
        }


        switch (
                name.trim()
                        .toLowerCase()
        ) {

            case "ariyalur":

                return new City(
                        "Ariyalur",
                        0
                );


            case "chengalpattu":

                return new City(
                        "Chengalpattu",
                        0
                );


            case "chennai":

                return new City(
                        "Chennai",
                        0
                );


            case "coimbatore":

                return new City(
                        "Coimbatore",
                        0
                );


            case "cuddalore":

                return new City(
                        "Cuddalore",
                        0
                );


            case "dharmapuri":

                return new City(
                        "Dharmapuri",
                        0
                );


            case "dindigul":

                return new City(
                        "Dindigul",
                        0
                );


            case "erode":

                return new City(
                        "Erode",
                        0
                );


            case "kallakurichi":

                return new City(
                        "Kallakurichi",
                        0
                );


            case "kancheepuram":

            case "kanchipuram":

                return new City(
                        "Kancheepuram",
                        0
                );


            case "karur":

                return new City(
                        "Karur",
                        0
                );


            case "krishnagiri":

                return new City(
                        "Krishnagiri",
                        0
                );


            case "madurai":

                return new City(
                        "Madurai",
                        0
                );


            case "mayiladuthurai":

                return new City(
                        "Mayiladuthurai",
                        0
                );


            case "nagapattinam":

                return new City(
                        "Nagapattinam",
                        0
                );


            case "kanniyakumari":

            case "kanyakumari":

                return new City(
                        "Kanniyakumari",
                        0
                );


            case "namakkal":

                return new City(
                        "Namakkal",
                        0
                );


            case "perambalur":

                return new City(
                        "Perambalur",
                        0
                );


            case "pudukottai":

            case "pudukkottai":

                return new City(
                        "Pudukottai",
                        0
                );


            case "ramanathapuram":

                return new City(
                        "Ramanathapuram",
                        0
                );


            case "ranipet":

                return new City(
                        "Ranipet",
                        0
                );


            case "salem":

                return new City(
                        "Salem",
                        0
                );


            case "sivaganga":

                return new City(
                        "Sivaganga",
                        0
                );


            case "tenkasi":

                return new City(
                        "Tenkasi",
                        0
                );


            case "thanjavur":

                return new City(
                        "Thanjavur",
                        0
                );


            case "theni":

                return new City(
                        "Theni",
                        0
                );


            case "thoothukudi":

            case "tuticorin":

                return new City(
                        "Thoothukudi",
                        0
                );


            case "tiruchirappalli":

            case "trichy":

                return new City(
                        "Trichy",
                        0
                );


            case "tirunelveli":

                return new City(
                        "Tirunelveli",
                        0
                );


            case "tirupathur":

                return new City(
                        "Tirupathur",
                        0
                );


            case "tiruppur":

                return new City(
                        "Tiruppur",
                        0
                );


            case "tiruvallur":

                return new City(
                        "Tiruvallur",
                        0
                );


            case "tiruvannamalai":

                return new City(
                        "Tiruvannamalai",
                        0
                );


            case "the nilgiris":

            case "nilgiris":

            case "ooty":

                return new City(
                        "The Nilgiris",
                        0
                );


            case "vellore":

                return new City(
                        "Vellore",
                        0
                );


            case "viluppuram":

            case "villupuram":

                return new City(
                        "Viluppuram",
                        0
                );


            case "virudhunagar":

                return new City(
                        "Virudhunagar",
                        0
                );


            case "thiruvarur":

                return new City(
                        "Thiruvarur",
                        0
                );


            default:

                return new City(
                        name,
                        0
                );
        }
    }
}