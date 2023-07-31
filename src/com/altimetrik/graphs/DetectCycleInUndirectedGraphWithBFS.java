package com.altimetrik.graphs;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class DetectCycleInUndirectedGraphWithBFS {

    public static void main(String[] args) {

        List<List<Integer>> adjacencyList = GraphUtils.getCyclicUndirectedGraph();
        //List<List<Integer>> adjacencyList = GraphUtils.getACyclicUndirectedGraph();
        int v = adjacencyList.size();

        boolean isCycle = bfs(adjacencyList, v);
        if (isCycle) {
            System.out.println("Cycle exists");
            return;
        }
        System.out.println("Cycle Do Not Exists..");
    }

    private static boolean bfs(List<List<Integer>> adjacencyList, int v) {
        Queue<Integer> queue = new LinkedList<>();
        int[] parents = new int[v + 1];
        boolean visited[] = new boolean[v];
        queue.add(0);
        visited[0] = true;

        while (!queue.isEmpty()) {
            int parent = queue.poll();
            List<Integer> neighbours = adjacencyList.get(parent);
            for (int i = 0; i < neighbours.size(); i++) {
                int neighbourIndex = neighbours.get(i);
                if (visited[neighbourIndex] == false) {
                    queue.add(neighbourIndex);
                    visited[neighbourIndex] = true;
                    parents[neighbourIndex] = parent;
                } else if (parents[parent] != neighbourIndex) {
                    return true;
                }
            }
        }

        return false;
    }

}
