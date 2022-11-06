package com.altimetrik.slidingwindow;

import java.util.*;

class MaxFruitCountOf2Types {
  public static int findLength(char[] arr) {
    // TODO: Write your code here
    int windowStart = 0;
    int maximumFruits = Integer.MIN_VALUE;
    //int windowEnd = 0;
    Map<Character,Integer> basket = new HashMap<>();
    for(int windowEnd = 0;windowEnd < arr.length;windowEnd++){
        basket.put(arr[windowEnd],basket.getOrDefault(arr[windowEnd],0)+1);
        int basketSize = basket.keySet().size();
        while(basketSize > 2){
                 basket.put(arr[windowStart],basket.get(arr[windowStart])-1);
                //Integer FruitsCount = basket.getOrDefault(arr[windowStart],0) - 1;
                if( basket.get(arr[windowStart]) == 0){
                  basket.remove(arr[windowStart]);
                  basketSize--;
                }
                windowStart++;
        }
        maximumFruits = Math.max(maximumFruits,windowEnd - windowStart + 1);
    }
    return maximumFruits;
  }
}
