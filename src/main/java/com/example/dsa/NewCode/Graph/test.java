package com.example.dsa.NewCode.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class test {
    static class Node {
        int v;
        int cost;
        int stop;

        Node(int v, int cost) {
            this.v = v;
            this.cost = cost;
        }

        Node(int v, int cost, int stop) {
            this(v, cost);
            this.stop = stop;
        }
    }

    public static int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        List<List<Node>> input = new ArrayList<>();
        for (int i = 0; i <= flights.length; i++) {
            input.add(new ArrayList<>());
        }

        for (var flight : flights) {
            input.get(flight[0]).add(new Node(flight[1], flight[2]));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt((Node node) -> node.cost));
        queue.add(new Node(src, 0, 0));

        int[] distance = new int[flights.length + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();

            if (current.stop > k)
                continue;

            for (var neighbor : input.get(current.v)) {
                if (distance[neighbor.v] > current.cost + neighbor.cost && current.stop <= k) {
                    distance[neighbor.v] = current.cost + neighbor.cost;
                    queue.add(new Node(neighbor.v, (current.cost + neighbor.cost), current.stop + 1));
                    queue.add(new Node(neighbor.v, current.cost + neighbor.cost, current.stop + 1));

                }
            }

        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }

    public static void main(String[] args) {
        int n = 5;
        int[][] arr = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
        int src = 0, dst = 2, k = 1;

        // int result = findCheapestPrice(n, arr, src, dst, k);
        // System.out.println(result); // Output: 200

        // int[][] arr1 = { { 4, 1, 1 }, { 1, 2, 3 }, { 0, 3, 2 }, { 0, 4, 10 }, { 3, 1,
        // 1 }, { 1, 4, 3 } };

        // result = findCheapestPrice(5, arr1, 2, 1, 1);
        // System.out.println(result);

        int[][] arr2 = { { 0, 1, 5 }, { 1, 2, 5 }, { 0, 3, 2 }, { 3, 1, 2 }, { 1, 4, 1 }, { 4, 2, 1 } };

        int result = findCheapestPrice(5, arr2, 0, 2, 2);
        System.out.println(result);
    }
}
