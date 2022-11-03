package com.altimetrik.topKelements;
//Must visit Again..
import java.util.*;

class Entry {
  int key;
  int value;

  public Entry(int key, int value) {
    this.key = key;
    this.value = value;
  }
}

class KClosestElements {

  public static List<Integer> findClosestElements(int[] arr, int K, Integer X) {
    List<Integer> result = new ArrayList<>();
    // TODO: Write your code here
    int index = binarySearch(arr,X);
    int low = Math.max(index - K,0);
    int high = Math.min(index+K,arr.length);
    PriorityQueue<Entry> minHeap = new PriorityQueue<Entry>((n1,n2)->n1.value - n2.value);

    for(int i=low;i<high;i++)
      minHeap.add(new Entry(arr[i],Math.abs(arr[i]-X)));

      for(int j=0;j<K;j++){
        result.add(minHeap.poll().key);
       
      }

     Collections.sort(result);
    
    return result;
  }
  public static int binarySearch(int[] arr,int target){

    int low =0,high=arr.length-1;
    while(low < high){
      int mid = low + (high - low) / 2 ;
      if(arr[mid] == target)
      return mid;

      if(target > arr[mid]){
        low = mid + 1;
      }else{
        high = mid - 1;
      }
    }

    if(low > 0)
    return low - 1;

    return low;

  }

  public static void main(String[] args) {
    List<Integer> result = KClosestElements.findClosestElements(new int[] { 5, 6, 7, 8, 9 }, 3, 7);
    System.out.println("'K' closest numbers to 'X' are: " + result);

    result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 6);
    System.out.println("'K' closest numbers to 'X' are: " + result);

    result = KClosestElements.findClosestElements(new int[] { 2, 4, 5, 6, 9 }, 3, 10);
    System.out.println("'K' closest numbers to 'X' are: " + result);
  }
}
