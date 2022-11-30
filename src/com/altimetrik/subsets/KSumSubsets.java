package com.altimetrik.subsets;

import java.util.*;
import java.util.stream.Collectors;

public class KSumSubsets{

    public static void main(String[] args) {
        //List<List<Integer>> result = getKSumSubsets(Arrays.asList(8,13,3,22,17,39,87,45,36),100);
       // List<List<Integer>> result = getKSumSubsetsRec(Arrays.asList(8,13,3,22,17,39,87,45,36),100);
        List<List<Integer>> result = getKSumSubsetsRec(Arrays.asList(8,13,3,36),24);
        for(List<Integer> r : result){
            for(Integer r1 : r){
                System.out.print(r1+ " ");
            }
            System.out.println();
        }

    }

    public static List<List<Integer>> getKSumSubsetsRec(List<Integer> setOfIntegers, int targetSum) {
        // Write your code here
        //Does this set contains both positive and negative integers
        List<List<Integer>>  result = new ArrayList<>();

        if(setOfIntegers == null || setOfIntegers.size() == 0)
            return result;

        List<List<Integer>> subsets = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        subsets.add(subset);
        int n = setOfIntegers.size();
        for(int i=0;i<n;i++){
            int m =subsets.size();
            for(int j=0;j<m;j++)
            {
                List<Integer> curset = subsets.get(j);
                List<Integer> copy = new ArrayList<>(curset);
                copy.add(setOfIntegers.get(i));
                subsets.add(copy);
                int sum = copy.stream().mapToInt(Integer::intValue).sum();
                if(sum == targetSum)
                    result.add(copy);
            }
        }
        return result;
    }
    public static List<List<Integer>> getKSumSubsets(List<Integer> setOfIntegers, int targetSum) {
        // Write your code here
       List<List<Integer>> result =  new ArrayList<>();
       List<Integer> subset = new ArrayList<>();
        getKSumSubsetsRec(0, setOfIntegers,  targetSum,subset,result) ;
        return result;
    }


    public static void getKSumSubsetsRec(int index,List<Integer> setOfIntegers, int targetSum,
    List<Integer> subset, List<List<Integer>> result) {


      if(index == setOfIntegers.size()){
          return;
      }
        if(targetSum == 0){
            result.add(subset);
            List<String> value = subset.stream().map(String::valueOf).collect(Collectors.toList());
            System.out.println(value.get(0));
            return;
        }

        int curentVal = setOfIntegers.get(index);
        if(curentVal > targetSum){
            getKSumSubsetsRec( index+1, setOfIntegers,  targetSum,subset,  result);
        }
        if(targetSum >= curentVal){
            subset.add(curentVal);
            getKSumSubsetsRec( index+1, setOfIntegers,  targetSum-curentVal,subset,  result);
            subset.remove(subset.size() - 1);
        }else {

            getKSumSubsetsRec(index + 1, setOfIntegers, targetSum, subset, result);
        }


    }
}