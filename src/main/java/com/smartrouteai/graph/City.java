package com.smartrouteai.graph;

public class City {

    private String name;

    private int heuristic;

    public City() {
    }

    public City(
            String name,
            int heuristic) {

        this.name = name;

        this.heuristic = heuristic;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public int getHeuristic() {

        return heuristic;
    }

    public void setHeuristic(
            int heuristic) {

        this.heuristic = heuristic;
    }

    @Override
    public String toString() {

        return name;
    }

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (!(obj instanceof City)) {
            return false;
        }

        City other = (City) obj;

        return name.equalsIgnoreCase(
                other.name
        );
    }

    @Override
    public int hashCode() {

        return name.toLowerCase()
                .hashCode();
    }
}