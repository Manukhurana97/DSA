package com.example.dsa.NewCode.BinaryTree;

import java.util.*;

class Node {
    int val;
    Node left;
    Node right;

    Node(int val) {
        this.val = val;
    }
}

class NodeDetails {
    int level;
    int order;
    Node node;

    NodeDetails(int level, Node node) {
        this.level = level;
        this.node = node;
    }

    NodeDetails(int level, int order, Node node) {
        this.level = level;
        this.order = order;
        this.node = node;
    }
}

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
            pqueue.add(new NodeDetails(level, nn.order, nn.node));

            if (nn.node.left != null) {
                int order = nn.order;
                auxQueue.add(new NodeDetails(level, --order, nn.node.left));
            }
            if (nn.node.right != null) {
                int order = nn.order;
                auxQueue.add(new NodeDetails(level, ++order, nn.node.right));
            }

            if (queue.isEmpty()) {
                queue = auxQueue;
                auxQueue = new LinkedList<>();
                level++;
            }

        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);
        head.right.right.left = new Node(8);
        head.right.right.right = new Node(9);

        System.out.println(verticalOrder(head));

    }

}
// 1
// 2 3
// 4 5 6 7
// 8
// 9