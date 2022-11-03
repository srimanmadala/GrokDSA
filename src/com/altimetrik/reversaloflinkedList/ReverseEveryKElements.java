package com.altimetrik.reversaloflinkedList;

import java.util.*;



public class ReverseEveryKElements {

  public static ListNode reverse(ListNode head, int k) {
    // TODO: Write your code here

    if(k==1 || head == null)
    return head;

    
    ListNode current = head;
    ListNode prev = null;
    while(true){
    
    ListNode lastNodeOfFirstPart = prev;
    ListNode lastNodeOfSubList = current;

   ListNode revPrev = null;
    for(int i=0;i<k && current!=null ;i++){
      ListNode tmp = current;
      current = current.next;
      tmp.next = revPrev;
      revPrev = tmp;
    }

    if(lastNodeOfFirstPart != null){
      lastNodeOfFirstPart.next = revPrev;
    }else{
      head = revPrev;
    }
   

   if (current == null) // break, if we've reached the end of the LinkedList
        break;
      // prepare for the next sub-list
      lastNodeOfSubList.next = current;
      prev = lastNodeOfSubList;

    }
    
    return head;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);
    head.next.next.next.next.next.next = new ListNode(7);
    head.next.next.next.next.next.next.next = new ListNode(8);

    ListNode result = ReverseEveryKElements.reverse(head, 3);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }
}