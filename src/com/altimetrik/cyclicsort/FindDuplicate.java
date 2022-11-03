package com.altimetrik.cyclicsort;

class FindDuplicate {

  public static int findNumber(int[] nums) {
    // TODO: Write your code here

    int i=0;
    while(i < nums.length){
      int j = nums[i] - 1;
      if(nums[i] != nums[j]){
        swap(nums,i,j);
      }else{
        i++;
      }
    }

    for(int k=0;k<nums.length;k++){
        if(nums[k] != k+1)
          return nums[k];
    }
    return -1;
  }

  public static void swap(int[] arr,int i,int j){
      int tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
  }

  public static void main(String[] args) {
    System.out.println(FindDuplicate.findNumber(new int[]{2, 1, 3, 3, 5, 4}));
  }
}
