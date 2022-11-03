package com.altimetrik.mergeintervals;

import java.util.*;

public class MaximumCPULoad {


    public static int findMaxCPULoad(List<Job> jobs) {

        Collections.sort(jobs,(a, b)->Integer.compare(a.start,b.start));

        PriorityQueue<Job> minHeap = new PriorityQueue<>(jobs.size(),
                (a,b)->Integer.compare(a.end,b.end));
        int currenJobLoad = 0;
        int maxCpuLoad = 0;
        for(Job job :  jobs){
            while(!minHeap.isEmpty() && job.start >= minHeap.peek().end){
                currenJobLoad-=minHeap.peek().cpuLoad;
                minHeap.poll();
            }
            minHeap.offer(job);
            currenJobLoad += job.cpuLoad;
            maxCpuLoad = Math.max(maxCpuLoad, currenJobLoad);
        }
        return maxCpuLoad;
    }

    public static void main(String[] args) {

        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(6, 7, 10), new Job(2, 4, 11), new Job(8, 12, 15)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

        input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 2), new Job(2, 4, 1), new Job(3, 6, 5)));
        System.out.println("Maximum CPU load at any time: " + MaximumCPULoad.findMaxCPULoad(input));

    }


}
