package com.example.dsa.NewCode.Tree.BinarySearchTree;

public class CeilInBST {

    private static int getCeil(Node head, int key) {
        int[] ceil = { Integer.MAX_VALUE };
        getCeilHelper(head, key, ceil);

        return ceil[0];
    }

    private static void getCeilHelper(Node head, int key, int[] ceil) {

        if (head == null)
            return;

        if (key < head.value)
            ceil[0] = Math.min(ceil[0], head.value);

        getCeilHelper(key < head.value ? head.left : head.right, key, ceil);

    }

    private static int getCeil1(Node head, int key) {
        int ceil = -1;

        while (head != null) {
            if (key == head.value)
                return ceil;

            if (key < head.value) {
                ceil = head.value;
                head = head.left;
            } else {
                head = head.right;
            }
        }
        return ceil;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.left = new Node(5);
        head.left.left = new Node(3);
        head.left.left.left = new Node(2);
        head.left.left.right = new Node(4);
        head.left.right = new Node(6);
        head.left.right.right = new Node(9);
        head.right = new Node(13);
        head.right.left = new Node(11);
        head.right.right = new Node(14);

        System.out.println(getCeil(head, 8));
        System.out.println(getCeil1(head, 8));
    }

}
