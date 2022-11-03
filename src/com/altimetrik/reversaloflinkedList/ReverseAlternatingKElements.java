package com.altimetrik.reversaloflinkedList;


public class ReverseAlternatingKElements {

    public static ListNode reverse(ListNode head, int k) {
        // TODO: Write your code here
        //ListNode start = head;
        ListNode current = head;


        ListNode prev = null;

        //boolean flip = true;
        while(current != null){

            int nodemovemnt = 0;
            ListNode firsteLementofSubList =   prev;
            ListNode lasteLementofSubList = current;

            while(current != null && nodemovemnt < k){
                ListNode tmp = current;
                current = current.next;
                tmp.next = prev;
                prev = tmp;
                nodemovemnt++;
            }

            if(firsteLementofSubList == null){
                head = prev;
            }else{
                firsteLementofSubList.next = prev;
            }
            lasteLementofSubList.next = current;



        if(current == null)
            break;

        for(int i=0;i<k && current!= null;i++){
            prev = current;
            current = current.next;
        }

        }

        return head;
    }

    public static void display(ListNode result){
        while(result != null){
            System.out.print(result.value+" ");
        }
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
    head.next.next.next.next.next.next.next.next = new ListNode(9);
    head.next.next.next.next.next.next.next.next.next = new ListNode(10);
    head.next.next.next.next.next.next.next.next.next.next = new ListNode(11);

    ListNode result = ReverseAlternatingKElements.reverse(head, 3);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }
}