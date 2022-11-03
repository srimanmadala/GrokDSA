package com.altimetrik.dfs;

import com.altimetrik.bfs.TreeNode;

class SumOfPathNumbers {
  public static int findSumOfPathNumbers(TreeNode root) {
    // TODO: Write your code here

    if(root == null)
       return -1;

       return findSumOfAllPathNumbers(root,0);
  }

  public static int findSumOfAllPathNumbers(TreeNode root,int sum) {
    // TODO: Write your code here

    if(root == null){
      return 0;
    }
       sum = sum * 10 + root.val ;
       if(root.left == null && root.right==null)
       return sum;

      return findSumOfAllPathNumbers( root.left, sum) +
      findSumOfAllPathNumbers( root.right, sum);
       
  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);
    System.out.println("Total Sum of Path Numbers: " + SumOfPathNumbers.findSumOfPathNumbers(root));
  }
}