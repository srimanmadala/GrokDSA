package com.altimetrik.recursion;

import java.util.*;

public class CobinationSum2 {

    public static void main(String[] args) {
        /*int[] arr = new int[]{2,3,6,7};
        int target = 7;
        int[] arr = new int[]{2,3,5,8};
        int target = 8;*/
        int[] arr = new int[]{10,1,2,7,6,1,5};
        Arrays.sort(arr);
        int target = 8;
        List<Set<Integer>> totalResult = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        sumRec(arr,target,0,result,totalResult);
        for(int i=0;i<totalResult.size();i++) {
            int len = totalResult.get(i).size();
            for(int j=0;j<len;j++) {
                System.out.print(totalResult.get(i)+" ");
            }
            System.out.println();
            System.out.println("-----------------");
        }
        sumInDP(arr,target);
    }

    private static void sumRec(int[] arr, int target, int i, List<Integer> result,List<Set<Integer>> totalResult) {
        if(target <= 0 || i==arr.length){
            if(target == 0) {
                totalResult.add(new HashSet<>(result));
            }
            return;
        }
        if(target-arr[i] >= 0) {
            result.add(arr[i]);
            sumRec(arr, target - arr[i], i+1, result, totalResult);
            result.remove(result.size()-1);
            sumRec(arr,target,i+1,result,totalResult);
        }
    }

    public  static void sumInDP(int[] arr, int target) {
        int n = arr.length;
        int[][] dp = new int[n+1][target+1];

        for(int i=1;i<n;i++) {
            int candidate = arr[i];
            for(int j=1;j<target;j++) {
                if(j-candidate >= 0) {
                    dp[i][j] = j-candidate;
                }
            }
        }
    }
}
