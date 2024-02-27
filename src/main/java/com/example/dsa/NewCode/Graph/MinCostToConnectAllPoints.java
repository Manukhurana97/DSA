package com.example.dsa.NewCode.Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Set;

public class MinCostToConnectAllPoints {
    class Node {
        int distance;
        int v;

        Node(int dist, int j) {
            dist = distance;
            v = j;
        }
    }

    public int minCostConnectPoints(int[][] points) {

        int n = points.length;

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
                int dist = Math.abs(x2 - x1) + Math.abs(y2 - y1);
                list.get(i).add(new Node(dist, j));
            }
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        queue.add(new Node(0, 0));

        Set<Integer> visit = new HashSet<>();

        int result = 0;
        while (!queue.isEmpty()) {
            var node = queue.poll();
            if (visit.contains(node.v))
                continue;
            result += node.distance;

            for (var neighbor : list.get(node.v)) {
                if (!visit.contains(neighbor.v)) {
                    queue.add(new Node(neighbor.distance, neighbor.v));
                }
            }
        }

        return result;

    }
}
