package com.example.dsa.NewCode.Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CloneGraph {

    class Node {
        public int val;
        public List<Node> neighbors;

        public Node() {
            val = 0;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val) {
            val = _val;
            neighbors = new ArrayList<Node>();
        }

        public Node(int _val, ArrayList<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }

    public Node cloneGraph(Node node) {

        if (node == null)
            return null;
        Map<Integer, Node> set = new HashMap<>();
        return clone(node, set);
    }

    private Node clone(Node head, Map<Integer, Node> map) {

        if (map.containsKey(head.val))
            return map.get(head.val);

        Node newNode = new Node(head.val, new ArrayList<Node>());
        map.put(head.val, newNode);

        for (Node neighbor : head.neighbors) {
            newNode.neighbors.add(clone(neighbor, map));
        }
        return newNode;
    }

}
