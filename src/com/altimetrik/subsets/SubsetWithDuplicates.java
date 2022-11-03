package com.altimetrik.subsets;

import java.util.*;

class SubsetWithDuplicates {


  public static void main(String[] args) {
    ArrayList l = new ArrayList();
    l.add(1);
    l.add(0,3);
    l.add(2,5);
    System.out.println(Arrays.toString(l.toArray()));

  }
  public static List<List<Integer>> findSubsets(int[] nums) {
    List<List<Integer>> subsets = new ArrayList<>();
    // TODO: Write your code here
    Arrays.sort(nums);
    subsets.add(new ArrayList<>());
    int n = subsets.size();
    for(int i=0;i<nums.length;i++) {

      //if(i>0 && nums[i] == nums[i-1])
     /* for (int i = 0; i < n; i++) {

      }*/
    }
    return subsets;
  }

  public static void main1(String[] args) {
    List<List<Integer>> result = SubsetWithDuplicates.findSubsets(new int[] { 1, 3, 3 });
    System.out.println("Here is the list of subsets: " + result);

    result = SubsetWithDuplicates.findSubsets(new int[] { 1, 5, 3, 3 });
    System.out.println("Here is the list of subsets: " + result);
  }
}
