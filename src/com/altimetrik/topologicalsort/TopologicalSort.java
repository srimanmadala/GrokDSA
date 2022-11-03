package com.altimetrik.topologicalsort;

import java.util.*;
import java.util.stream.Collectors;

class TopologicalSort {
  public static List<Integer> sort(int vertices, int[][] edges) {
    List<Integer> sortedOrder = new ArrayList<>();
    // TODO: Write your code here
    if(vertices <= 0)
      return sortedOrder;

    //preparing Adjacency List
    Map<Integer, List<Integer>> adjList = new HashMap<>();
    HashMap<Integer, Integer> inDegree = new HashMap<>(); // count of incoming edges for every vertex
    //int[] indegree = new int[vertices];
    for(int i=0;i<vertices;i++){
      inDegree.put(i,0);
      adjList.put(i,new ArrayList<>());
    }

    //populating adjacency list and its indegrees
    for(int j=0;j<edges.length;j++){
      int source = edges[j][0];
      int edge = edges[j][1];
      System.out.println("source "+source+" edge "+ edge);
      inDegree.put(edge,inDegree.get(edge) + 1 );
      adjList.get(source).add(edge);

    }

    //Add indegree = 0 elements to the queue
    Queue<Integer> topQueue = new LinkedList<>();
    //Queue<Integer> sources = new LinkedList<>();
    for (Map.Entry<Integer, Integer> entry : inDegree.entrySet()) {
      if (entry.getValue() == 0)
        topQueue.add(entry.getKey());
    }


    while(!topQueue.isEmpty()){
      Integer src = topQueue.poll();
      sortedOrder.add(src);
      List<Integer> edgs = adjList.get(src);
      for(Integer eg : edgs){
        int indegreVal = inDegree.get(eg);
        indegreVal = indegreVal - 1;
        inDegree.put(eg,indegreVal); //Forgot this part while practicing..
        if(indegreVal == 0)
          topQueue.add(eg);
      }
    }

    return sortedOrder;
  }

  public static void main(String[] args) {
    List<Integer> result = TopologicalSort.sort(4,
            new int[][] { new int[] { 3, 2 }, new int[] { 3, 0 }, new int[] { 2, 0 }, new int[] { 2, 1 } });
    System.out.println(result);

    result = TopologicalSort.sort(5, new int[][] { new int[] { 4, 2 }, new int[] { 4, 3 }, new int[] { 2, 0 },
            new int[] { 2, 1 }, new int[] { 3, 1 } });
    System.out.println(result);

    result = TopologicalSort.sort(7, new int[][] { new int[] { 6, 4 }, new int[] { 6, 2 }, new int[] { 5, 3 },
            new int[] { 5, 4 }, new int[] { 3, 0 }, new int[] { 3, 1 }, new int[] { 3, 2 }, new int[] { 4, 1 } });
    System.out.println(result);
  }
}