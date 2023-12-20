package com.example.dsa.NewCode.BinaryTree;

public class CountNumberOfNodesCompleteTree {

    // space and time complexity: O(n)
    private static int countNodes(Node head) {
        if (head == null)
            return 0;

        return 1 + countNodes(head.left) + countNodes(head.right);
    }

    public static void main(String[] args) {
        Node node = new Node(1);
        node.left = new Node(2);
        node.right = new Node(3);
        node.left.left = new Node(4);
        node.left.right = new Node(5);
        node.left.right.left = new Node(6);
        node.left.right.right = new Node(7);

        System.out.println(countNodes(node));
    }
}
