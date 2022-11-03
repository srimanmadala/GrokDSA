package com.altimetrik.reversaloflinkedList;

import com.altimetrik.reversaloflinkedList.ListNode;

import java.util.*;



public class MyReverseSubList {

  public static ListNode reverse(ListNode head, int p, int q) {
    // TODO: Write your code here
    ListNode prev = null;
    ListNode current = head;
    while(current.value != p){
      prev = current;
      current = current.next;
    }
    ListNode lastNodeOfFirstPart = prev;
    ListNode lastNodeOfSubList = current;
    ListNode revPrev = null;
    for(int i=0;i<q-p+1 && current != null ; i++){
      ListNode tmp = current;
      current = current.next;
      tmp.next = revPrev;
      revPrev = tmp;
    }
    if(lastNodeOfFirstPart != null){
      lastNodeOfFirstPart.next = revPrev;
    }else{
      head = revPrev; // if p == 1 then lastNodeOfFirstPart will be null
    }
    lastNodeOfSubList.next = current;
    return head;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);

    ListNode result = ReverseSubList.reverse(head, 1, 4);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }
}