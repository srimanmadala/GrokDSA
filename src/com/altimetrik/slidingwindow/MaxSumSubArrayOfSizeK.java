package com.altimetrik.slidingwindow;

class MaxSumSubArrayOfSizeK {
  public static int findMaxSumSubArray(int k, int[] arr) {
    // TODO: Write your code here
    int max_sum = Integer.MIN_VALUE;
    int arrSize = arr.length;
    int windowStart = 0;
    int sum = 0;
    for(int windowEnd=0;windowEnd<arrSize;windowEnd++){
      sum+=arr[windowEnd];

      if(windowEnd > k - 1){

          sum = sum - arr[windowStart];
          windowStart++;
      }
      max_sum = Math.max(max_sum,sum);

     
    }
    return max_sum;
  }
}