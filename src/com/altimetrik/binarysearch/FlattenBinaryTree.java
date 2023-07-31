package com.altimetrik.binarysearch;

import java.util.IdentityHashMap;
import java.util.Map;

public class FlattenBinaryTree {

    public static void main(String[] args) {
        Map<String,Integer> m = new IdentityHashMap<>();
        m.put("sriman",1);
        m.put("",2);
        m.put("",3);
        System.out.println(m.size());
    }

    /*public static TreeNode<Integer> flattenTree(TreeNode<Integer> root) {

        if(root ==  null)
            return null;
        // Replace this placeholder return statement with your code
        Queue<Integer> queue = new LinkedList<>();
        flatToList(root,queue);
        List<Integer> result = new LinkedList<>();
        while(!queue.isEmpty()) {
            result.add(queue.poll());
        }
        return root;
    }

    public static void flatToList(TreeNode<Integer> root, Queue<Integer> queue) {

        if(root == null) {
            return;
        }
        queue.add(root.data);
        flatToList(root.left,queue);
        flatToList(root.right,queue);

    }

    public static void main(String[] args) {
        // Create a list of list of TreeNode objects to represent binary trees
        List<List<TreeNode<Integer>>> listOfTrees = Arrays.asList(
                Arrays.asList(new TreeNode<Integer>(3), new TreeNode<Integer>(2), new TreeNode<Integer>(17), new TreeNode<Integer>(1), new TreeNode<Integer>(4), new TreeNode<Integer>(19), new TreeNode<Integer>(5)),
                Arrays.asList(new TreeNode<Integer>(7), new TreeNode<Integer>(6), new TreeNode<Integer>(5), new TreeNode<Integer>(4), new TreeNode<Integer>(3), new TreeNode<Integer>(2), null, new TreeNode<Integer>(1)),
                Arrays.asList(new TreeNode<Integer>(5), new TreeNode<Integer>(4), new TreeNode<Integer>(6), new TreeNode<Integer>(3), new TreeNode<Integer>(2), new TreeNode<Integer>(7), new TreeNode<Integer>(8), new TreeNode<Integer>(1), new TreeNode<Integer>(9)),
                Arrays.asList(new TreeNode<Integer>(5), new TreeNode<Integer>(2), new TreeNode<Integer>(1), new TreeNode<Integer>(6), new TreeNode<Integer>(10), new TreeNode<Integer>(11), new TreeNode<Integer>(44)),
                Arrays.asList(new TreeNode<Integer>(1), new TreeNode<Integer>(2), new TreeNode<Integer>(5), new TreeNode<Integer>(3), new TreeNode<Integer>(4), new TreeNode<Integer>(6)),
                Arrays.asList(new TreeNode<Integer>(-1), new TreeNode<Integer>(-2), null, new TreeNode<Integer>(-5), new TreeNode<Integer>(1), new TreeNode<Integer>(2), null, new TreeNode<Integer>(-6))
        );

        // Create the binary trees using the BinaryTree class
        List<BinaryTree<Integer>> inputTrees = new ArrayList<BinaryTree<Integer>>();
        for (List<TreeNode<Integer>> ListOfNodes : listOfTrees) {
            BinaryTree<Integer> tree = new BinaryTree<Integer>(ListOfNodes);
            inputTrees.add(tree);
        }

        // Print the input trees
        int x = 1;
        for (BinaryTree<Integer> tree : inputTrees) {
            System.out.println(x + ".\tBinary tree:");
            Print.displayTree(tree.root, null);
            flattenTree(tree.root);
            x++;
            System.out.println(new String(new char[100]).replace('\0', '-'));
        }
    }*/
}
