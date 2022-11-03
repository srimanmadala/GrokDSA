package com.altimetrik.dfs;

import com.altimetrik.bfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

class FindAllTreePaths {
  public static List<List<Integer>> findPaths(TreeNode root, int sum) {
    List<List<Integer>> allPaths = new ArrayList<>();
    
    // TODO: Write your code here
    List<Integer> path = new ArrayList<>();
    findPathsToLeaves( root, sum,path,allPaths);
    return allPaths;
  }

  public static void findPathsToLeaves(TreeNode root, int sum,List<Integer> path,
  List<List<Integer>> allPaths) {

    // TODO: Write your code here
    if(root == null){
        return;
    }
    System.out.println("root.val.."+root.val);
    path.add(root.val);
    if(root.val == sum && root.left == null && root.right == null){
      allPaths.add(new ArrayList<>(path));
    }else{
      System.out.println("Before Left..");
      findPathsToLeaves( root.left,  sum - root.val,path, allPaths);
      System.out.println("Before RIGHT..");
      findPathsToLeaves( root.right,  sum - root.val,path, allPaths);
      System.out.println("End of Else..");
    }

    // remove the current node from the path to backtrack, 
    // we need to remove the current node while we are going up the recursive call stack.
    System.out.println("Before Removing.."+path.get(path.size() - 1));
    path.remove(path.size() - 1);
}

  public static void main(String[] args) {
    TreeNode root = new TreeNode(12);
    root.left = new TreeNode(7);
    root.right = new TreeNode(1);
    root.left.left = new TreeNode(4);
    root.right.left = new TreeNode(10);
    root.right.right = new TreeNode(5);
    int sum = 23;
    List<List<Integer>> result = FindAllTreePaths.findPaths(root, sum);
    System.out.println("Tree paths with sum " + sum + ": " + result);
  }
}