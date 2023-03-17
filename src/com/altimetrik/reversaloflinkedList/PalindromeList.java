package com.altimetrik.reversaloflinkedList;

import java.util.*;
public class PalindromeList{
    public static boolean palindrome(LinkedListNode head) {
    // Write your code here
  LinkedListNode oldhead = head;
  LinkedListNode slow = head;
  LinkedListNode fast = head;
  
  while(fast != null && fast.next != null){
    slow = slow.next;
    fast = fast.next.next;
  }
  //  size is if the linkedlist is determined(even/odd)
  if(fast != null){
    slow = slow.next;
  }
  
  LinkedListNode secondHalfhead = reverseList(slow);

  while(secondHalfhead != null){
    if(secondHalfhead.data != oldhead.data){
      return false;
    }
    secondHalfhead = secondHalfhead.next;
    oldhead = oldhead.next;
  }
    return true;
  }

  public static LinkedListNode   reverseList(LinkedListNode secondhalf){
   LinkedListNode start = secondhalf ;
   //secondhalf.next = null;
   LinkedListNode reverseStartNode = null;
   LinkedListNode tnp = start ;
   while(tnp != null){
     tnp = tnp.next;
    start.next =  reverseStartNode;
     reverseStartNode = start;
     start = tnp;
   }
  return reverseStartNode;
  }

}