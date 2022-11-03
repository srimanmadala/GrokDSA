package com.altimetrik.mergeintervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalsIntersection {


    public static Interval[] merge(Interval[] arr1, Interval[] arr2) {
        List<Interval> intervalsIntersection = new ArrayList<Interval>();
        // TODO: Write your code here
        int i=0,j=0;
        while(i < arr1.length && j < arr2.length){

            Interval s1 =  arr1[i];
            Interval s2 =  arr2[j];
            //overlapping conditon.
             if(s1.start <= s2.end && s1.end >= s2.start){
                 intervalsIntersection.add(new Interval(Math.max(s1.start,s2.start),Math.min(s1.end,s2.end)));
             }
             if(s1.end <= s2.end){
                 i++;
             }else{
                 j++;
             }
        }
        return intervalsIntersection.toArray(new Interval[intervalsIntersection.size()]);
    }

    public static void main(String[] args) {
        Interval[] input1 = new Interval[] { new Interval(1, 3), new Interval(5, 6), new Interval(7, 9) };
        Interval[] input2 = new Interval[] { new Interval(2, 3), new Interval(5, 7) };
        Interval[] result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input1 = new Interval[] { new Interval(1, 3), new Interval(5, 7), new Interval(9, 12) };
        input2 = new Interval[] { new Interval(5, 10) };
        result = IntervalsIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
    }
}
