package com.altimetrik.cyclicsort;

class MissingNumber {

  public static int findMissingNumber(int[] nums) {
    // TODO: Write your code here
    int j=0;
    while(j < nums.length){
       int i = nums[j] - 1;
       if(i >= 0 && nums[i] != nums[j] )
         swap(nums,i,j);
         else
           j++;
    }

    for(int k=0;k<nums.length;k++){

      if(nums[k] != k+1){
        return k+1;
      }

    }
    return -1;
  }

  public static void swap(int[] nums, int i, int j){
      int tmp = nums[j];
      nums[j] = nums[i];
      nums[i] = tmp;
  }


    public static void main(String[] args) {
      System.out.println(MissingNumber.findMissingNumber(new int[]{8, 3, 5, 2, 4, 6, 0, 1}));
        System.out.println(MissingNumber.findMissingNumber(new int[]{4, 0, 3, 1}));
    }
}
