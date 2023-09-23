package com.leetcode.recursion;

import com.leetcode.recursion.misc.DoublyLinkedList;
import com.leetcode.recursion.misc.TreeNode;

public class LeetCode_426 {

    public static DoublyLinkedList head = null;
    public static DoublyLinkedList prev = null;
    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(15);
        n1.left = new TreeNode(10);
        n1.left.left = new TreeNode(6);
        n1.left.right = new TreeNode(12);

        n1.right = new TreeNode(27);
        n1.right.left = new TreeNode(18);
        n1.right.right = new TreeNode(32);
        convertBSTToDoublyLinkedList(n1);
        DoublyLinkedList present = head;
        while(present != null) {
            System.out.println(present.val);
            present = present.next;
        }
    }

    private static void convertBSTToDoublyLinkedList(TreeNode n1) {

        if(n1 == null) {
            return;
        }

        convertBSTToDoublyLinkedList(n1.left);
        if(prev == null) {
            prev = new DoublyLinkedList(n1.val);
            head = prev;
        }else {
            DoublyLinkedList curent = new DoublyLinkedList(n1.val);
            prev.next = curent;
            curent.prev = prev;
            prev = curent;
        }
        convertBSTToDoublyLinkedList(n1.right);
    }

}
