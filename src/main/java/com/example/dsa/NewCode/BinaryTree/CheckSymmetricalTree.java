package com.example.dsa.NewCode.BinaryTree;

public class CheckSymmetricalTree {

    public static boolean isSymmetricalTree(Node head) {
        if (head == null)
            return true;

        return checkLeafTree(head.left, head.right);
    }

    public static boolean checkLeafTree(Node left, Node right) {
        if ((left == null && right == null))
            return true;

        if (left == null || right == null || left.val != right.val)
            return false;

        return checkLeafTree(left.left, right.right) && checkLeafTree(left.right, right.left);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(isSymmetricalTree(head));
    }
}
