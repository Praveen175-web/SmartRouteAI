package com.smartrouteai.graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Graph {

    private final List<City> cities;

    private final Map<City, List<Edge>> adjacencyList;

    public Graph() {

        cities = new ArrayList<>();

        adjacencyList = new HashMap<>();
    }

    public void addCity(City city) {

        if (!cities.contains(city)) {

            cities.add(city);

            adjacencyList.put(
                    city,
                    new ArrayList<>()
            );
        }
    }

    public void addRoad(
            City city1,
            City city2,
            int distance) {

        addCity(city1);
        addCity(city2);

        adjacencyList
                .get(city1)
                .add(
                        new Edge(
                                city2,
                                distance
                        )
                );

        adjacencyList
                .get(city2)
                .add(
                        new Edge(
                                city1,
                                distance
                        )
                );
    }

    public City findCity(String name) {

        for (City city : cities) {

            if (city.getName()
                    .equalsIgnoreCase(name)) {

                return city;
            }
        }

        return null;
    }

    public List<City> getCities() {

        return cities;
    }

    public List<Edge> getNeighbors(
            City city) {

        return adjacencyList.getOrDefault(
                city,
                new ArrayList<>()
        );
    }
}
