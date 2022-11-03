package com.altimetrik.mergeintervals;

import java.util.*;

public class InsertInterval {

    public static void main(String[] args) {

        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(2, 3));
        input.add(new Interval(5, 7));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : InsertInterval.insert(input, new Interval(1, 4)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }


    public static List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        //TODO: Write your code here
        List<Interval> mergedIntervals = new ArrayList<>();
        int newIntervalStrt = newInterval.start;
        int newIntervalEnd = newInterval.end;

        int i=0; //Non overlapping intervals
        while(i < intervals.size() && intervals.get(i).end < newInterval.start ){
            mergedIntervals.add(intervals.get(i++));
        }

        //overlapping ones
        while(i < intervals.size() && intervals.get(i).start <= newInterval.end ){
            newIntervalStrt = Math.min(newIntervalStrt,intervals.get(i).start);
            newIntervalEnd = Math.max(newIntervalEnd , intervals.get(i).end);
            i++;
        }
        mergedIntervals.add(new Interval(newIntervalStrt,newIntervalEnd));

        //Add the remaining ones to the result list.
        while(i < intervals.size() ){
            mergedIntervals.add(intervals.get(i++));
        }


        return mergedIntervals;
    }
}
