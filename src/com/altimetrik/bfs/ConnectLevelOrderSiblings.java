package com.altimetrik.bfs;

import java.util.LinkedList;
import java.util.Queue;

class ConnectLevelOrderSiblings {
  public static void connect(TreeNode root) {
    // TODO: Write your code here

    Queue<TreeNode> levelOrders =  new LinkedList<>();
    levelOrders.offer(root);
    while(!levelOrders.isEmpty()){
      int numOflevelElements = levelOrders.size();
      TreeNode prevous = null;
      for(int i=0;i<numOflevelElements;i++){
         TreeNode curentNode = levelOrders.poll();
               
          if(prevous != null)
            prevous.next = curentNode;
            
             prevous = curentNode;
           //System.out.print(curentNode.val + " ");
            if(curentNode.left != null){
           levelOrders.offer(curentNode.left);
         }
          if(curentNode.right != null){
           levelOrders.offer(curentNode.right);
         }
        
      }
    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    ConnectLevelOrderSiblings.connect(root);
    System.out.println("Level order traversal using 'next' pointer: ");
    root.printLevelOrder();
  }
}
