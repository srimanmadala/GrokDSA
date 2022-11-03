package com.altimetrik.twopointer;

public class ShortestWindowSort {

    public static void main(String[] args) {
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 5, 3, 7, 10, 9, 12 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 3, 2, 0, -1, 7, 10 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 1, 2, 3 }));
        System.out.println(ShortestWindowSort.sort(new int[] { 3, 2, 1 }));
    }



     // 1, 3, 2, 0, -1, 7, 10  ---   low - 1  high = 5
     // obtained window = 3, 2, 0, -1
     // min = -1 && max= 3  check left if ele > min llrly check element less than max
    // overall window is  1, 3, 2, 0, -1, - 5
    public static int sort(int[] arr) {

        int n = arr.length;
        int low = 0;
        int high = n-1;

        while(low < high && arr[low] <= arr[low+1])  //1, 2, 5, 3, 7, 10, 9, 12 low = 2
            low++;
        if (low == arr.length - 1) // if the array is sorted
            return 0;

        while(high > 0 && arr[high] >=  arr[high-1])  //1, 2, 5, 3, 7, 10, 9, 12 high = 6
                high--;
        //Identify max and min values with in the range (low,high)-->>(2,6)
        int startMin = Integer.MAX_VALUE;
        int startMax = Integer.MIN_VALUE;

        for(int k=low;k<high;k++){
            startMax = Math.max(startMax,arr[k]);
            startMin = Math.min(startMin,arr[k]);
        }
        //Now extend the window if any left < low && a[left] > a[low]
        while(low > 0 && arr[low - 1] > startMin)
           low--;

        //Now extend the window if any high < arrlength && a[high+1] <  subArrayMaxElement
        while(high < n -1 && arr[high+1] < startMax)
            high++;

        return high - low + 1;
    }
}
