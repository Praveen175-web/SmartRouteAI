package com.smartrouteai.algorithm;

import com.smartrouteai.graph.City;
import com.smartrouteai.graph.Edge;
import com.smartrouteai.graph.Graph;
import com.smartrouteai.model.RouteResult;

import java.util.*;

public class AStarAlgorithm implements SearchAlgorithm {

    @Override
    public RouteResult findRoute(
            Graph graph,
            City source,
            City destination) {

        Map<City, Integer> gScore = new HashMap<>();
        Map<City, City> previous = new HashMap<>();

        PriorityQueue<City> openSet =
                new PriorityQueue<>(
                        Comparator.comparingInt(
                                city -> gScore.getOrDefault(
                                        city,
                                        Integer.MAX_VALUE
                                ) + city.getHeuristic()
                        )
                );

        gScore.put(source, 0);
        openSet.add(source);

        while (!openSet.isEmpty()) {

            City current = openSet.poll();

            if (current.equals(destination)) {
                break;
            }

            for (Edge edge : graph.getNeighbors(current)) {

                City neighbor = edge.getDestination();

                int tentativeScore =
                        gScore.get(current)
                                + edge.getDistance();

                if (tentativeScore <
                        gScore.getOrDefault(
                                neighbor,
                                Integer.MAX_VALUE)) {

                    previous.put(neighbor, current);

                    gScore.put(
                            neighbor,
                            tentativeScore
                    );

                    openSet.remove(neighbor);
                    openSet.add(neighbor);
                }
            }
        }

        List<City> route = new ArrayList<>();

        City current = destination;

        while (current != null) {

            route.add(current);

            current = previous.get(current);
        }

        Collections.reverse(route);

        int totalDistance =
                gScore.getOrDefault(
                        destination,
                        0
                );

        return new RouteResult(
                route,
                totalDistance
        );
    }
}