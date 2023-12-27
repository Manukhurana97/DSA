package com.example.dsa.NewCode.Tree.BinarySearchTree;

public class CheckIfTreeIsBST {

    private static boolean isBST(Node head) {
        if (head == null)
            return false;

        return isBST(head, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBST(Node node, int start, int end) {
        if (node == null)
            return true;

        if (start > node.value || node.value > end) {
            return false;
        }

        return (isBST(node.left, start, node.value) && isBST(node.right, node.value, end));

    }

    public static void main(String[] args) {
        Node node = new Node(13);
        node.left = new Node(10);
        node.left.left = new Node(7);
        node.left.left.right = new Node(9);
        node.left.left.right.right = new Node(8);
        node.left.left = new Node(7);
        node.left.right = new Node(12);
        node.right = new Node(15);
        node.right.left = new Node(14);
        node.right.right = new Node(17);
        node.right.right.left = new Node(16);

        System.out.println(isBST(node));
    }

}

//
