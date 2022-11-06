package com.altimetrik.slidingwindow;

import java.util.*;

class MinimumWindowSubstring {
  public static String findSubstring(String str, String pattern) {
    // TODO: Write your code here
     Map<Character,Integer> paternFreq = new HashMap<>();
    for(int paternPos = 0;paternPos<pattern.length();paternPos++){
         char paternChar = pattern.charAt(paternPos);
         paternFreq.put(paternChar, paternFreq.getOrDefault(paternChar, 0)+1);
    }
    int windowStart = 0;
    int matched = 0;
    int minLen = Integer.MAX_VALUE;
    int startIndex = 0;
    
    for(int windowEnd = 0;windowEnd<str.length();windowEnd++){
      char rightChar = str.charAt(windowEnd);
        if(paternFreq.containsKey(rightChar)){
           paternFreq.put(rightChar, paternFreq.get(rightChar)-1);
                if(paternFreq.get(rightChar) >= 0)
                   matched++;
           
        }
        while(matched == pattern.length() ){
          if( windowEnd - windowStart + 1 < minLen ){
          startIndex = windowStart ;
           minLen = windowEnd - windowStart + 1;
          }
          char leftChar = str.charAt(windowStart);
           if(paternFreq.containsKey(leftChar) ){
             if(paternFreq.get(leftChar) == 0)
                  matched--;
           
            paternFreq.put(leftChar, paternFreq.get(leftChar)+1);
           }
           
          windowStart++;
        }
    }
    return minLen == Integer.MAX_VALUE ? "" : str.substring(startIndex , startIndex + minLen) ;
  }
}
