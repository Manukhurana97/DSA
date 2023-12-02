package com.example.dsa.NewCode.BinaryTree;

public class BinaryTree {

    class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
        }

        public Node(int data, Node left, Node right) {
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        BinaryTree.Node head = tree.new Node(1);
        head.left = tree.new Node(2);
        head.right = tree.new Node(3);
        head.left.left = tree.new Node(4);
        head.left.right = tree.new Node(5);
        head.right.left = tree.new Node(6);
        head.right.right = tree.new Node(7);

    }
}
