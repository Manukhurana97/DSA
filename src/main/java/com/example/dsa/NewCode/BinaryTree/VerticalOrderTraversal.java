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

    NodeDetails(int level, int order, Node node) {
        this.level = level;
        this.order = order;
        this.node = node;
    }
}

public class VerticalOrderTraversal {

    public static List<Integer> display(Node head) {

        PriorityQueue<NodeDetails> queue = new PriorityQueue<>(Comparator.comparingInt((NodeDetails dd) -> dd.order));

        getOrder(head, queue);

        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            result.add(queue.remove().node.val);
        }
        return result;
    }

    public static void getOrder(Node head, PriorityQueue<NodeDetails> pqueue) {
        int level = 0;

        Queue<NodeDetails> queue = new LinkedList<>();
        Queue<NodeDetails> auxQueue = new LinkedList<>();
        queue.add(new NodeDetails(level, 0, head));

        while (!queue.isEmpty()) {
            NodeDetails nn = queue.poll();
            pqueue.add(new NodeDetails(nn.level, nn.order, nn.node));

            if (nn.node.left != null)
                auxQueue.add(new NodeDetails(level, --nn.order, nn.node.left));
            if (nn.node.right != null)
                auxQueue.add(new NodeDetails(level, ++nn.order, nn.node.right));

            if (queue.isEmpty() && !auxQueue.isEmpty()) {
                queue.addAll(auxQueue);
                auxQueue.clear();
                level++;
            }
        }
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.left.right = new Node(8);
        head.left.left.right.right = new Node(9);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(display(head));

    }

}
// 1
// 2 3
// 4 5 6 7
// 8
// 9