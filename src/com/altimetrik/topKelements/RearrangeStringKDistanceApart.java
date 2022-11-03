package com.altimetrik.topKelements;

import java.util.*;

class RearrangeStringKDistanceApart {

  public static String reorganizeString(String str, int k) {
    // TODO: Write your code here
    if(k == 1)
    return str;

    Map<Character,Integer> freqMap = new HashMap<>();
    for(int i=0;i<str.length();i++)
        freqMap.put(str.charAt(i),freqMap.getOrDefault(str.charAt(i),0) + 1);

  PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue<>((n1,n2)->n2.getValue() - n1.getValue());
  maxHeap.addAll(freqMap.entrySet());

 StringBuilder result = new StringBuilder();
 Queue<Map.Entry<Character,Integer>> kdistanceQueue = new LinkedList<>();
  while(!maxHeap.isEmpty()){
          Map.Entry<Character,Integer> curentEntry = maxHeap.poll();
          result.append(curentEntry.getKey());
          curentEntry.setValue(curentEntry.getValue() - 1);
          kdistanceQueue.add(curentEntry);
          if(kdistanceQueue.size() == k){
            Map.Entry<Character,Integer> previousEntry  =    kdistanceQueue.poll();
            if(previousEntry.getValue() > 0 ){
                    maxHeap.offer(previousEntry);
            }
          }
    }
    return result.toString().length() != str.length() ? "" : result.toString() ;
  }

  public static void main(String[] args) {
    System.out.println("Reorganized string: " + 
            RearrangeStringKDistanceApart.reorganizeString("mmpp", 2));
    System.out.println("Reorganized string: " + 
            RearrangeStringKDistanceApart.reorganizeString("Programming", 3));
    System.out.println("Reorganized string: " + 
            RearrangeStringKDistanceApart.reorganizeString("aab", 2));
    System.out.println("Reorganized string: " + 
            RearrangeStringKDistanceApart.reorganizeString("aappa", 3));
  }
}
