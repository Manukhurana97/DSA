package com.example.dsa.NewCode.BinaryTree;

public class ChildrenSumProperty {
    public static void main(String[] args) {
        Node head = new Node(50);
        head.left = new Node(7);
        head.left.left = new Node(3);
        head.left.right = new Node(5);
        head.right = new Node(2);
        head.right.left = new Node(1);
        head.right.right = new Node(31);
    }
}
