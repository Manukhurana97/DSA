package com.example.dsa.NewCode.Tree.BinarySearchTree;

public class InsertNodeInBST {

    private static void insertInBST(Node head, int value) {
        Node newNode = new Node(value);

        if (head == null)
            return;

        Node prev = head;
        Node current = head;

        while (current != null) {
            prev = current;
            current = (value < current.value) ? current.left : current.right;
        }
        if (prev.value > value) {
            prev.left = newNode;
        } else {
            prev.right = newNode;
        }

    }

    private static void display(Node head) {
        if (head == null)
            return;

        display(head.left);
        System.out.print(head.value + " ");
        display(head.right);
    }

    public static void main(String[] args) {
        Node node = new Node(4);
        node.left = new Node(2);
        node.left.left = new Node(1);
        node.left.right = new Node(3);
        node.right = new Node(7);

        insertInBST(node, 5);
        display(node);
        System.out.println();
        insertInBST(node, 6);
        display(node);
    }
}
