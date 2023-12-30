package com.example.dsa.NewCode.Tree.BinarySearchTree;

class Result {
    int size;
    int min;
    int max;

    Result(int size, int min, int max) {
        this.size = size;
        this.min = min;
        this.max = max;
    }
}

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

    /*------------------------------------------------------ CASE 2 -----------------------------------------------------------------*/

    private static int largestBST1(Node node) {
        if (node == null)
            return 0;

        return largestBST1Helper(node).size;
    }

    private static Result largestBST1Helper(Node node) {
        if (node == null) {
            return new Result(0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        Result lr = largestBST1Helper(node.left);
        Result rr = largestBST1Helper(node.right);

        // if a validate bst
        if (lr.max < node.value && node.value < rr.min) {
            return new Result((1 + lr.size + rr.size), Math.min(node.value, lr.min), Math.max(node.value, rr.max));
        }
        // if current tree is not BST
        return new Result(Math.max(lr.size, rr.size), Integer.MIN_VALUE, Integer.MAX_VALUE);

    }

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(5);
        node.left.left = new Node(1);
        node.left.right = new Node(8);
        node.right = new Node(15);
        node.right.right = new Node(7);

        System.out.println(largestBST(node));
        System.out.println(largestBST1(node));
    }
}
