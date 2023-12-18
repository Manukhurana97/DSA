package com.example.dsa.NewCode.BinaryTree;

public class CheckIdenticalTree {

    private static boolean validate(Node h1, Node h2) {

        if (h1 == null && h2 != null || h1 != null && h2 == null)
            return false;
        if (h1 == null && h2 == null)
            return true;
        if (h1.val != h2.val)
            return false;

        return validate(h1.left, h2.left) && validate(h1.right, h2.right);
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);

        Node head1 = new Node(1);
        head1.left = new Node(2);
        head1.right = new Node(3);
        head1.left.left = new Node(4);
        head1.left.right = new Node(5);
        head1.right.left = new Node(6);

        System.out.println(validate(head, head1));
    }

}
