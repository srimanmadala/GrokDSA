package com.altimetrik.graphs;

import java.util.List;

public class WeightedDirectedGraph {

    public int source;
    public List<WeightedDirectedGraph> neighbours;
    public int neighbour;
    public int weight;

    public WeightedDirectedGraph(int source,int neighbour, int weight) {
        this.source = source;
        this.neighbour = neighbour;
        this.weight = weight;
    }
}
