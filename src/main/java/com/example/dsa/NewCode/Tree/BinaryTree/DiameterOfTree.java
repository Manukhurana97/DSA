package com.example.dsa.NewCode.Tree.BinaryTree;

public class DiameterOfTree {

    private static int getDiameter(Node head) {
        int diameter[] = new int[1];
        getDiameter(head, diameter);
        // getDiameter1(head, diameter);

        return diameter[0];
    }

    private static int getDiameter(Node head, int[] max) {

        if (head == null)
            return 0;

        int leftHeight = getHeight(head.left);
        int rightHeight = getHeight(head.right);

        max[0] = Math.max(max[0], (leftHeight + rightHeight + 1));

        return Math.max(getDiameter(head.left, max), getDiameter(head.right, max));
    }

    private static int getHeight(Node head) {
        if (head == null)
            return 0;

        return 1 + Math.max(getHeight(head.left), getHeight(head.right));
    }

    /**/
    private static int getDiameter1(Node head, int[] diameter) {
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
        int[] diameter = { 0 };
        getDiameter1(head, diameter);
        System.out.println(diameter[0]);
    }
}
