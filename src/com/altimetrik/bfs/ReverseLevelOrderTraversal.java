package com.altimetrik.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ReverseLevelOrderTraversal {
  public static List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new LinkedList<List<Integer>>();
    // TODO: Write your code here

     if(root == null )
       return result;
    Queue<TreeNode> levelNodes = new LinkedList<>();
    levelNodes.offer(root);
    while(!levelNodes.isEmpty()){
      int queSize = levelNodes.size();
      List<Integer> levelValues = new ArrayList<>();
      for(int i=0;i<queSize;i++){

      TreeNode levelNode = levelNodes.poll();
       levelValues.add(levelNode.val);
       if(levelNode.left != null){
         levelNodes.add(levelNode.left);
       }

        if(levelNode.right != null){
         levelNodes.add(levelNode.right);
       }
      
      }

      if(!levelValues.isEmpty()){
        result.add(0,levelValues);
      } 
    }
    return result;
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    List<List<Integer>> result = ReverseLevelOrderTraversal.traverse(root);
    System.out.println("Reverse level order traversal: " + result);
  }
}