package com.altimetrik.recursion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SumToTarget {

    public static void main(String[] args) {
        /*int[] arr = new int[]{2,3,6,7};
        int target = 7;
        int[] arr = new int[]{2,3,5,8};
        int target = 8;*/
        int[] arr = new int[]{2};
        int target = 1;
        List<List<Integer>> totalResult = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        sumRec(arr,target,0,result,totalResult);
        for(int i=0;i<totalResult.size();i++) {
            int len = totalResult.get(i).size();
            for(int j=0;j<len;j++) {
                System.out.print(totalResult.get(i).get(j)+" ");
            }
            System.out.println();
            System.out.println("-----------------");
        }
    }

    private static void sumRec(int[] arr, int target, int i, List<Integer> result,List<List<Integer>> totalResult) {
        if(target <= 0 || i==arr.length){
            if(target == 0) {
                totalResult.add(new ArrayList<>(result));
            }
            return;
        }
        if(target-arr[i] >= 0) {
            result.add(arr[i]);
            sumRec(arr, target - arr[i], i, result, totalResult);
            result.remove(result.size()-1);
            sumRec(arr,target,i+1,result,totalResult);
        }

    }
}
