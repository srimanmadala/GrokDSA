package com.altimetrik.kwaymerge;

import java.util.*;

class Node {
  int elementIndex;
  int arrayIndex;

  Node(int elementIndex, int arrayIndex) {
    this.elementIndex = elementIndex;
    this.arrayIndex = arrayIndex;
  }
}
class SmallestRange {

  public static int[] findSmallestRange(List<Integer[]> lists) {
    // TODO: Write your code here
    if(lists == null || lists.size() == 0)
    return new int[] { -1, -1 };

    PriorityQueue<Node> minHeap = new PriorityQueue<>((n1,n2)->lists.get(n1.arrayIndex)[n1.elementIndex]
    - lists.get(n2.arrayIndex)[n2.elementIndex]);

   int maxElement = Integer.MIN_VALUE;
    for(int i=0;i<lists.size();i++){
      minHeap.add(new Node(0,i));
      maxElement = Math.max(maxElement,lists.get(i)[0]);
    }

    int rangeStart =0,rangeEnd= Integer.MAX_VALUE;
    //int[] range = new int[]{rangeStart , rangeEnd};

    while(minHeap.size() == lists.size()){
      Node curNode = minHeap.poll();
      if(rangeEnd - rangeStart > maxElement - lists.get(curNode.arrayIndex)[curNode.elementIndex]){
        rangeStart = lists.get(curNode.arrayIndex)[curNode.elementIndex];
        rangeEnd = maxElement;
      }
      curNode.elementIndex++;
      if(curNode.elementIndex < lists.get(curNode.arrayIndex).length){
        minHeap.add(curNode);
        maxElement = Math.max(maxElement,lists.get(curNode.arrayIndex)[curNode.elementIndex]);
      }

    }
    return new int[]{rangeStart, rangeEnd};
  }

  public static void main(String[] args) {
    Integer[] l1 = new Integer[] { 1, 5, 8 };
    Integer[] l2 = new Integer[] { 4, 12 };
    Integer[] l3 = new Integer[] { 7, 8, 10 };
    List<Integer[]> lists = new ArrayList<Integer[]>();
    lists.add(l1);
    lists.add(l2);
    lists.add(l3);
    int[] result = SmallestRange.findSmallestRange(lists);
    System.out.print("Smallest range is: [" + result[0] + ", " + result[1] + "]");
  }
}
