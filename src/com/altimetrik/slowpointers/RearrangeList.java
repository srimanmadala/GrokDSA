package com.altimetrik.slowpointers;

class RearrangeList {

  public static void reorder(ListNode head) {
    // TODO: Write your code here 
    ListNode slow = head;
    ListNode fast = head;
    while(fast != null && fast.next != null){
      slow = slow.next;
      fast = fast.next.next;
    }

    ListNode reverse = reverse(slow);
    ListNode secondHalf = reverse;
    ListNode firstHalf = head;
    while(firstHalf != null && secondHalf != null){
      ListNode firstTmp = firstHalf.next;
      firstHalf.next = secondHalf;
      firstHalf = firstTmp;

      ListNode secondTmp = secondHalf.next;
      secondHalf.next = firstHalf;
      secondHalf = secondTmp;
      

    }

    if (firstHalf != null)
      firstHalf.next = null;
  

  }

  public static ListNode reverse(ListNode head){
    ListNode prev = null;
    while(head != null){
      ListNode tmp = head;
      head = head.next;
      tmp.next = prev;
      prev = tmp;
    }
    return prev;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(2);
    head.next = new ListNode(4);
    head.next.next = new ListNode(6);
    head.next.next.next = new ListNode(8);
    head.next.next.next.next = new ListNode(10);
    head.next.next.next.next.next = new ListNode(12);
    RearrangeList.reorder(head);
    while (head != null) {
      System.out.print(head.value + " ");
      head = head.next;
    }
  }
}