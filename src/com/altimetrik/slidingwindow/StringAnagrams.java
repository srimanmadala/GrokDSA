package com.altimetrik.slidingwindow;

import java.util.*;

class StringAnagrams {
  public static List<Integer> findStringAnagrams(String str, String pattern) {

    List<Integer> resultIndices = new ArrayList<Integer>();
    // TODO: Write your code here
    if(str == null || pattern == null || str.length() == 0 || pattern.length() == 0 ||
      pattern.length() > str.length())
          return resultIndices;

      Map<Character,Integer> charFrequency = new HashMap<>();
       for(int patternPos = 0;patternPos < pattern.length();patternPos++){
        char paternChar  = pattern.charAt(patternPos);
        charFrequency.put(paternChar,charFrequency.getOrDefault(paternChar,0)+1);
      }

     int matched = 0;
     int windowStart = 0;
      for(int windowEnd = 0;windowEnd < str.length();windowEnd++){

        char rightChar = str.charAt(windowEnd);
        if(charFrequency.containsKey(rightChar)){
          charFrequency.put(rightChar,charFrequency.get(rightChar)-1);
          if(charFrequency.get(rightChar) == 0){
            matched++;
          }
        }

        if(matched == charFrequency.size())
          resultIndices.add(windowStart);
        
        if(windowEnd >= pattern.length() - 1){
          char leftChar = str.charAt(windowStart++);
          if(charFrequency.containsKey(leftChar)){
             
              if(charFrequency.get(leftChar) == 0)
                 matched--;

              charFrequency.put(leftChar,charFrequency.get(leftChar)+1);
          }
          
        }

      
      }
      return resultIndices;
  }
}
