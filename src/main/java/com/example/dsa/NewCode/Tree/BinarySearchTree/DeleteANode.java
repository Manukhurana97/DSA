package com.example.dsa.NewCode.Tree.BinarySearchTree;

public class DeleteANode {

    private static void deleteNode(Node head, int val) {

        if (head == null)
            return;

        Node current = head;
        Node prev = head;

        while (current != null && current.value != val) {
            prev = current;
            current = (val < current.value) ? current.left : current.right;
        }

        if (current == null) {
            return;
        }

        Node rightNode = (current.right != null) ? current.right : null;
        Node leftNode = (current.left != null) ? current.left : null;
        prev.left = leftNode;

        while (leftNode != null) {
            prev = leftNode;
            leftNode = leftNode.right;
        }

        prev.right = rightNode;

    }

    private static void display(Node head) {
        if (head == null)
            return;

        display(head.left);
        System.out.print(head.value + " ");
        display(head.right);
    }

    public static void main(String[] args) {
        Node head = new Node(8);
        head.left = new Node(5);
        head.left.left = new Node(2);
        head.left.left.left = new Node(1);
        head.left.left.right = new Node(3);
        head.left.left.right.right = new Node(4);
        head.left.right = new Node(7);
        head.left.right.left = new Node(6);
        head.left.right.right = new Node(8);
        head.right = new Node(12);
        head.right.left = new Node(10);
        head.right.right = new Node(13);

        deleteNode(head, 5);
        display(head);
    }
}
