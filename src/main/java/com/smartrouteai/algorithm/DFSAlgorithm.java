package com.smartrouteai.algorithm;

import com.smartrouteai.graph.City;
import com.smartrouteai.graph.Edge;
import com.smartrouteai.graph.Graph;
import com.smartrouteai.model.RouteResult;

import java.util.*;

public class DFSAlgorithm implements SearchAlgorithm {

    @Override
    public RouteResult findRoute(Graph graph, City source, City destination) {

        Stack<City> stack = new Stack<>();
        Set<City> visited = new HashSet<>();
        Map<City, City> previous = new HashMap<>();

        stack.push(source);

        while (!stack.isEmpty()) {

            City current = stack.pop();

            if (!visited.contains(current)) {

                visited.add(current);

                if (current.equals(destination)) {
                    break;
                }

                for (Edge edge : graph.getNeighbors(current)) {

                    City next = edge.getDestination();

                    if (!visited.contains(next)) {
                        previous.put(next, current);
                        stack.push(next);
                    }
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