package com.example.dsa.NewCode.Tree.BinarySearchTree;

import java.util.Stack;

//   get next element in inorder fashion and also check if has next element in list
public class BinarySearchTreeIterator {

    Stack<Node> stack = new Stack<>();

    BinarySearchTreeIterator(Node node) {
        populateStackLeft(node);
    }

    private void populateStackLeft(Node node) {
        while (node != null) {
            stack.push(node);
            node = node.left;
        }
    }

    private void populateStackRight(Node node) {
        if (node.right != null) {
            node = node.right;
            populateStackLeft(node);
        }
    }

    private int next() {
        if (stack.isEmpty())
            return -1;
        Node node = stack.pop();
        populateStackRight(node);

        return node.value;
    }

    private boolean hasNext() {
        return !stack.isEmpty();
    }

    public static void main(String[] args) {
        Node head = new Node(7);
        head.left = new Node(3);
        head.left.left = new Node(2);
        head.left.left.left = new Node(1);
        head.left.right = new Node(6);
        head.left.right.left = new Node(5);
        head.left.right.left.left = new Node(4);
        head.right = new Node(10);
        head.right.left = new Node(9);
        head.right.left.left = new Node(8);

        BinarySearchTreeIterator tree = new BinarySearchTreeIterator(head);
        System.out.println(tree.next());
        System.out.println(tree.next());
        System.out.println(tree.hasNext());
        System.out.println(tree.next());
        System.out.println(tree.next());
        System.out.println(tree.next());
        System.out.println(tree.next());
        System.out.println(tree.next());
        System.out.println(tree.next());
        System.out.println(tree.next());
        System.out.println(tree.next());
        System.out.println(tree.next());
        System.out.println(tree.hasNext());

    }

}
