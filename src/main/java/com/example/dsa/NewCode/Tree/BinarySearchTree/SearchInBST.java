package com.example.dsa.NewCode.Tree.BinarySearchTree;

public class SearchInBST {

    private static Node search(Node head, int value) {
        if (head == null)
            return null;
        if (head.value == value)
            return head;

        return search((head.value > value) ? head.left : head.right, value);
    }

    private static Node search1(Node head, int value) {
        while (head != null && head.value != value) {
            head = (head.value > value) ? head.left : head.right;
        }

        return head;
    }

    public static void main(String[] args) {
        Node head = new Node(8);
        head.left = new Node(5);
        head.left.left = new Node(4);
        head.left.right = new Node(7);
        head.left.right.left = new Node(6);
        head.right = new Node(12);
        head.right.left = new Node(10);
        head.right.right = new Node(14);
        head.right.right.left = new Node(13);

        System.out.println(search(head, 7).value);
        System.out.println(search1(head, 7).value);
        System.out.println(search(head, 10).value);
        System.out.println(search1(head, 10).value);
        System.out.println(search(head, 0));
        System.out.println(search1(head, 0));
    }
}
