package com.altimetrik.dfs;

import com.altimetrik.bfs.TreeNode;

class PathWithGivenSequence {
  public static boolean findPath(TreeNode root, int[] sequence) {
    // TODO: Write your code here
    return findPathFrmRootToLeaf(root, sequence,0);
  }


   public static boolean findPathFrmRootToLeaf(TreeNode root, int[] sequence,int index) {
    // TODO: Write your code here
     if( root == null )
       return false;

    if(index == sequence.length  || root.val != sequence[index])
      return false;

      if(root.left == null && root.right == null && index == sequence.length-1)
      return true;

  return 
      findPathFrmRootToLeaf(root.left, sequence, index + 1) || 
      findPathFrmRootToLeaf(root.right, sequence, index + 1) ;

    
  }
  
  public static void main(String[] args) {
    TreeNode root = new TreeNode(1);
    root.left = new TreeNode(0);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(1);
    root.right.left = new TreeNode(6);
    root.right.right = new TreeNode(5);

    System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 0, 7 }));
    System.out.println("Tree has path sequence: " + PathWithGivenSequence.findPath(root, new int[] { 1, 1, 6 }));
  }
}
