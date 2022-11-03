package com.altimetrik.dfs;

import com.altimetrik.bfs.TreeNode;

import java.util.ArrayList;
import java.util.List;

public class RootToLeafPaths {


    public static List<List<Integer>> findAllPaths(TreeNode root) {

        List<List<Integer>> allPaths = new ArrayList<>();
        List<Integer> path = new ArrayList<>();
        findPathsToLeaves(root,path,allPaths);
        return allPaths;
    }

    public static void findPathsToLeaves(TreeNode root, List<Integer> path,
                                         List<List<Integer>> allPaths) {

        // TODO: Write your code here
        /*if(root == null){
            return;
        }
        if(root.left == null && root.right == null){
            allPaths.add(new ArrayList<>(path));
            return;
        }*/
        if(root.left == null && root.right == null){
            path.add(root.val);
            allPaths.add(new ArrayList<>(path));
            return;
        }

        path.add(root.val);
        findPathsToLeaves(root.left, path, allPaths);
        findPathsToLeaves(root.right, path, allPaths);

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        int sum = 23;
        List<List<Integer>> result = RootToLeafPaths.findAllPaths(root);
        System.out.println("Tree paths with sum " + sum + ": " + result);
    }
}
