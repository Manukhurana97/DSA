package com.example.dsa.NewCode.BinaryTree;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

public class DiameterOfTree {

    public static int getDiameter(Node head) {
        int diameter[] = new int[1];
        // getDiameter(head, diameter);
        getDiameter1(head, diameter);

        return diameter[0];
    }

    public static int getDiameter(Node head, int[] max) {

        if (head == null)
            return 0;

        int leftHeight = getHeight(head.left);
        int rightHeight = getHeight(head.right);

        max[0] = Math.max(max[0], (leftHeight + rightHeight + 1));

        return Math.max(getDiameter(head.left, max), getDiameter(head.right, max));
    }

    public static int getHeight(Node head) {
        if (head == null)
            return 0;

        return 1 + Math.max(getHeight(head.left), getHeight(head.right));
    }

    /**/
    public static int getDiameter1(Node head, int[] diameter) {
        if (head == null)
            return 0;

        int leftHeight = getDiameter1(head.left, diameter);
        int rightHeight = getDiameter1(head.right, diameter);

        diameter[0] = Math.max(diameter[0], (leftHeight + rightHeight + 1));
        return 1 + Math.max(leftHeight, rightHeight);

    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);

        System.out.println(getDiameter(head));
    }
}
