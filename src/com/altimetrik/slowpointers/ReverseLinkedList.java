package com.altimetrik.slowpointers;

public class ReverseLinkedList {

    public static void main(String[] args) {
        ListNode head = new ListNode(2);
        head.next = new ListNode(4);
        head.next.next = new ListNode(6);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(2);
        //System.out.println("Is palindrome: " + PalindromicLinkedList.reverse(head));

        head.next.next.next.next.next = new ListNode(2);
        //System.out.println("Is palindrome: " + ReverseLinkedList.reverse(head));


        display(reverse(head));
    }

    public static ListNode reverse(ListNode curhead){
        ListNode prev = null;
        while(curhead != null){
            ListNode tmp = curhead;
            curhead = curhead.next;
            tmp.next = prev;
            prev = tmp;
        }
       return prev;
    }

    public static  void display(ListNode head){
        while(head != null){
            System.out.println(head.value);
            head = head.next;
        }
    }
}

