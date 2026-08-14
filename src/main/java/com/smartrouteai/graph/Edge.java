package com.smartrouteai.graph;

public class Edge {

    private final City destination;

    private final int distance;

    public Edge(
            City destination,
            int distance) {

        this.destination = destination;

        this.distance = distance;
    }

    public City getDestination() {

        return destination;
    }

    public int getDistance() {

        return distance;
    }
}