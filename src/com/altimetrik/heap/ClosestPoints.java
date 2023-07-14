package com.altimetrik.heap;

import java.util.*;

class ClosestPoints {
    
    public static List<Point> kClosest(Point[] points, int k) {
        ArrayList result = new ArrayList<Point>();
        PriorityQueue<Point> maxheap = new PriorityQueue<>(
            (a,b)-> (int) (b.distanceFromOrigin - a.distanceFromOrigin)
        );

      int size=0;
        for(Point point : points) {
          point. distanceFromOrigin = 
          Math.sqrt(point.x * point.x + point.y * point.y );
        if(size >= k) {
            if(point. distanceFromOrigin < maxheap.peek().distanceFromOrigin){
                maxheap.poll();
                maxheap.offer(point);
            }
        }else {
            maxheap.offer(point);
        }
          
          size++;
        }

     while(!maxheap.isEmpty()){
         result.add(maxheap.poll());
     }
        // Your code will replace this placeholder return statement
        return result;
    }
}