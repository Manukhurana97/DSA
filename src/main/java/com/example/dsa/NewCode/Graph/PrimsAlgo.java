package com.example.dsa.NewCode.Graph;

import java.util.*;

public class PrimsAlgo {

    class Node {
        int distance;
        int v;

        Node(int distance, int v) {
            this.distance = distance;
            this.v = v;
        }
    }

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

        // find the manhatten distance of all node to all nodes
        List<List<Node>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int x2 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int y1 = points[j][0];
                int y2 = points[j][1];

                int dist = Math.abs(x2 - y2) + Math.abs(x1 - y1);
                list.get(i).add(new Node(dist, j));
                list.get(j).add(new Node(dist, i));
            }
        }

        PriorityQueue<Node> queue = new PriorityQueue<Node>(Comparator.comparing(nde -> nde.distance));
        queue.add(new Node(0, 0));

        int result = 0;

        Set<Integer> visited = new HashSet<>();

        while (!queue.isEmpty()) {
            var currentNode = queue.poll();
            if (visited.contains(currentNode.v))
                continue;

            result += currentNode.distance;
            visited.add(currentNode.v);

            for (var neighbor : list.get(currentNode.v)) {
                if (!visited.contains(neighbor.v))
                    queue.add(new Node(neighbor.distance, neighbor.v));
            }
        }
        return result;
    }
}