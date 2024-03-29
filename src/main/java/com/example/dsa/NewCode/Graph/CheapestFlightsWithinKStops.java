package com.example.dsa.NewCode.Graph;

import java.util.*;

public class CheapestFlightsWithinKStops {

    class Node {
        int stops;
        int src;
        int cost;

        Node(int first, int second) {
            this.stops = first;
            this.src = second;
        }

        Node(int first, int second, int third) {
            this(first, second);
            this.cost = third;
        }
    }

    private int cheapestFlights(int n, int[][] arr, int src, int dst, int k) {

        List<List<Node>> input = new ArrayList<>();
        for (int i = 0; i <= arr.length; i++) {
            input.add(new ArrayList<>());
        }

        for (var flight : arr) {
            input.get(flight[0]).add(new Node(flight[1], flight[2]));
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, src, 0));

        int[] distance = new int[n];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        while (!queue.isEmpty()) {
            Node node = queue.poll();
            int stops = node.stops;
            int currentNode = node.src;
            int cost = node.cost;

            if (stops > k)
                continue;
            for (Node neNode : input.get(currentNode)) {
                int neighbourNode = neNode.stops;
                int neighbourCost = neNode.src;

                if (cost + neighbourCost < distance[neighbourNode] && stops <= k) {
                    distance[neighbourNode] = cost + neighbourCost;
                    queue.add(new Node(stops + 1, neighbourNode, cost + neighbourCost));
                }
            }
        }

        return (distance[dst] == Integer.MAX_VALUE) ? -1 : distance[dst];
    }

    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {

        int[] distance = new int[n + 1];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[src] = 0;

        for (int i = 0; i <= k; i++) {
            int[] temp = Arrays.copyOf(distance, n);
            for (var it : flights) {
                int u = it[0];
                int v = it[1];
                int wt = it[2];

                if (distance[u] != Integer.MAX_VALUE) {
                    temp[v] = Math.min(temp[v], distance[u] + wt);

                }
            }
            distance = temp;
        }

        return distance[dst] == Integer.MAX_VALUE ? -1 : distance[dst];
    }

    public static void main(String[] args) {
        CheapestFlightsWithinKStops flightCost = new CheapestFlightsWithinKStops();

        int n = 5;
        int[][] arr = { { 0, 1, 100 }, { 1, 2, 100 }, { 0, 2, 500 } };
        int src = 0, dst = 2, k = 1;

        int result = flightCost.cheapestFlights(n, arr, src, dst, k);
        System.out.println(result); // Output: 200
    }
}
