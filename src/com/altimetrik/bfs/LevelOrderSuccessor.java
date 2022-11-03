package com.altimetrik.bfs;

import java.util.LinkedList;
import java.util.Queue;

class LevelOrderSuccessor {
  public static TreeNode findSuccessor(TreeNode root, int key) {
    // TODO: Write your code here
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    while(!queue.isEmpty()){
       TreeNode curentNode = queue.poll();
       int value = curentNode.val;
       if(curentNode.left != null){
         queue.offer(curentNode.left);
       }
       if(curentNode.right != null){
         queue.offer(curentNode.right);
       }
       if(value == key){
         return queue.poll();
          
       }
    }
    return null;    
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    root.left.left = new TreeNode(4);
    root.left.right = new TreeNode(5);
    
    TreeNode result = LevelOrderSuccessor.findSuccessor(root, 3);
    if (result != null)
      System.out.println(result.val + " ");

    root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);

    result = LevelOrderSuccessor.findSuccessor(root, 9);
    if (result != null)
      System.out.println(result.val + " ");

    result = LevelOrderSuccessor.findSuccessor(root, 12);
    if (result != null)
      System.out.println(result.val + " ");
  }
}