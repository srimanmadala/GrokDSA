package com.altimetrik.graphs;

import java.util.ArrayList;
import java.util.List;

public class GraphUtils {

    public static List<List<Integer>> getCyclicUndirectedGraph() {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int n =  6;
        for(int i=0;i<n;i++) {
            adjacencyList.add(new ArrayList<>());
        }
        addEdge(adjacencyList,0,1);

        addEdge(adjacencyList,1,0);
        addEdge(adjacencyList,1,2);
        addEdge(adjacencyList,1,3);

        addEdge(adjacencyList,2,1);
        addEdge(adjacencyList,2,3);
        addEdge(adjacencyList,2,4);

        addEdge(adjacencyList,3,1);
        addEdge(adjacencyList,3,2);


        addEdge(adjacencyList,4,2);
        addEdge(adjacencyList,4,5);

        addEdge(adjacencyList,5,4);

        return adjacencyList;
    }

    public static List<List<Integer>> getACyclicUndirectedGraph() {
        List<List<Integer>> adjacencyList = new ArrayList<>();
        int n =  6;
        for(int i=0;i<n;i++) {
            adjacencyList.add(new ArrayList<>());
        }
        addEdge(adjacencyList,0,1);

        addEdge(adjacencyList,1,0);
        addEdge(adjacencyList,1,2);

        addEdge(adjacencyList,2,1);
        addEdge(adjacencyList,2,3);
        addEdge(adjacencyList,2,4);

        addEdge(adjacencyList,4,2);
        addEdge(adjacencyList,4,5);

        addEdge(adjacencyList,5,4);
        addEdge(adjacencyList,3,2);

        return adjacencyList;
    }

    public static void addEdge(List<List<Integer>> adjacencyList,int index, int value) {
        adjacencyList.get(index).add(value);
    }

    public static List<WeightedDirectedGraph> getDirectedWeightedGraph() {
        List<WeightedDirectedGraph> weightedDirectedGraphs = new ArrayList<>();
        weightedDirectedGraphs.add(new WeightedDirectedGraph(0,1,4));
        weightedDirectedGraphs.add(new WeightedDirectedGraph(0,2,1));
        weightedDirectedGraphs.add(new WeightedDirectedGraph(2,1,2));
        weightedDirectedGraphs.add(new WeightedDirectedGraph(2,3,5));
        weightedDirectedGraphs.add(new WeightedDirectedGraph(1,3,1));
        weightedDirectedGraphs.add(new WeightedDirectedGraph(3,4,3));

        return weightedDirectedGraphs;
    }
}
