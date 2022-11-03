package com.altimetrik.bfs;

import java.util.LinkedList;
import java.util.Queue;

class ConnectAllSiblings {
  public static void connect(TreeNode root) {
    // TODO: Write your code here
    if(root == null )
     return;
    Queue<TreeNode> queue = new LinkedList<>();
    queue.offer(root);
    TreeNode prevous = null;
    while(!queue.isEmpty()){
      TreeNode curent = queue.poll();

      if(prevous != null)
          prevous.next = curent;

          prevous = curent;

          if(curent.left != null)
             queue.offer(curent.left);

          if(curent.right != null)
             queue.offer(curent.right);

    }
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    ConnectAllSiblings.connect(root);

    // level order traversal using 'next' pointer
    TreeNode current = root;
    System.out.println("Traversal using 'next' pointer: ");
    while (current != null) {
      System.out.print(current.val + " ");
      current = current.next;
    }
  }
}