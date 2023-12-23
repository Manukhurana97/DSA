package com.example.dsa.NewCode.Tree.BinaryTree;

public class CountNumberOfNodesCompleteTree {

    // space and time complexity: O(n)
    private static int countNodes(Node head) {
        if (head == null)
            return 0;

        return 1 + countNodes(head.left) + countNodes(head.right);
    }

    // space : O(n)
    // time complexity: O(log2^n)
    private static int countNodes1(Node head) {

        if (head == null)
            return 0;

        int leftCount = getLeftHeight(head);
        int rightCount = getRightHeight(head);

        if (leftCount == rightCount) {
            return (1 << leftCount) - 1;
        } else {
            return 1 + countNodes1(head.left) + countNodes1(head.right);
        }
    }

    public static int getLeftHeight(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.left;
        }

        return count;
    }

    public static int getRightHeight(Node head) {
        int count = 0;
        while (head != null) {
            count++;
            head = head.right;
        }

        return count;
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
        System.out.println(countNodes1(node));
    }
}
