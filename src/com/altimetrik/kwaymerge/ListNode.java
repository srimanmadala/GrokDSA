package com.altimetrik.kwaymerge;

import java.util.*;

class ListNode {
  int value;
  ListNode next;

  ListNode(int value) {
    this.value = value;
  }
}

class MergeKSortedLists {

  public static ListNode merge(ListNode[] lists) {
    ListNode result = new ListNode(-1);
    // TODO: Write your code here
    ListNode current = result;
    PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b)->a.value - b.value);

    for(int i=0;i<lists.length;i++){
          ListNode list = lists[i];
          //System.out.println(list.value);
          minHeap.add(list);
    }
    while(!minHeap.isEmpty()){
      ListNode listNode = minHeap.poll();
      if(current.value != -1){
          current.next = listNode;
          System.out.println("IF "+current.value);
      }else{
                    
            result = listNode;
            System.out.println("Else "+listNode.value);
      }
        current = listNode;
        
       if(listNode.next != null)
        minHeap.add(listNode.next);
    }


    return result;
  }

  public static void main(String[] args) {
    ListNode l1 = new ListNode(2);
    l1.next = new ListNode(6);
    l1.next.next = new ListNode(8);

    ListNode l2 = new ListNode(3);
    l2.next = new ListNode(6);
    l2.next.next = new ListNode(7);

    ListNode l3 = new ListNode(1);
    l3.next = new ListNode(3);
    l3.next.next = new ListNode(4);

    ListNode result = MergeKSortedLists.merge(new ListNode[] { l1, l2, l3 });
    System.out.print("Here are the elements form the merged list: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }
}
