package com.example.dsa.NewCode.BinaryTree;

public class ChildrenSumProperty {

    public static void changeTree(Node head) {
        if (head == null)
            return;

        int childSum = 0;
        if (head.left != null)
            childSum += head.left.val;
        if (head.right != null)
            childSum += head.left.val;
        head.val = Math.max(head.val, childSum);

        changeTree(head.left);
        changeTree(head.right);

        childSum = 0;
        if (head.left != null)
            childSum += head.left.val;
        if (head.right != null)
            childSum += head.left.val;
        head.val = Math.max(head.val, childSum);
    }

    private static void display(Node head) {
        if (head == null)
            return;

        display(head.left);
        System.out.println(head.val);
        display(head.right);
    }

    public static void main(String[] args) {
        Node head = new Node(50);
        head.left = new Node(7);
        head.left.left = new Node(3);
        head.left.right = new Node(5);
        head.right = new Node(2);
        head.right.left = new Node(1);
        head.right.right = new Node(31);

        changeTree(head);
        display(head);
    }
}
