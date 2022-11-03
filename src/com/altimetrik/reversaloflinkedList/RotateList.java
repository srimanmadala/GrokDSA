package com.altimetrik.reversaloflinkedList;

class RotateList {

  public static ListNode rotate(ListNode head, int rotations) {
    // TODO: Write your code here
    if(rotations == 0 || head == null)
    return head;

    ListNode current = head;
    int listLength = 0;
    while(current != null){
        listLength++;
        current = current.next;
    }
    ListNode newHead = reverse(head,1,listLength);
    //return newHead;
      int nofrotations = Math.abs(rotations - listLength);

      ListNode firstRotations = reverse(newHead,1,nofrotations);
      //return firstRotations;
    return reverse(firstRotations,nofrotations+1,listLength);

  }

  public static ListNode reverse(ListNode head,int p,int q){

   if(q<=p || q == 1)
     return head;
    
    ListNode prev = null;
    ListNode current = head;

     for(int i=0;i<p-1 && current != null;i++){
       prev = current;
       current = current.next;
     }
      ListNode lastNodeOfSubList = current ;
      ListNode reverseFirstElement = null;
     for(int j=0;j<q-p+1 && current != null;j++){
       ListNode tmp = current ;
       current =  current.next;
       tmp.next = reverseFirstElement;
         reverseFirstElement = tmp;
     }
     if(prev == null)
        head = reverseFirstElement;
     else
         prev.next = reverseFirstElement;

     lastNodeOfSubList.next = current;

    return head;
  }

  public static void main(String[] args) {
    ListNode head = new ListNode(1);
    head.next = new ListNode(2);
    head.next.next = new ListNode(3);
    head.next.next.next = new ListNode(4);
    head.next.next.next.next = new ListNode(5);
    head.next.next.next.next.next = new ListNode(6);

    ListNode result = RotateList.rotate(head, 3);
      //ListNode result = RotateList.rotate(head, 8);
    System.out.print("Nodes of the reversed LinkedList are: ");
    while (result != null) {
      System.out.print(result.value + " ");
      result = result.next;
    }
  }
}