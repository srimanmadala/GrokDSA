package com.altimetrik.graphs;

import java.util.*;

public class NetworkDelayTime {

    /**
     * n - no of nodes to be visited
     * k - is the starting node from which we have to visit all other nodes
     * @param times
     * @param n
     * @param k
     * @return
     */
    public static int networkDelayTime(int[][] times, int n, int k) {

        //create adjacencyList
        //PriorityQueue - priority on less delay time
        //visited list - to keep track of visited nodes.
        //To start with add (k,0) k - starting node && 0 - time delay taken to travel the signal from k -> k
        //Take the adjacency list of K
        // Add k to the visited list and update the total delay time
        // Repeat this untill PriorityQueue is empty
        Map<Integer, List<int[]>> adjacencyList = new HashMap<>();
        for(int[] arr: times) {
            int source = arr[0] ;
            int destination = arr[1] ;
            int delayTime = arr[2] ;
            adjacencyList.computeIfAbsent(source,key-> new ArrayList<>()).add(new int[]{destination,delayTime});
        }

        for(Map.Entry<Integer, List<int[]>> vertex : adjacencyList.entrySet()){
            System.out.println("source is "+vertex.getKey());
            List<int[]> edges = vertex.getValue();
            for(int[] edge : edges) {
                System.out.print(" destination is "+edge[0]+ " ");
                System.out.print("Time Delay "+edge[1]);
                System.out.println();
            }
            System.out.println("---------------");
        }

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b)->a[1] - b[1]);
        minHeap.offer(new int[]{k,0});
        int totalTimedelay = 0;
        Set<Integer> visited = new HashSet<>();
        while(!minHeap.isEmpty()) {
            int[] source = minHeap.poll();
            if(!visited.contains(source)) {
                visited.add(source[0]);
                List<int[]> edgs = adjacencyList.getOrDefault(source[0],new ArrayList<>());
                    for (int[] edg : edgs) {
                        minHeap.offer(edg);
                    }
                totalTimedelay+=source[1];
            }
        }
        if(visited.size() == n){
            return totalTimedelay;
        }
        return -1;

    }

    public static void main(String[] args) {
        int[][][] times = {
                { {2, 1, 1}, {3, 2, 1}, {3, 4, 2} }
                /*{ {2, 1, 1}, {1, 3, 1}, {3, 4, 2}, {5, 4, 2} },
                { {1, 2, 1}, {2, 3, 1}, {3, 4, 1} },
                { {1, 2, 1}, {2, 3, 1}, {3, 5, 2} },
                { {1, 2, 2} }*/
        };

        /*int[] n = {4, 5, 4, 5, 2};
        int[] k = {3, 1, 1, 1, 2};*/
        int[] n = {4};
        int[] k = {3};

        for (int i = 0; i < times.length; i++) {
            System.out.println((i + 1) + ".\t times = " + Arrays.deepToString(times[i]));
            System.out.println("\t number of nodes 'n' = " + n[i]);
            System.out.println("\t starting node 'k' = " + k[i] + "\n");
            System.out.println("\t Minimum amount of time required = " + networkDelayTime(times[i], n[i], k[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }
}
/*
public static void main(String[] args) {
        int[][][] times = {
            { {2, 1, 1}, {3, 2, 1}, {3, 4, 2} },
            { {2, 1, 1}, {1, 3, 1}, {3, 4, 2}, {5, 4, 2} },
            { {1, 2, 1}, {2, 3, 1}, {3, 4, 1} },
            { {1, 2, 1}, {2, 3, 1}, {3, 5, 2} },
            { {1, 2, 2} }
        };

        int[] n = {4, 5, 4, 5, 2};
        int[] k = {3, 1, 1, 1, 2};

        for (int i = 0; i < times.length; i++) {
            System.out.println((i + 1) + ".\t times = " + Arrays.deepToString(times[i]));
            System.out.println("\t number of nodes 'n' = " + n[i]);
            System.out.println("\t starting node 'k' = " + k[i] + "\n");
            System.out.println("\t Minimum amount of time required = " + networkDelayTime(times[i], n[i], k[i]));
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
 */