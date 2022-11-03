package com.altimetrik.topKelements;

import java.util.*;

class FrequencySort {

  public static String sortCharacterByFrequency(String str) {
    // TODO: Write your code here

     Map<Character,Integer> freqMap = new HashMap<>();
    for(int i=0;i<str.length();i++){
      freqMap.put(str.charAt(i),freqMap.getOrDefault(str.charAt(i),0) + 1);
    }

    PriorityQueue<Map.Entry<Character,Integer>> maxHeap = new PriorityQueue
    <Map.Entry<Character,Integer>>((n1,n2)->n2.getValue() - n1.getValue());
 
    int kval = 0;
    for( Map.Entry<Character,Integer> entry : freqMap.entrySet()){
      maxHeap.add(entry);
    }

    StringBuilder result = new StringBuilder();
    while(!maxHeap.isEmpty()){

       Map.Entry<Character, Integer> entry = maxHeap.poll();
      for (int i = 0; i < entry.getValue(); i++)
        result.append(entry.getKey());
    }
     

    return result.toString();
  }

  public static void main(String[] args) {
    String result = FrequencySort.sortCharacterByFrequency("Programming");
    System.out.println("Here is the given string after sorting characters by frequency: " + result);

    result = FrequencySort.sortCharacterByFrequency("abcbab");
    System.out.println("Here is the given string after sorting characters by frequency: " + result);
  }
}
