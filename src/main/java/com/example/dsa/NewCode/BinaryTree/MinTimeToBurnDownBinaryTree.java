package com.example.dsa.NewCode.BinaryTree;

import java.util.*;

public class MinTimeToBurnDownBinaryTree {

    private static int findMinTime(Node head, Node startNode) {

        if (startNode == null || head == null)
            return 0;

        Map<Node, Node> parentMap = new HashMap<>();
        getParent(head, parentMap);

        Set<Node> isVisiNodes = new HashSet<>();
        isVisiNodes.add(startNode);
        Queue<Node> queue = new LinkedList<>();
        queue.add(startNode);
        Queue<Node> aux = new LinkedList<>();
        int time = 0;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (currentNode.left != null && !isVisiNodes.contains(currentNode.left)) {
                isVisiNodes.add(currentNode.left);
                aux.add(currentNode.left);
            }
            if (currentNode.right != null && !isVisiNodes.contains(currentNode.right)) {
                isVisiNodes.add(currentNode.right);
                aux.add(currentNode.right);
            }

            if (parentMap.containsKey(currentNode) && !isVisiNodes.contains(parentMap.get(currentNode))) {
                isVisiNodes.add(parentMap.get(currentNode));
                aux.add(parentMap.get(currentNode));
            }

            if (queue.isEmpty() && !aux.isEmpty()) {
                queue = aux;
                aux = new LinkedList<>();
                time++;
            }
        }

        return time;
    }

    private static void getParent(Node head, Map<Node, Node> parentMap) {
        if (head == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();

            if (currentNode.left != null) {
                parentMap.put(currentNode.left, currentNode);
                queue.add(currentNode.left);
            }

            if (currentNode.right != null) {
                parentMap.put(currentNode.right, currentNode);
                queue.add(currentNode.right);
            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.left.left = new Node(4);
        head.left.left.right = new Node(7);
        head.right = new Node(3);
        head.right.left = new Node(5);
        head.right.right = new Node(6);
        head.right.right.right = new Node(8);
        head.right.right.right.right = new Node(9);

        System.out.println(findMinTime(head, head.left));
    }
}
