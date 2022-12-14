package com.altimetrik.slowpointers;

public class PalindromicLinkedList {

  public static boolean isPalindrome(ListNode head) {
    // TODO: Write your code here
    if(head == null || head.next == null)
    return true;

    ListNode slow = head;
    ListNode fast = head;
    while(fast != null && fast.next != null){
      slow =  slow.next;
      fast = fast.next.next;
    }

    ListNode reverhead = reverse(slow);
    ListNode copyReversehead = reverhead;
    while(reverhead != null && head != null){
      if(reverhead.value != head.value)
        break;
        reverhead = reverhead.next;
        head = head.next;
    }

    reverse(copyReversehead);
  if (head == null || reverhead == null) // if both halves match
      return true;

    return false;
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
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(2);
    System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));

    head.next.next.next.next.next = new ListNode(2);
    System.out.println("Is palindrome: " + PalindromicLinkedList.isPalindrome(head));
  }
}