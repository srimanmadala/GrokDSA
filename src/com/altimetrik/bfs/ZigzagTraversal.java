package com.altimetrik.bfs;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

class ZigzagTraversal {
  public static List<List<Integer>> traverse(TreeNode root) {
    List<List<Integer>> result = new ArrayList<List<Integer>>();
    // TODO: Write your code here

     if(root == null )
       return result;
    Queue<TreeNode> levelNodes = new LinkedList<>();
    levelNodes.add(root);
    boolean isLeft = false;
    while(!levelNodes.isEmpty()){
      int queSize = levelNodes.size();
      List<Integer> levelValues = new ArrayList<>();
      for(int i=0;i<queSize;i++){

      TreeNode levelNode = levelNodes.poll();
      

     if(!isLeft)
      // add the node to the current level based on the traverse direction
        
          levelValues.add(levelNode.val);
        else
          levelValues.add(0, levelNode.val);
     
      
      if(levelNode.left != null)
        levelNodes.offer(levelNode.left );

        if(levelNode.right != null)
        levelNodes.offer(levelNode.right );
      }

      isLeft = !isLeft;
      if(!levelValues.isEmpty()){
        result.add(levelValues);
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
    root.right.left.left = new TreeNode(20);
    root.right.left.right = new TreeNode(17);
    List<List<Integer>> result = ZigzagTraversal.traverse(root);
    System.out.println("Zigzag traversal: " + result);
  }
}