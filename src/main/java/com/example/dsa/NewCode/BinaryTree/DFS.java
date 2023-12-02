package com.example.dsa.NewCode.BinaryTree;

public class DFS {

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

    /*
     * Inorder traversal: (left, root, right)
     */
    public static void inOrderTraversal(Node node) {
        if (node == null)
            return;

        inOrderTraversal(node.left);
        System.out.print(node.data + " ");
        inOrderTraversal(node.right);
    }

    /*
     * Inorder traversal: (root, left, right)
     */
    public static void preOrderTraversal(Node node) {
        if (node == null)
            return;

        System.out.print(node.data + " ");
        preOrderTraversal(node.left);
        preOrderTraversal(node.right);
    }

    /*
     * Inorder traversal: (left, right, root)
     */
    public static void postOrderTraversal(Node node) {
        if (node == null)
            return;

        postOrderTraversal(node.left);
        postOrderTraversal(node.right);
        System.out.print(node.data + " ");
    }

    public static void main(String[] args) {
        DFS tree = new DFS();
        DFS.Node head = tree.new Node(1);
        head.left = tree.new Node(2);
        head.right = tree.new Node(3);
        head.left.left = tree.new Node(4);
        head.left.right = tree.new Node(5);
        head.right.left = tree.new Node(6);
        head.right.right = tree.new Node(7);

        inOrderTraversal(head);
        System.out.println();
        preOrderTraversal(head);
        System.out.println();
        postOrderTraversal(head);
    }
}
