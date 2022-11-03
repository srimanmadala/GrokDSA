package com.altimetrik.topKelements;

import java.util.*;

class ConnectRopes { //Visit Again

  public static int minimumCostToConnectRopes(int[] ropeLengths) {
    // TODO: Write your code here

    if(ropeLengths.length == 0)
      return -1;

     PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->a-b);
     for(int i=0;i<ropeLengths.length;i++)
      minHeap.add(ropeLengths[i]);
  
      int result = 0, temp = 0;
    while (minHeap.size() > 1) {
      temp = minHeap.poll() + minHeap.poll();
      result += temp;
      minHeap.add(temp);
    }
      
    return result;
  }

  public static void main(String[] args) {
    int result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5 });
    System.out.println("Minimum cost to connect ropes: " + result);
    result = ConnectRopes.minimumCostToConnectRopes(new int[] { 3, 4, 5, 6 });
    System.out.println("Minimum cost to connect ropes: " + result);
    result = ConnectRopes.minimumCostToConnectRopes(new int[] { 1, 3, 11, 5, 2 });
    System.out.println("Minimum cost to connect ropes: " + result);
  }
}
