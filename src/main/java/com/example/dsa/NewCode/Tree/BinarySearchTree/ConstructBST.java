package com.example.dsa.NewCode.Tree.BinarySearchTree;

import java.util.Arrays;

/*
* Construct BST from preOrder
*/
public class ConstructBST {

    // time complexity: O(n^2)
    // space complexity: O(1)
    private static Node construct(int[] preOrder) {
        if (preOrder.length == 0)
            return null;

        int i = 0;
        Node head = new Node(preOrder[i++]);

        while (i < preOrder.length) {
            int value = preOrder[i++];
            Node node = new Node(value);
            Node current = head;
            Node prev = current;

            while (current != null) {
                prev = current;
                current = (value < current.value) ? current.left : current.right;
            }

            if (value < prev.value) {
                prev.left = node;
            } else {
                prev.right = node;
            }
        }

        return head;
    }

    // time complexity: O(n)
    // space complexity: O(1)
    private static Node construct1(int[] perOrder) {
        return null;
    }

    private static void display(Node head) {
        if (head == null)
            return;

        display(head.left);
        System.out.print(head.value + " ");
        display(head.right);
    }

    public static void main(String[] args) {

        Node node = construct(new int[] { 8, 5, 1, 7, 10, 12 });
        display(node);
    }

}
