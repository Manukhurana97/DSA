package com.example.dsa.NewCode.BinaryTree;

public class Node {
    int val;
    Node left;
    Node right;

    Node() {
    }

    Node(int val) {
        this.val = val;
    }

    public static void displayInOrder(Node head) {
        if (head == null)
            return;

        displayInOrder(head.left);
        System.out.println(head.val);
        displayInOrder(head.right);
    }
}
