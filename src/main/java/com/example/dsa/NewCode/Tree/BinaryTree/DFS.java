package com.example.dsa.NewCode.Tree.BinaryTree;

import java.util.*;

public class DFS {

    /*
     * Inorder traversal: (left, root, right)
     */
    public static void inOrderTraversal(Node node) {
        if (node == null)
            return;

        inOrderTraversal(node.left);
        System.out.print(node.val + " ");
        inOrderTraversal(node.right);
    }

    public static void inOrderTraversal1(Node node) {
        Stack<Node> stack = new Stack<>();
        Node current = node;
        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.add(current);
                current = current.left;
            }

            current = stack.pop();
            System.out.print(current.val + " ");

            current = current.right;
        }
    }

    /*
     * preorder traversal: (root, left, right)
     */
    public static void preOrderTraversal(Node node) {
        if (node == null)
            return;

        System.out.print(node.val + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    public static void preOrderTraversal1(Node node) {
        Stack<Node> stack = new Stack<>();
        stack.add(node);

        while (!stack.isEmpty()) {
            Node temp = stack.pop();
            System.out.print(temp.val + " ");

            if (temp.right != null)
                stack.add(temp.right);
            if (temp.left != null)
                stack.add(temp.left);
        }
    }

    /*
     * postorder traversal: (left, right, root)
     */
    public static void postOrderTraversal(Node node) {
        if (node == null)
            return;

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.val + " ");
    }

    public static void postOrderTraversal1(Node node) {

        Stack<Node> stack1 = new Stack<>();
        Stack<Node> stack2 = new Stack<>();
        stack1.add(node);

        while (!stack1.isEmpty()) {
            Node aux = stack1.pop();
            stack2.add(aux);

            if (aux.left != null)
                stack1.add(aux.left);
            if (aux.right != null)
                stack1.add(aux.right);

        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().val + " ");
        }
    }

    /*
     * using 1 stack
     */
    public static void postOrderTraversal2(Node node) {

        Node current = node;
        Node prev = null;
        Stack<Node> stack = new Stack<>();

        while (current != null || !stack.isEmpty()) {
            while (current != null) {
                stack.push(current);
                current = current.left;
            }

            current = stack.peek();
            if (current.right == null || current.right == prev) {
                System.out.print(current.val + " ");
                stack.pop();
                prev = current;
                current = null;
            } else {
                current = current.right;
            }
        }

    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        Node head1 = new Node(1);
        head1.left = new Node(2);
        head1.left.left = new Node(3);
        head1.left.left.right = new Node(4);
        head1.left.left.right.right = new Node(5);
        head1.left.left.right.right.right = new Node(6);
        head1.right = new Node(7);
        head1.right.left = new Node(8);

        System.out.println("In Order");
        inOrderTraversal(head);
        System.out.println();
        inOrderTraversal1(head);
        System.out.println();
        System.out.println("Pre Order");
        preOrderTraversal(head);
        System.out.println();
        preOrderTraversal1(head);
        System.out.println();
        System.out.println("Post Order");
        postOrderTraversal(head);
        System.out.println();
        postOrderTraversal1(head);
        System.out.println();
        postOrderTraversal2(head1);
    }
}
