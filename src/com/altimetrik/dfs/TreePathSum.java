package com.altimetrik.dfs;

class TreePathSum {
  public static boolean hasPath(TreeNode root, int sum) {
    // TODO: Write your code here
    return hasPathForTheSum( root,  sum);
  }

  public static boolean hasPathForTheSum(TreeNode root, int sum) {
    // TODO: Write your code here

    if(root == null )
        return false;

// if the current node is a leaf and its value is equal to the sum, we've found a path
       if(root.val == sum && root.left == null && root.right == null)
          return true;
      

      // recursively call to traverse the left and right sub-tree
    // return true if any of the two recursive call return true
      return
        hasPathForTheSum( root.left,  sum - root.val) ||  hasPathForTheSum( root.right,  sum - root.val) ;


  }

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(9);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    System.out.println("Tree has path: " + TreePathSum.hasPath(root, 23));
    System.out.println("Tree has path: " + TreePathSum.hasPath(root, 16));
  }
}
