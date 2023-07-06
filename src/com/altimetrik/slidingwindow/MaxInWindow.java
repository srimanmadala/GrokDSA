package com.altimetrik.slidingwindow;

import java.util.*;
import java.util.stream.Stream;

public class MaxInWindow {

    public static void main(String[] args) {


        System.out.println(maxInWindows(Arrays.asList(3, 9, 6, 7, 10), 2).toString());

    }

    public static List<Integer> maxInWindows(List<Integer> nums, int k) {
        List<Integer> result = new ArrayList<>();
        PriorityQueue<Node> maxheap = new PriorityQueue<Node>((a, b) -> b.value - a.value);
        int n = nums.size();

        for (int i = 0; i < n; i++) {
            if (i >= k) {
                while (maxheap.peek().index == i - k) {
                    result.add(maxheap.poll().value);
                    //}

                }
                maxheap.add(new Node(nums.get(i), i));
            }
        }
        return result;
    }
}
