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

public class LeftRightView {

    public static List<Integer> getLeftView(Node head) {
        List<Integer> result = new ArrayList<>();
        if (head == null)
            return result;

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<NodeDetails> queue = new LinkedList<>();
        queue.add(new NodeDetails(0, 0, head));

        while (!queue.isEmpty()) {
            var nn = queue.poll();
            int level = nn.level;

            map.computeIfAbsent(level, k -> new ArrayList<>()).add(nn.node.val);

            if (nn.node.left != null)
                queue.add(new NodeDetails(level + 1, 0, nn.node.left));

            if (nn.node.right != null)
                queue.add(new NodeDetails(level + 1, 0, nn.node.right));

        }

        for (var lst : map.values())
            result.add(lst.get(0));

        return result;
    }

    public static List<Integer> getRightView(Node head) {
        List<Integer> result = new ArrayList<>();
        if (head == null)
            return result;

        Map<Integer, List<Integer>> map = new HashMap<>();
        Queue<NodeDetails> queue = new LinkedList<>();
        queue.add(new NodeDetails(0, 0, head));

        while (!queue.isEmpty()) {
            var nn = queue.poll();
            int level = nn.level;

            map.computeIfAbsent(level, k -> new ArrayList<>()).add(nn.node.val);

            if (nn.node.left != null)
                queue.add(new NodeDetails(level + 1, 0, nn.node.left));

            if (nn.node.right != null)
                queue.add(new NodeDetails(level + 1, 0, nn.node.right));

        }

        for (var lst : map.values())
            result.add(lst.get(lst.size() - 1));

        return result;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.left = new Node(2);
        head.right = new Node(3);
        head.left.left = new Node(4);
        head.left.right = new Node(5);
        head.right.left = new Node(6);
        head.right.right = new Node(7);

        System.out.println(getLeftView(head));
        System.out.println(getRightView(head));
    }

}
