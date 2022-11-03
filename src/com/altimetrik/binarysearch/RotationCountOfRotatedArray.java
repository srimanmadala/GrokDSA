package com.altimetrik.binarysearch;

class RotationCountOfRotatedArray {

  public static int countRotations(int[] arr) {
   // TODO: Write your code here
   int n = arr.length;
     int start = 0, end = n - 1;
    while (start < end) {
        int mid = start + (end - start) / 2;
        if (mid < end && arr[mid] > arr[mid + 1]) {  //Ascending order breaked at mid + 1
            return mid + 1;
        } else if (mid > start && arr[mid - 1] > arr[mid]) { //Ascending order breaked at mid
            return mid;
        }

        if (arr[start] <= arr[mid]) {  // left portion is in ascending order so pivot is on right
            start = mid + 1;
        } else { //right portion of the mid is sorted so pivot is at left
            end = mid - 1;
        }
    }
    return 0;//if Array is not sorted..
  }

  public static void main(String[] args) {
    System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 10, 15, 1, 3, 8 }));
    System.out.println(RotationCountOfRotatedArray.countRotations(new int[] { 4, 5, 7, 9, 10, -1, 2 }));
    System.out.println(RotationCountOfRotatedArray.countRotations(new int[] {  3, 8, 10,1 }));
      System.out.println(RotationCountOfRotatedArray.countRotations(new int[] {  7, 9, 10, -1, 2,4,5 }));
  }
}