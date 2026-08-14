package com.smartrouteai.util;

import com.smartrouteai.graph.City;
import com.smartrouteai.graph.Graph;

public class CityData {

    public static Graph createGraph() {

        Graph graph = new Graph();

        // Create Cities (Heuristic values toward Madurai)
        City chennai = new City("Chennai", 460);
        City vellore = new City("Vellore", 350);
        City salem = new City("Salem", 210);
        City coimbatore = new City("Coimbatore", 250);
        City madurai = new City("Madurai", 0);

        // Add Cities
        graph.addCity(chennai);
        graph.addCity(vellore);
        graph.addCity(salem);
        graph.addCity(coimbatore);
        graph.addCity(madurai);

        // Connect Cities
        graph.addRoad(chennai, vellore, 140);
        graph.addRoad(vellore, salem, 180);
        graph.addRoad(salem, coimbatore, 170);
        graph.addRoad(salem, madurai, 210);
        graph.addRoad(chennai, madurai, 460);

        return graph;
    }
}
