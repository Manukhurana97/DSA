package com.example.dsa.NewCode.BinaryTree;

import java.util.*;

public class VerticalOrderTraversal {

    public static List<Integer> verticalOrder(Node head) {

        PriorityQueue<NodeDetails> queue = new PriorityQueue<>(
                Comparator.comparingInt((NodeDetails dd) -> dd.order).thenComparing((dd) -> dd.level));

        getOrder(head, queue);

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            var nn = queue.poll();
            result.add(nn.node.val);
        }
        return result;
    }

    public static void getOrder(Node head, PriorityQueue<NodeDetails> pqueue) {
        int level = 0;

        Queue<NodeDetails> queue = new LinkedList<>();
        Queue<NodeDetails> auxQueue = new LinkedList<>();
        queue.add(new NodeDetails(level, 0, head));

        while (!queue.isEmpty()) {
            var nn = queue.poll();
            int order = nn.order;
            pqueue.add(new NodeDetails(level, nn.order, nn.node));

            if (nn.node.left != null)
                auxQueue.add(new NodeDetails(level, order - 1, nn.node.left));

            if (nn.node.right != null)
                auxQueue.add(new NodeDetails(level, order + 1, nn.node.right));

            if (queue.isEmpty()) {
                queue = auxQueue;
                auxQueue = new LinkedList<>();
                level++;
            }

        }
    }

    public static List<Integer> verticalOrder1(Node head) {
        List<Integer> result = new ArrayList<>();
        if (head == null)
            return result;

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<NodeDetails> queue = new LinkedList<>();
        queue.add(new NodeDetails(0, 0, head));

        while (!queue.isEmpty()) {
            var nn = queue.poll();
            int order = nn.order;
            int level = nn.level;

            map.computeIfAbsent(order, k -> new ArrayList<>()).add(nn.node.val);

            if (nn.node.left != null)
                queue.add(new NodeDetails(level + 1, order - 1, nn.node.left));

            if (nn.node.right != null)
                queue.add(new NodeDetails(level + 1, order + 1, nn.node.right));

        }

        System.out.println(map);
        for (List<Integer> value : map.values()) {
            result.addAll(value);
        }

        return result;
    }

    public static void main(String[] args) {
        // Node head = new Node(1);
        // head.left = new Node(2);
        // head.right = new Node(3);
        // head.left.left = new Node(4);
        // head.left.right = new Node(5);
        // head.right.left = new Node(6);
        // head.right.right = new Node(7);
        // head.right.right.left = new Node(8);
        // head.right.right.right = new Node(9);

        // System.out.println(verticalOrder(head));
        // System.out.println(verticalOrder1(head));

        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.left.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(verticalOrder(head));
        System.out.println(verticalOrder1(head));

    }

}
// 1
// 2 3
// 4 5 6 7
// 8
// 9