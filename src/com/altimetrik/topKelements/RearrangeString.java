package com.altimetrik.topKelements;

import java.util.*;

class RearrangeString {

  public static String rearrangeString(String str) {
    // TODO: Write your code here
    PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((n1,n2)->n2.getValue()-n1.getValue());
    Map<Character,Integer> freqMap = new HashMap<>();
    int n = str.length();
    for(int i=0;i<n;i++){
        char ch = str.charAt(i);
        freqMap.put(ch,freqMap.getOrDefault(ch,0) + 1);
    }

    // add all characters to the max heap
    maxHeap.addAll(freqMap.entrySet());
    /*for(Map.Entry<Character,Integer> entry : freqMap.entrySet()){
      maxHeap.add(entry);
    }*/
    StringBuilder result = new StringBuilder("");
    Map.Entry<Character, Integer> previousEntry = null;
    while(!maxHeap.isEmpty()){
      Map.Entry<Character,Integer> entry = maxHeap.poll();

      if(previousEntry != null && previousEntry.getValue() > 0)
        maxHeap.offer(previousEntry);

      result.append(entry.getKey());
      entry.setValue(entry.getValue() - 1);
       
      previousEntry = entry;
    }
    return result.toString().length() == str.length() ?result.toString() : "";
  }

  public static void main(String[] args) {
    System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aappp"));
    System.out.println("Rearranged string: " + RearrangeString.rearrangeString("Programming"));
    System.out.println("Rearranged string: " + RearrangeString.rearrangeString("aapa"));
  }
}
