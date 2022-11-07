package com.altimetrik.subsets;

import java.util.*;

class Subsets {

  public static List<List<Integer>> findSubsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    // TODO: Write your code here
    subsets.add(new ArrayList<>());
    for(Integer num : nums){
      int n = subsets.size();
      for(int i=0;i<n;i++){
        List<Integer> values = new ArrayList<>(subsets.get(i));
        values.add(num);
        subsets.add(values);
      }
    }
    return subsets;
  }

  public static void main(String[] args) {
    List<List<Integer>> result = Subsets.findSubsets(new int[] { 1, 3 });
    System.out.println("Here is the list of subsets: " + result);

    result = Subsets.findSubsets(new int[] { 1, 5, 3 });
    System.out.println("Here is the list of subsets: " + result);
  }
}
