package com.altimetrik.heap;

import java.util.*;
public class SlidingWindow{
   public static double[] medianSlidingWindow(int[] nums, int k) {
      // Your code will replace this placeholder return statement
     if(nums.length == 0  || k==0 || nums.length == 1) {
        return new double[]{};
     }
     double[] result =  new double[nums.length];
     int resultIndex = 0;

     
      PriorityQueue<Integer> minHeap = new PriorityQueue<>((a,b)->a-b);
      PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a,b)->b-a); 
      int n = nums.length;
      boolean isEven = k%2 == 0;

        for(int i=0;i<k/2;i++) {
           maxHeap.offer(nums[i]);
        }

      for(int i=k/2;i<n;i++) {
           if(nums[i] > maxHeap.peek()){
              minHeap.offer(nums[i]);
              continue;
           }
           maxHeap.add(nums[i]);
        }
        int outgoingIndex = 1;
        int exitIndex = n - k;
        int incomingIndex = k;
      double median = isEven ? (maxHeap.peek() + minHeap.peek()) / 2 : maxHeap.peek();
      result[resultIndex++] = median;

        while(incomingIndex < n)  {
        
        if(nums[incomingIndex] < maxHeap.peek()) {
            maxHeap.offer(nums[incomingIndex]);
        }else{
           minHeap.offer(nums[incomingIndex]);
        }
       if(maxHeap.peek() == nums[outgoingIndex]) {
          maxHeap.poll();
       } else if(minHeap.peek() == nums[outgoingIndex]) {
          minHeap.poll();
       }
        median = isEven ? (maxHeap.peek() + minHeap.peek()) / 2 : maxHeap.peek();
       outgoingIndex++;
       incomingIndex++;
       result[resultIndex++] = median;
       
        }
      return result;
   }
}