package com.altimetrik.binarysearch;

class FindRange {

  public static int[] findRange(int[] arr, int key) {
    int[] result = new int[] { -1, -1 };
    // TODO: Write your code here
    result[0] = firstOrLastOccurence(arr,key,true);
    if(result[0] != -1){
      result[1] = firstOrLastOccurence(arr,key,false);
    }

    return result;
  }

  public static int firstOrLastOccurence(int[] arr, int key,boolean forFirstOccurence) {
      int left = 0;
      int right = arr.length - 1;
      int index = -1;
      while(left <= right){
        
        int mid = left + (right - left) / 2;

          if(key < arr[mid]){
            right = mid - 1;
          }else if(key > arr[mid]){
            left = mid + 1;
          }else{
            index = mid;
            if(forFirstOccurence){
              right = mid - 1; //For first occurence
            }else{
              left = mid + 1;  //For last occurence
            }
          }
       
      }
      return index;
    
  }




  public static void main(String[] args) {
    int[] result = FindRange.findRange(new int[] { 4, 6, 6, 6, 9 }, 6);
    System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 10);
    System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
    result = FindRange.findRange(new int[] { 1, 3, 8, 10, 15 }, 12);
    System.out.println("Range: [" + result[0] + ", " + result[1] + "]");
  }
}