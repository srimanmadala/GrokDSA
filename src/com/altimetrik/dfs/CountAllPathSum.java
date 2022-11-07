package com.altimetrik.dfs;

import com.altimetrik.bfs.TreeNode;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

public class CountAllPathSum {

    public static int countPaths(TreeNode root, int S) {
        List<Integer> currentPath = new LinkedList<>();
        return countPathsRecursive(root, S, currentPath);
    }

    public static void misc(String[] args) {
        List<Integer> currentPath = new LinkedList<>();
        currentPath.add(12);
        //currentPath.add(7);

        ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
        while (pathIterator.hasPrevious()) {
            System.out.println(pathIterator.previous());
        }
    }


    public static void main(String[] args) {
        TreeNode root = new TreeNode(12);
        root.left = new TreeNode(7);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(10);
        root.right.right = new TreeNode(5);
        //System.out.println("Tree has path: " + CountAllPathSum.countPaths(root, 11));
        CountAllPathSum.misc(null);
    }

    private static int countPathsRecursive(TreeNode currentNode, int S, List<Integer> currentPath) {
        if (currentNode == null)
            return 0;
        int pathSum = 0,pathCount =0;
        currentPath.add(currentNode.val);
        ListIterator<Integer> pathIterator = currentPath.listIterator(currentPath.size());
        while (pathIterator.hasPrevious()) {
            //System.out.println(pathIterator.previous());
            pathSum+=pathIterator.previous();
            if(pathSum == S){
                System.out.println(Arrays.toString(currentPath.toArray()));
                pathCount++;
            }
        }
        pathCount+=countPathsRecursive( currentNode.left,  S, currentPath);
        pathCount+=countPathsRecursive( currentNode.right,  S, currentPath);

        currentPath.remove(currentPath.size() - 1);
        return pathCount;
    }

    }
