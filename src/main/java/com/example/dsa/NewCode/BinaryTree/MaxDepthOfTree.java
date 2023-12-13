package com.example.dsa.NewCode.BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/*
 * we can use BFS, Recursion
 */
public class MaxDepthOfTree {

    private static int bfs(Node head) {
        Queue<Node> stack = new LinkedList<>();
        Queue<Node> aux = new LinkedList<>();
        int level = 1;
        stack.add(head);

        while (!stack.isEmpty()) {
            Node temp = stack.remove();

            if (temp.left != null) {
                aux.add(temp.left);
            }
            if (temp.right != null) {
                aux.add(temp.right);
            }

            if (stack.isEmpty() && !aux.isEmpty()) {
                stack = aux;
                aux = new LinkedList<>();
                level++;
            }
        }

        return level;
    }

    private static int getmaxHeightRecursion(Node head) {
        if (head == null)
            return 0;

        return 1 + Math.max(getmaxHeightRecursion(head.left), getmaxHeightRecursion(head.right));

    }

    public static void main(String[] args) {

        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(bfs(head));
        System.out.println(getmaxHeightRecursion(head));

    }

}