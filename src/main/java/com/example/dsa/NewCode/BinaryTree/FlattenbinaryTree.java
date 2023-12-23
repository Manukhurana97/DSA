package com.example.dsa.NewCode.BinaryTree;

public class FlattenbinaryTree {

    static Node prev = null;

    private static void flatten(Node head) {

        if (head == null)
            return;

        flatten(head.right);
        flatten(head.left);

        head.right = prev;
        head.left = null;
        prev = head;
    }

    private static void display(Node head) {
        while (head != null) {
            System.out.println(head.val);
            head = head.right;
        }
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.left = new Node(2);
        head.left.left = new Node(3);
        head.left.right = new Node(4);
        head.right = new Node(5);
        head.right.right = new Node(6);
        head.right.right.left = new Node(7);

        flatten(head);
        display(head);
    }
}
