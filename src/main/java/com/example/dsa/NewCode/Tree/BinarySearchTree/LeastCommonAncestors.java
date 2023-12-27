package com.example.dsa.NewCode.Tree.BinarySearchTree;

public class LeastCommonAncestors {

    private static Node findLCA(Node node, int i, int j) {
        if (node == null || (i < node.value && node.value < j) || (i == node.value || j == node.value)) {
            return node;
        }

        return findLCA(i < node.value && j < node.value ? node.left : node.right, i, j);
    }

    public static void main(String[] args) {
        Node node = new Node(10);
        node.left = new Node(4);
        node.left.left = new Node(3);
        node.left.left.left = new Node(1);
        node.left.left.left = new Node(2);
        node.left.right = new Node(8);
        node.left.right.right = new Node(9);
        node.right = new Node(13);
        node.right.left = new Node(11);
        node.right.right = new Node(15);

        System.out.println(findLCA(node, 5, 9).value);
        System.out.println(findLCA(node, 4, 9).value);
    }

}
