package com.altimetrik.graphs;

import java.util.List;

public class DijkstrasShorestestPath {

    public static void main(String[] args) {
        List<WeightedDirectedGraph> weightedGraph = GraphUtils.getDirectedWeightedGraph();
        findShortestPathFrom(0,weightedGraph);
    }

    private static void findShortestPathFrom(int i, List<WeightedDirectedGraph> weightedGraph) {
       /* WeightedDirectedGraph WeightedDirectedGraph = new WeightedDirectedGraph(0,0,
                weightedGraph.get(i).source);*/
    }


}
