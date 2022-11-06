package com.altimetrik.slidingwindow;

import java.util.*;

class StringPermutation {
  public static boolean findPermutation(String str, String pattern) {
    // TODO: Write your code here
    if(str == null || pattern == null || str.length() == 0 || pattern.length() == 0
    || pattern.length() > str.length()) {
        return false;
    }
      
      int windowStart=0;
      Map<Character,Integer> characterFreqency = new HashMap<>();
      for(int patternPos=0;patternPos < pattern.length();patternPos++){
        char paternChar = pattern.charAt(patternPos);
          characterFreqency.put(paternChar,characterFreqency.getOrDefault(paternChar,0)+1);
      }
      int matched = 0;
      for(int windowEnd=0;windowEnd < str.length();windowEnd++){
        char rightChar = str.charAt(windowEnd);
              
        if(characterFreqency.containsKey(rightChar)){
          characterFreqency.put(rightChar,characterFreqency.get(rightChar)-1);
          if(characterFreqency.get(rightChar) == 0)
            matched++;
          }

          if(matched ==characterFreqency.size() )
            return true;
          
          //shrinking window condition..
          if(windowEnd >= pattern.length()-1){
            char leftChar = str.charAt(windowStart);
            if(characterFreqency.containsKey(leftChar)){
              Integer lefcharCnt = characterFreqency.get(leftChar);
              if(lefcharCnt == 0){
                matched--;
              }
             characterFreqency.put(leftChar,characterFreqency.get(leftChar)+1);
            }
             windowStart++;  
          }
        
       
        
        }
        return false;
      }
  
}
