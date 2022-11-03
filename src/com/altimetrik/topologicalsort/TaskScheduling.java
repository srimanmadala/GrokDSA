package com.altimetrik.topologicalsort;

import java.util.*;

class TaskScheduling {
  public static boolean isSchedulingPossible(int tasks, int[][] prerequisites) {
    // TODO: Write your code here   
    Map<Integer,List<Integer>> graph = new HashMap<>();
    Map<Integer,Integer> inDegree = new HashMap<>();
    Queue<Integer> queue = new LinkedList<>();
    for(int vertices=0;vertices<tasks;vertices++){
        graph.put(vertices,new ArrayList<>());
        inDegree.put(vertices,0);
    }
    for(int edges =0;edges<prerequisites.length;edges++){
       int parent = prerequisites[edges][0];
       int child = prerequisites[edges][1];
       graph.get(parent).add(child);
      inDegree.put(child,inDegree.getOrDefault(child,0) + 1);
    }

    for(Map.Entry<Integer,Integer> entry : inDegree.entrySet()){
      if(entry.getValue() == 0)
          queue.add(entry.getKey());
    }

   int verticesCount = 0;
   while(!queue.isEmpty()) {
       Integer parent = queue.poll();
       verticesCount++;
       for (Integer child : graph.get(parent)) {
           int inDegreVal = inDegree.get(child);
           inDegreVal = inDegreVal - 1;
           inDegree.put(child, inDegreVal);
           if (inDegreVal == 0)
               queue.add(child);
       }
   }

   if(verticesCount != tasks)
    return false;

    return true;
  }

  public static void main(String[] args) {

    boolean result = TaskScheduling.isSchedulingPossible(3, new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 } });
    System.out.println("Tasks execution possible: " + result);

    /*result = TaskScheduling.isSchedulingPossible(3,
        new int[][] { new int[] { 0, 1 }, new int[] { 1, 2 }, new int[] { 2, 0 } });
    System.out.println("Tasks execution possible: " + result);

    result = TaskScheduling.isSchedulingPossible(6, new int[][] { new int[] { 2, 5 }, new int[] { 0, 5 },
        new int[] { 0, 4 }, new int[] { 1, 4 }, new int[] { 3, 2 }, new int[] { 1, 3 } });
    System.out.println("Tasks execution possible: " + result);*/
  }
}