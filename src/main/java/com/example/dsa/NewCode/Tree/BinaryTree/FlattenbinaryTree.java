package com.example.dsa.NewCode.Tree.BinaryTree;

import java.util.*;

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

    private static void flatten1(Node head) {
        Stack<Node> stack = new Stack<>();
        stack.add(head);

        while (!stack.isEmpty()) {
            Node node = stack.pop();

            if (node.right != null)
                stack.add(node.right);
            if (node.left != null) {
                stack.add(node.left);
            }
            if (!stack.isEmpty())
                node.right = stack.peek();
            node.left = null;
        }
    }

    private static void flatten2(Node head) {
        while (head != null) {
            if (head.left != null) {
                Node prev = head.left;
                while (prev.right != null) {
                    prev = prev.right;
                }

                prev.right = head.right;
                head.right = head.left;
                head.left = null;
            }
            head = head.right;

        }

    }

    private static void display(Node head) {
        while (head != null) {
            System.out.print(head.val + " ");
            head = head.right;
        }
        System.out.println();
    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.left = new Node(2);
        head.left.left = new Node(3);
        head.left.right = new Node(4);
        head.right = new Node(5);
        head.right.right = new Node(6);
        head.right.right.left = new Node(7);

        // flatten(head);
        // display(head);
        // flatten1(head);
        // display(head);
        flatten2(head);
        display(head);
    }
}
