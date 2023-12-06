package com.example.dsa.NewCode.BinaryTree;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class MaxPathSum {

    public static int getMaxSum(Node head) {
        return 0;
    }

    public static void main(String[] args) {
        Node head = new Node(-10);
        head.left = new Node(9);
        head.right = new Node(20);
        head.right.left = new Node(15);
        head.right.right = new Node(7);

        System.out.println(getMaxSum(head));
    }

}
