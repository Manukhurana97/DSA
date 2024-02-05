package com.example.dsa.NewCode.Graph;

import java.util.*;

public class MinimumMultiplicationsToReachEnd {

    static class Node {
        int dist;
        int point;

        Node(int dist, int point) {
            this.dist = dist;
            this.point = point;
        }

        public static int countPath(int n, int start, int end, List<Integer> roads) {

            PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(x -> x.dist));
            queue.add(new Node(0, start));

            int[] distance = new int[100000];

            for (int i = 0; i < roads.size(); i++) {
                distance[i] = Integer.MAX_VALUE;
            }
            distance[start] = 0;

            while (!queue.isEmpty()) {
                var node = queue.poll();
                int dist = node.dist;
                int point = node.point;

                for (var neighbour : roads) {
                    int num = (neighbour * point) % 100000;

                    if (dist + 1 < distance[num]) {
                        distance[num] = point + 1;
                        if (num == end)
                            return point + 1;
                        queue.add(new Node(num, point + 1));
                    }
                }
            }

            return -1;
        }
    }

}
