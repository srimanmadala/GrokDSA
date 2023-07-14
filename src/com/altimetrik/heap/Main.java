package com.altimetrik.heap;

import java.util.AbstractMap;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Main{
    public static String reorganizeString(String string1) {
    char[] ch = string1.toCharArray();
        // Write your code here
        HashMap<Character,Integer> frequencyMap = new HashMap<>();
        for(Character c : ch) {
            frequencyMap.put(c,frequencyMap.getOrDefault(c,0) + 1);
        }

        StringBuffer result =  new StringBuffer();
        Map.Entry<Character,Integer> previous = null;
        PriorityQueue<Map.Entry<Character,Integer>> maxHeap =
        new PriorityQueue<>((a,b)->b.getValue() - a.getValue());
       frequencyMap.entrySet().stream().forEach(entry->maxHeap.offer(entry));
       
       while(!maxHeap.isEmpty() ) {

           Map.Entry<Character,Integer> entry = maxHeap.poll();
           Character resultChar = entry.getKey();
           int val = entry.getValue();
           val = val - 1;
           if(result.length() != 0 && result.charAt(result.length() - 1) == resultChar){
               return "";
           }
           result.append(resultChar);
           if(previous != null) {
               maxHeap.offer(previous);
               previous = null;
           }
           if(val != 0) {
               previous = new AbstractMap.SimpleEntry<>(resultChar,val);
           }

       }

       if(previous != null)
           return "";
    
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(reorganizeString("aaaaabbbbbbb"));
    }
}