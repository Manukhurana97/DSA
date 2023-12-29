package com.example.dsa.NewCode.Tree.BinarySearchTree;

public class findLargestBST {

    // iterate each node
    // check if its a bst
    // if BST the calculate the node
    private static int largestBST(Node node) {
        if (node == null)
            return -1;

        int[] largest = { -1 };
        findlargest(node, largest);

        return largest[0];
    }

    private static void findlargest(Node node, int[] largest) {
        if (node == null)
            return;

        if (isBST(node, Integer.MIN_VALUE, Integer.MAX_VALUE)) {
            largest[0] = Math.max(largest[0], countNodes(node));
        }

        findlargest(node.left, largest);
        findlargest(node.right, largest);
    }

    private static boolean isBST(Node node, int start, int end) {

        if (node == null)
            return true;

        if (!(start < node.value && node.value < end))
            return false;

        return (isBST(node.left, start, node.value) && isBST(node.right, node.value, end));

    }

    private static int countNodes(Node node) {
        if (node == null)
            return 0;

        return 1 + countNodes(node.left) + countNodes(node.right);
    }

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(5);
        node.left.left = new Node(1);
        node.left.right = new Node(8);
        node.right = new Node(15);
        node.right.right = new Node(7);

        System.out.println(largestBST(node));
    }
}
