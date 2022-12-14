package com.altimetrik.dp;

class SubsetSum {

  public boolean canPartition(int[] num, int sum) {
    // TODO: Write your code here
    return canPartitionRec( num,  sum,0) ;
  }

   public boolean canPartitionRec(int[] num, int sum, int index) {
    // TODO: Write your code here

    if(sum ==0)
     return true;
 
    
    return 
     sum-num[index] >= 0 && 
      (canPartitionRec( num,  sum-num[index],  index+1) ||

    canPartitionRec( num,  sum,  index+1));

    //return false;
    
  }

  public static void main(String[] args) {
    SubsetSum ss = new SubsetSum();
    int[] num = { 1, 2, 3, 7 };
    System.out.println(ss.canPartition(num, 6));
    num = new int[] { 1, 2, 7, 1, 5 };
    System.out.println(ss.canPartition(num, 10));
    num = new int[] { 1, 3, 4, 8 };
    System.out.println(ss.canPartition(num, 6));
  }
}