package com.altimetrik.binarysearch;

class FloorOfANumber {

  public static int searchFloorOfANumber(int[] arr, int key) {
    // TODO: Write your code here
    if( key > arr[arr.length-1] )
      return arr[arr.length-1];

      int left = 0;
      int right = arr.length - 1;
      
      while(left <= right){
        
        int mid = left + (right - left) / 2;

          if(key < arr[mid]){
            right = mid - 1;
          }else if(key > arr[mid]){
            left = mid + 1;
          }else{
             return mid;
          }
       
      }

     

      return right;
  }

  public static void main(String[] args) {
    System.out.println(FloorOfANumber.searchFloorOfANumber(new int[] { 4, 6, 10 }, 6));
    //System.out.println(FloorOfANumber.searchFloorOfANumber(new int[] { 1, 3, 8, 10, 15 }, 12));
    //System.out.println(FloorOfANumber.searchFloorOfANumber(new int[] { 4, 6, 10 }, 17));
   //System.out.println(FloorOfANumber.searchFloorOfANumber(new int[] { 4, 6, 10 }, -1));
  }
}