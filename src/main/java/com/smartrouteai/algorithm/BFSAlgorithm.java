package com.smartrouteai.algorithm;

import com.smartrouteai.graph.City;
import com.smartrouteai.graph.Edge;
import com.smartrouteai.graph.Graph;
import com.smartrouteai.model.RouteResult;

import java.util.*;

public class BFSAlgorithm implements SearchAlgorithm{

    public RouteResult findRoute(Graph graph, City source, City destination) {

        Queue<City> queue = new LinkedList<>();
        Set<City> visited = new HashSet<>();
        Map<City, City> previous = new HashMap<>();

        queue.offer(source);
        visited.add(source);

        while (!queue.isEmpty()) {

            City current = queue.poll();

            if (current.equals(destination)) {
                break;
            }

            for (Edge edge : graph.getNeighbors(current)) {

                City next = edge.getDestination();

                if (!visited.contains(next)) {
                    visited.add(next);
                    previous.put(next, current);
                    queue.offer(next);
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

        // Calculate total distance
        int totalDistance = 0;

        for (int i = 0; i < route.size() - 1; i++) {

            City from = route.get(i);
            City to = route.get(i + 1);

            for (Edge edge : graph.getNeighbors(from)) {

                if (edge.getDestination().equals(to)) {
                    totalDistance += edge.getDistance();
                    break;
                }
            }
        }

        return new RouteResult(route, totalDistance);
    }
}
