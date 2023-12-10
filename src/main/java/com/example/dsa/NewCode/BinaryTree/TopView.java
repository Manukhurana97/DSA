package com.example.dsa.NewCode.BinaryTree;

import java.util.*;

import OldCode.LinkedList.LinkedList;

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

public class TopView {

    public static List<Integer> getTopView(Node head) {
        List<Integer> result = new ArrayList<>();
        if (head == null)
            return result;

        TreeMap<Integer, List<Integer>> map = new TreeMap<>();
        Queue<NodeDetails> queue = new LinkedList<>();
        queue.add(new NodeDetails(0, 0, head));

        while (!queue.isEmpty()) {

            var node = queue.poll();
            var nn = queue.poll().node;
            int order = node.order;
            int level = node.level;

            map.computeIfAbsent(order, k -> new ArrayList<>()).add(nn.val);

            if (nn.left != null)
                queue.add(new NodeDetails(level + 1, order - 1, nn.left));
            if (nn.right != null)
                queue.add(new NodeDetails(level + 1, order + 1, nn.right));

        }

        for (var val : map.values()) {
            result.add(val.get(0));
        }

        return result;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.left.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(getTopView(head));

    }
}
