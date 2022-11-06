package com.altimetrik.slidingwindow;

import java.util.*;

class LongestSubstringKDistinct {
  public static int findLength(String str, int k) {
    // TODO: Write your code here
    int strLen = str.length();
    if(k >= strLen || strLen < k){
      return strLen;
    }

Map<Character,Integer> charsFreqency = new HashMap<>();
int  maxLength = Integer.MIN_VALUE;
int windowStart = 0;

for(int windowEnd=0;windowEnd<strLen;windowEnd++){
    char rightChar = str.charAt(windowEnd);
    
    charsFreqency.put(rightChar, charsFreqency.getOrDefault(rightChar,0)+1);
    
     
     int mapSize = charsFreqency.keySet().size() ;
     while(mapSize > k){
      char leftChar = str.charAt(windowStart++);
      charsFreqency.put(leftChar, charsFreqency.get(leftChar)-1);
       if(charsFreqency.get(leftChar) == 0){
          charsFreqency.remove(leftChar);
          mapSize--;
       }
      
     }
      maxLength = Math.max(maxLength, windowEnd - windowStart + 1);
}

    return maxLength;
  }
}
