package com.example.dsa.NewCode.Tree.BinarySearchTree;

// there are 2 element incorrect pleace in bst , swap these element .

public class RecoverBST {

    Node firstViolation;
    Node helperForFirstViolation;
    Node secondViolation;
    Node prev;

    private void inorderTriversal(Node node) {
        if (node == null)
            return;

        inorderTriversal(node.left);

        if (prev != null && (node.value < prev.value)) {

            if (firstViolation == null) {
                helperForFirstViolation = prev;
                firstViolation = node;
            } else {
                secondViolation = node;
            }
        }
        prev = node;
        inorderTriversal(node.right);
    }

    private void recoverTree(Node node) {
        firstViolation = secondViolation = helperForFirstViolation = prev = null;

        inorderTriversal(node);

        if (firstViolation != null && secondViolation != null) {
            swap(firstViolation, secondViolation);
        } else if (firstViolation != null && helperForFirstViolation != null) {
            swap(firstViolation, helperForFirstViolation);
        }
    }

    private void swap(Node node1, Node node2) {
        int temp = node1.value;
        node1.value = node2.value;
        node2.value = temp;
    }

    private static void display(Node head) {
        if (head == null)
            return;

        display(head.left);
        System.out.print(head.value + " ");
        display(head.right);
    }

    public static void main(String[] args) {
        Node node = new Node(3);
        node.left = new Node(1);
        node.right = new Node(4);
        node.right.right = new Node(2);

        RecoverBST recoverBST = new RecoverBST();
        recoverBST.display(node);
        recoverBST.recoverTree(node);
        recoverBST.display(node);
    }
}
