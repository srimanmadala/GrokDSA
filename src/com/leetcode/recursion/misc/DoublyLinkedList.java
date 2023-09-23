package com.leetcode.recursion.misc;

public class DoublyLinkedList {
    public int val;
    public DoublyLinkedList prev;
    public DoublyLinkedList next;
    DoublyLinkedList() {}
    public DoublyLinkedList(int val) { this.val = val; }
    public DoublyLinkedList(int val, DoublyLinkedList left, DoublyLinkedList right) {
        this.val = val;
        this.prev = left;
        this.next = right;
    }
}
