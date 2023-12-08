package com.example.dsa.NewCode.BinaryTree;

/**
 * Node
 */
class Node {

    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }

}

/**
 * CheckBalanceTree: check if tree is balance
 * check the height of left and right subtree
 * at any point if height of left and right subtree diff is greater then 1,
 * then its not a binary tree
 */
public class CheckBalanceTree {

    private static boolean isBalanced(Node head) {
        if (head == null)
            return true;

        int leftHeight = getHeight(head.left);
        int rightHeight = getHeight(head.right);

        return Math.abs(leftHeight - rightHeight) <= 1 && isBalanced(head.left) && isBalanced(head.right);

    }

    private static int getHeight(Node head) {
        if (head == null)
            return 0;

        return 1 + Math.max(getHeight(head.left), getHeight(head.right));
    }

    private static boolean isBalanced1(Node head) {
        return isBalanced1helper(head) != -1;
    }

    private static int isBalanced1helper(Node head) {
        if (head == null)
            return 0;

        int leftHeight = isBalanced1helper(head.left);
        int rightHeight = isBalanced1helper(head.right);

        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;

        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        head.right.right.right = new Node(8);

        System.out.println(isBalanced(head));
        System.out.println(isBalanced1(head));
    }
}