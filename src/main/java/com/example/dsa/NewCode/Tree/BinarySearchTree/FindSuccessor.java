package com.example.dsa.NewCode.Tree.BinarySearchTree;

import java.util.*;

public class FindSuccessor {

    // time complexity: O(n) + O(n)
    // space complexity: O(n)
    private static int getSuccessor(Node head, int val) {
        List<Integer> list = new ArrayList<>();
        inOrderTriversal(head, list);

        for (int i = 1; i < list.size() - 1; i++) {
            if (list.get(i - 1) == val) {
                return list.get(i);
            }
        }

        return -1;
    }

    private static void inOrderTriversal(Node node, List<Integer> lst) {
        if (node == null)
            return;

        inOrderTriversal(node.left, lst);
        lst.add(node.value);
        inOrderTriversal(node.right, lst);
    }

    // Time Complexity: O(log n)
    private static int getSuccessor1(Node node, int val) {
        if (node == null || node.value == val)
            return -1;

        return getSuccessorHelper(node, val);
    }

    private static int getSuccessorHelper(Node node, int val) {

        Node prev = node;
        while (node != null) {
            if (node.value == val)
                return prev.value;

            prev = node;
            node = (val < node.value) ? node.left : node.right;
        }

        return -1;

    }

    public static void main(String[] args) {
        Node node = new Node(5);
        node.left = new Node(3);
        node.left.left = new Node(2);
        node.left.left.left = new Node(1);
        node.left.right = new Node(4);
        node.right = new Node(7);
        node.right.left = new Node(6);
        node.right.right = new Node(9);
        node.right.right.left = new Node(8);
        node.right.right.right = new Node(10);

        System.out.println(getSuccessor(node, 6));
        System.out.println(getSuccessor1(node, 6));
    }

}
