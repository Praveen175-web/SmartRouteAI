package com.smartrouteai.algorithm;

import com.smartrouteai.graph.City;
import com.smartrouteai.graph.Graph;
import com.smartrouteai.model.RouteResult;

public interface SearchAlgorithm {

    RouteResult findRoute(Graph graph, City source, City destination);

}
