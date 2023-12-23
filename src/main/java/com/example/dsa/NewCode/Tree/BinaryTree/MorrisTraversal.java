package com.example.dsa.NewCode.Tree.BinaryTree;

import java.util.ArrayList;

public class MorrisTraversal {

    private static ArrayList<Integer> traverse(Node head) {
        ArrayList<Integer> list = new ArrayList<>();

        Node current = head;

        while (current != null) {
            System.out.println(current.val);
            if (current.left == null) {
                list.add(current.val); // <--
                current = current.right; // reach the child , move to parent using the new aux connection created
            } else {
                Node prev = current.left;
                while (prev.right != null && prev.right != current) { // move to extreme right to create / break the aux
                    prev = prev.right;
                }

                if (prev.right == null) {
                    prev.right = current; // create a new aux connection to parent
                    current = current.left; // continue current to left
                } else {
                    prev.right = null; // break the aux connection
                    list.add(current.val); // <--
                    current = current.right; // send the parent to the right after breaking the aux connection.
                }

            }
        }

        return list;
    }

    public static void main(String[] args) {
        Node head = new Node(10);
        head.left = new Node(5);
        head.left.left = new Node(2);
        head.left.right = new Node(7);
        head.right = new Node(15);
        head.right.right = new Node(30);

        System.out.println(traverse(head));
    }
}
