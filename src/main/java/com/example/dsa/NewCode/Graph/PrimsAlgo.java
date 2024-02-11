package com.example.dsa.NewCode.Graph;

import java.util.*;

public class PrimsAlgo {

    static class Node {
        int wt;
        int currentPoint;
        int parent;

        Node(int currentPoint, int parent) {
            this.currentPoint = currentPoint;
            this.parent = parent;
        }

        Node(int wt, int currentPoint, int parent) {
            this(currentPoint, parent);
            this.wt = wt;
        }
    }

    static int spanningTree(int v, List<List<List<Integer>>> lst) {

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(node -> node.wt));
        queue.add(new Node(0, 0));

        int[] visited = new int[v];
        // List<Node> mst = new ArrayList<>();

        int sum = 0;
        while (!queue.isEmpty()) {
            var currentNode = queue.poll();
            if (visited[currentNode.currentPoint] != 0)
                continue;
            // if (currentNode.parent != -1)
            // mst.add(new Node(currentNode.currentPoint, currentNode.parent));
            sum += currentNode.wt;
            visited[currentNode.currentPoint] = 1;

            for (int i = 0; i < v; i++) {
                var neighbourNodes = lst.get(currentNode.currentPoint).get(i);
                if (visited[neighbourNodes.get(1)] == 0) {
                    queue.add(new Node(neighbourNodes.get(1), neighbourNodes.get(0), currentNode.currentPoint));
                }
            }
        }

        return sum;

    }

}
