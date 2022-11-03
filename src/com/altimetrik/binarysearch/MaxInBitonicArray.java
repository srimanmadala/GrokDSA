package com.altimetrik.binarysearch;

class MaxInBitonicArray {

  public static int findMax(int[] arr) {
    // TODO: Write your code here

    int left =0;
    int right = arr.length -1;
    while(left < right){

      int mid = left + (right - left) / 2;
      if(arr[mid] < arr[mid+1]){  //in Ascending order so move right till where asceding breaks
        left =  mid + 1 ;
      }
      if(arr[mid] > arr[mid+1]){ //Ascending order broken some where before mid element so move right
        right =  mid ;
      }
     
    }
    return arr[right]; //here both left and right points to the same position
  }

  public static void main(String[] args) {
    System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12, 4, 2 }));
    System.out.println(MaxInBitonicArray.findMax(new int[] { 3, 8, 3, 1 }));
    System.out.println(MaxInBitonicArray.findMax(new int[] { 1, 3, 8, 12 }));
    System.out.println(MaxInBitonicArray.findMax(new int[] { 10, 9, 8 }));
  }
}