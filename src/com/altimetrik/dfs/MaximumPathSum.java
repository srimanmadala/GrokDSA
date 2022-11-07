package com.altimetrik.dfs;

class MaximumPathSum {


public static int maxPathSum = 0;
  public static int findMaximumPathSum(TreeNode root) {
    // TODO: Write your code here
    return maximumPathSum(root);
  }

   public static int maximumPathSum(TreeNode curentNode) {
    // TODO: Write your code here
    if(curentNode == null)
       return 0;
     
       int leftSum = maximumPathSum(curentNode.left);
       int rightSum = maximumPathSum(curentNode.right);

      maxPathSum = Math.max(maxPathSum, leftSum + rightSum + curentNode.val);
       
    return maxPathSum;
  }



  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(2);
    root.right = new TreeNode(3);
    System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
    
    root.left.left = new TreeNode(1);
    root.left.right = new TreeNode(3);
    root.right.left = new TreeNode(5);
    root.right.right = new TreeNode(6);
    root.right.left.left = new TreeNode(7);
    root.right.left.right = new TreeNode(8);
    root.right.right.left = new TreeNode(9);
    System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
    
    root = new TreeNode(-1);
    root.left = new TreeNode(-3);
    System.out.println("Maximum Path Sum: " + MaximumPathSum.findMaximumPathSum(root));
  }
}