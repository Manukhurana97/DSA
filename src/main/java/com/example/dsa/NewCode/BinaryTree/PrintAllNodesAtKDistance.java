package com.example.dsa.NewCode.BinaryTree;

import java.util.*;

public class PrintAllNodesAtKDistance {

    public static List<Integer> getNodes(Node node, Node target, int k) {
        Map<Node, Node> parents = new HashMap<>();
        getParent(node, parents); // get the parent node of all the current as we iterte back

        Set<Node> visited = new HashSet<>(); // to keep the track which node is visited
        visited.add(target);

        Queue<Node> queue = new LinkedList<>(); // to preform bfs
        queue.add(target);

        while (!queue.isEmpty() && k > 0) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                Node currentNode = queue.poll();

                if (currentNode.left != null && !visited.contains(currentNode.left)) {
                    queue.add(currentNode.left);
                    visited.add(currentNode.left);
                }
                if (currentNode.right != null && !visited.contains(currentNode.right)) {
                    queue.add(currentNode.right);
                    visited.add(currentNode.right);
                }
                if (parents.containsKey(currentNode) && !visited.contains(parents.get(currentNode))) {
                    queue.add(parents.get(currentNode));
                    visited.add(parents.get(currentNode));
                }
            }

            k--;
        }
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.poll().val);
        }

        return result;
    }

    private static void getParent(Node head, Map<Node, Node> map) {
        if (head == null)
            return;

        Queue<Node> queue = new LinkedList<>();
        queue.add(head);

        while (!queue.isEmpty()) {
            var node = queue.poll();

            if (node.left != null) {
                map.put(node.left, node);
                queue.add(node.left);
            }

            if (node.right != null) {
                map.put(node.right, node);
                queue.add(node.right);
            }

        }

    }

    public static void main(String[] args) {
        Node head = new Node(3);
        head.left = new Node(5);
        head.left.left = new Node(6);
        head.left.right = new Node(2);
        head.left.right.left = new Node(7);
        head.left.right.right = new Node(4);
        head.right = new Node(1);
        head.right.left = new Node(0);
        head.right.right = new Node(8);

        System.out.println(getNodes(head, head.left, 2));
    }

}
