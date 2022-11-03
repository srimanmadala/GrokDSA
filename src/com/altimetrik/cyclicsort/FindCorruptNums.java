package com.altimetrik.cyclicsort;

import java.util.Arrays;

class FindCorruptNums {

  public static int[] findNumbers(int[] nums) {
    // TODO: Write your code here
   int[] result = new int[] { -1, -1 };
    if(nums.length == 0){
      return result;
    }
     int i=0;
    while(i < nums.length){
      int j = nums[i] - 1;
      if(nums[i] != nums[j]){
        swap(nums,i,j);
      }else{
        i++;
      }
    }

      for (i = 0; i < nums.length; i++)
          if (nums[i] != i + 1)
              return new int[] { nums[i], i + 1 };  //Be conscious


   /*for(int k=0;k<nums.length;k++){

     if(result[0] != -1){
       if(nums[k] != k){
       result[1] = k;
       }
     }else
        if(nums[k] != k+1)
          result[0] = nums[k];
    }*/
    return result;
  }
  

  public static void swap(int[] arr,int i,int j){
      int tmp = arr[i];
      arr[i] = arr[j];
      arr[j] = tmp;
  }

    public static void main(String[] args) {
        int[] result = new int[]{-1,-1};
        result = FindCorruptNums.findNumbers(new int[]{3, 1, 2, 5, 2});
        System.out.println(Arrays.toString(result));
        result =  FindCorruptNums.findNumbers(new int[]{3, 1, 2, 3, 6, 4});
        System.out.println(Arrays.toString(result));
    }
   
}
//findNumbers([3, 1, 2, 5, 2])        findNumbers([3, 1, 2, 3, 6, 4])