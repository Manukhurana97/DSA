package com.example.dsa.NewCode.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class NetworkDelay {

    class Node {

        int v;
        int wt;
        int step;

        Node(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    public int networkDelayTime(int[][] times, int n, int k) {

        List<List<Node>> input = new ArrayList<>();
        for (int i = 0; i < n; i++)
            input.add(new ArrayList());

        for (int i = 0; i < times.length; i++)
            input.get(times[i][0] - 1).add(new Node(times[i][1], times[i][2]));

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[k - 1] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(node -> node.wt));
        queue.add(new Node(k, 0));

        while (!queue.isEmpty()) {
            var current = queue.poll();

            for (Node neighbor : input.get(current.v - 1)) {
                if (distance[neighbor.v - 1] > current.wt + neighbor.wt) {
                    distance[neighbor.v - 1] = current.wt + neighbor.wt;
                    queue.add(new Node(neighbor.v, distance[neighbor.v - 1]));
                }
            }

        }

        int max = 0;
        for (var i : distance) {
            max = Math.max(max, i);
            if (i == Integer.MAX_VALUE) {
                return -1;
            }
        }

        return max;

    }

}
