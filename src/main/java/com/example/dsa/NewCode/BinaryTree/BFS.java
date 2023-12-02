package com.example.dsa.NewCode.BinaryTree;

import java.util.*;

/*
 level order triversal
*/
public class BFS {
    class Node {
        int value;
        Node left;
        Node right;

        Node(int val) {
            this.value = val;
        }

        Node(int val, Node left, Node right) {
            this.value = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void display(Node head) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            System.out.print(temp.value + " ");

            if (temp.left != null)
                queue.add(temp.left);
            if (temp.right != null)
                queue.add(temp.right);

        }
    }

    public static void display1(Node head) {
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> aux = new LinkedList<>();
        queue.add(head);
        int level = 0;

        while (!queue.isEmpty()) {
            Node temp = queue.remove();
            System.out.println(temp.value + ":" + level);

            if (temp.left != null)
                aux.add(temp.left);
            if (temp.right != null)
                aux.add(temp.right);

            if (queue.isEmpty() && !aux.isEmpty()) {
                queue = aux;
                aux = new LinkedList<>();
                level++;
            }
        }
    }

    public static void main(String[] args) {
        BFS tree = new BFS();
        BFS.Node head = tree.new Node(1);
        head.left = tree.new Node(2);
        head.right = tree.new Node(3);
        head.left.left = tree.new Node(4);
        head.left.right = tree.new Node(5);
        head.right.left = tree.new Node(6);
        head.right.right = tree.new Node(7);

        display(head);
        System.out.println();
        display1(head);
    }
}
