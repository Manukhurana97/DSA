package com.example.dsa.NewCode.Tree.BinaryTree;

import java.util.*;

class Details {
    int num;
    Node node;

    Details(int num, Node node) {
        this.num = num;
        this.node = node;
    }
}

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node left, Node right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class PreOrderPostOrderInOrder {

    public static void getOrders(Node head) {

        Stack<Details> stack = new Stack<>();
        stack.push(new Details(1, head));

        List<Integer> preOrder = new ArrayList<>();
        List<Integer> inOrder = new ArrayList<>();
        List<Integer> postOrder = new ArrayList<>();

        while (!stack.isEmpty()) {
            Details d = stack.pop();

            if (d.num == 1) {
                preOrder.add(d.node.val);
                d.num++;
                stack.add(d);

                if (d.node.left != null)
                    stack.add(new Details(1, d.node.left));
            } else if (d.num == 2) {
                inOrder.add(d.node.val);
                d.num++;
                stack.add(d);

                if (d.node.right != null)
                    stack.add(new Details(1, d.node.right));
            } else {
                postOrder.add(d.node.val);
            }
        }

        System.out.println(preOrder);
        System.out.println(inOrder);
        System.out.println(postOrder);

    }

    public static void main(String[] args) {
        PreOrderPostOrderInOrder tree = new PreOrderPostOrderInOrder();
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        getOrders(head);
    }

}

/*
 * 4 2 5 1 6 3 7
 * 4 2 5 1 6 3 7
 * 1 2 4 5 3 6 7
 * 1 2 4 5 3 6 7
 * 4 5 2 6 7 3 1
 * 4 5 2 6 7 3 1
 * 6 5 4 3 2 8 7 1
 */