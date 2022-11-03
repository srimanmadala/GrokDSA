package com.altimetrik.topKelements;

import java.util.*;

class TopKFrequentNumbers {

  public static List<Integer> findTopKFrequentNumbers(int[] nums, int k) {
    List<Integer> topNumbers = new ArrayList<>(k);
    Map<Integer,Integer> freqMap = new HashMap<>();
    for(int i=0;i<nums.length;i++){
      freqMap.put(nums[i],freqMap.getOrDefault(nums[i],0) + 1);
    }

    PriorityQueue<Map.Entry<Integer,Integer>> maxHeap = new PriorityQueue
    <Map.Entry<Integer,Integer>>((n1,n2)->n2.getValue() - n1.getValue());
 
    int kval = 0;
    for( Map.Entry<Integer,Integer> entry : freqMap.entrySet()){
      
      if(kval >= k){
       if(!maxHeap.isEmpty() && maxHeap.peek().getValue() < entry.getValue()){
         maxHeap.poll();
         maxHeap.add(entry);
       }else{
         maxHeap.add(entry);
       } 
       
      }
      kval++;
      
    }

    while(!maxHeap.isEmpty())
       topNumbers.add(maxHeap.poll().getKey());
    // TODO: Write your code here
    return topNumbers;
  }

  public static void main(String[] args) {
    List<Integer> result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 1, 3, 5, 12, 11, 12, 11 }, 2);
    System.out.println("Here are the K frequent numbers: " + result);

    result = TopKFrequentNumbers.findTopKFrequentNumbers(new int[] { 5, 12, 11, 3, 11 }, 2);
    System.out.println("Here are the K frequent numbers: " + result);
  }
}
