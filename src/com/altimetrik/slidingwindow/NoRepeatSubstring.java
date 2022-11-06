package com.altimetrik.slidingwindow;

import java.util.*;

class NoRepeatSubstring {
  public static int findLength(String str) {
    // TODO: Write your code here
    if(str == null || str.length() == 0){
      return -1;
    }
    Map<Character,Integer> charFreqMap = new HashMap<>();
    int windowStart = 0;
    int maxNoRepatingChars = 0;
    
    int strLength = str.length();
    for(int windowEnd = 0;windowEnd < strLength;windowEnd++){
      char rightChar = str.charAt(windowEnd);

      if(charFreqMap.containsKey(rightChar)){
          windowStart = Math.max(windowStart,charFreqMap.get(rightChar) + 1);
      }
      charFreqMap.put(rightChar,windowEnd);
      maxNoRepatingChars = Math.max(maxNoRepatingChars,windowEnd - windowStart + 1 );

       
    }

    return maxNoRepatingChars;
  }
}
