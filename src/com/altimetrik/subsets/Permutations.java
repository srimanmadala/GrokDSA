package com.altimetrik.subsets;

import java.util.*;

class Permutations {

  public static List<List<Integer>> findPermutations(int[] nums) {
    List<List<Integer>> finalresult = new ArrayList<>();
    // TODO: Write your code here
    List<List<Integer>> result = new ArrayList<>();
    //List<Integer> subset = new ArrayList<>();
    result.add(new ArrayList<>());

    for(int i=0;i<nums.length;i++){
      int num = nums[i];
      int n = result.size();
       for(int j=0;j<n;j++){
         System.out.println(":::"+num);
         for(int k = 0;k<=result.get(j).size();k++){
           List<Integer> copy = new ArrayList<>( result.get(j));
           copy.add(k,num);
           System.out.println("::ARR::"+Arrays.toString(copy.toArray()));
         if(copy.size() == nums.length)
              finalresult.add(copy);
         result.add(copy);
         }
         
      }
    }
   
    return finalresult;
  }

  public static void main(String[] args) {
    List<List<Integer>> result = Permutations.findPermutations(new int[] { 1, 3, 5 });
    System.out.print("Here are all the permutations: " + result);
  }
}
