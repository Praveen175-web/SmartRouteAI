package com.smartrouteai.osrm;

import java.util.List;

public class OsrmResponse {

    private List<Route> routes;

    public List<Route> getRoutes() {
        return routes;
    }

    public void setRoutes(List<Route> routes) {
        this.routes = routes;
    }

    public static class Route {

        private double distance;
        private double duration;
        private Geometry geometry;

        public double getDistance() {
            return distance;
        }

        public void setDistance(double distance) {
            this.distance = distance;
        }

        public double getDuration() {
            return duration;
        }

        public void setDuration(double duration) {
            this.duration = duration;
        }

        public Geometry getGeometry() {
            return geometry;
        }

        public void setGeometry(Geometry geometry) {
            this.geometry = geometry;
        }
    }

    public static class Geometry {

        private List<List<Double>> coordinates;

        public List<List<Double>> getCoordinates() {
            return coordinates;
        }

        public void setCoordinates(
                List<List<Double>> coordinates) {

            this.coordinates = coordinates;
        }
    }
}