package com.leetcode.recursion;

import com.leetcode.recursion.misc.TreeNode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LeetCode_829  {
    public Map<Integer, List<TreeNode>> memo = new HashMap<>();
    public List<TreeNode> allPossibleFBT(int n) {

        if(n %2==0) {
            return new ArrayList<>();
        }

        if(n  == 1) {
            List<TreeNode> node = new ArrayList<>();
            node.add(new TreeNode(0));
            memo.put(n,node);
            return node;
        }
        if(memo.containsKey(n)) {
            return memo.get(n);
        }
        List<TreeNode> result = new ArrayList<>();
        for(int i=1;i<n;i=i+2) {
            List<TreeNode> leftTree = allPossibleFBT(i);
            List<TreeNode> rightTree = allPossibleFBT(n-i-1);
            for(TreeNode leftNode : leftTree) {
                for(TreeNode rightNode : rightTree) {
                    result.add(new TreeNode(0,leftNode,rightNode));
                }
            }

        }
        memo.put(n,result);
        return result;

    }
}