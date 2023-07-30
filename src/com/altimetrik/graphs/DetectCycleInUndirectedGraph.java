package com.altimetrik.graphs;

import java.util.List;

public class DetectCycleInUndirectedGraph {

    public static void main(String[] args) {

        //List<List<Integer>> adjacencyList = GraphUtils.getCyclicUndirectedGraph();
        List<List<Integer>> adjacencyList = GraphUtils.getACyclicUndirectedGraph();
        int v = adjacencyList.size();

        boolean isCycle = dfs(adjacencyList, v);
        if (isCycle) {
            System.out.println("Cycle exists");
            return;
        }
        System.out.println("Cycle Do Not Exists..");
    }

    private static boolean dfs(List<List<Integer>> adjacencyList, int v) {

        boolean visited[] = new boolean[v];
        for (int i = 0; i < v; i++) {
            if (visited[i] == false) {
                if (dfsRec(adjacencyList, i, visited, -1) == true) {
                    return true;
                }
            }
        }
        return false;
    }

    private static boolean dfsRec(List<List<Integer>> adjacencyList, int src, boolean[] visited, int parent) {
        visited[src] = true;
        List<Integer> neighbours = adjacencyList.get(src);
        for (int j = 0; j < neighbours.size(); j++) {
            if (visited[neighbours.get(j)] == false) {

                if (dfsRec(adjacencyList, neighbours.get(j), visited, src) == true) {
                    return true;
                }
            } else if (neighbours.get(j) != parent) {
                return true;
            }
        }
        return false;
    }


}
