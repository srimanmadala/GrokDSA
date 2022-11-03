package com.altimetrik.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class MinimumBinaryTreeDepth {
  public static int findDepth(TreeNode root) {
    // TODO: Write your code here

     if(root == null )
       return -1;
    Queue<TreeNode> levelNodes = new LinkedList<>();
    levelNodes.offer(root);
    int level=1;
    while(!levelNodes.isEmpty()){
      int queSize = levelNodes.size();
      List<Integer> levelValues = new ArrayList<>();
      
      for(int i=0;i<queSize;i++){
       TreeNode levelNode = levelNodes.poll();
       if(levelNode.left == null && levelNode.right == null){
         return level;
       }

       if(levelNode.left != null){
         levelNodes.add(levelNode.left);
       }

        if(levelNode.right != null){
         levelNodes.add(levelNode.right);
       }
      
      }   
     level++;
    }
    return -1;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
    root.left.left = new TreeNode(9);
    root.right.left.left = new TreeNode(11);
    System.out.println("Tree Minimum Depth: " + MinimumBinaryTreeDepth.findDepth(root));
  }
}
