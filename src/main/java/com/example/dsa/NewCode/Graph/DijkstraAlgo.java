package com.example.dsa.NewCode.Graph;

import java.util.*;

public class DijkstraAlgo {

    static class Node {
        int distance;
        int point;

        Node(int distance, int point) {
            this.distance = distance;
            this.point = point;
        }
    }

    private static int dijkstra(int start, int end, List<List<List<Integer>>> adj) {
        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(n -> n.distance));
        queue.add(new Node(0, start));

        // initially mark all the point as infinte
        int[] distance = new int[adj.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);

        while (!queue.isEmpty()) {
            var node = queue.poll();
            var currentPoint = node.point;
            int cdist = node.distance;

            // visit all the neighbours of current point and check the distance
            for (int i = 0; i < adj.get(currentPoint).size(); i++) {
                int neighbour = adj.get(currentPoint).get(i).get(0);
                int ndist = adj.get(currentPoint).get(i).get(1);

                // if the distance is less then update the distance in distance array and add
                // node to queue
                if (distance[neighbour] > cdist + ndist) {
                    distance[neighbour] = (cdist + ndist);
                    queue.add(new Node(cdist + ndist, neighbour));
                }

            }
        }
        return distance[end];
    }

    private static void addEdge(List<List<List<Integer>>> adjacencyList, int start, int end, int weight) {
        adjacencyList.get(start).add(Arrays.asList(end, weight));
        adjacencyList.get(end).add(Arrays.asList(start, weight)); // Assuming an undirected graph
    }

    public static void main(String[] args) {
        int numNodes = 8;
        int startNode = 0;
        int endNode = 7;

        List<List<List<Integer>>> adjacencyList = new ArrayList<>();
        for (int i = 0; i < numNodes; i++) {
            adjacencyList.add(new ArrayList<>());
        }

        addEdge(adjacencyList, 0, 1, 4);
        addEdge(adjacencyList, 0, 2, 2);
        addEdge(adjacencyList, 1, 3, 5);
        addEdge(adjacencyList, 1, 6, 4);
        addEdge(adjacencyList, 2, 3, 2);
        addEdge(adjacencyList, 2, 4, 1);
        addEdge(adjacencyList, 3, 5, 3);
        addEdge(adjacencyList, 4, 6, 6);
        addEdge(adjacencyList, 5, 7, 2);
        addEdge(adjacencyList, 6, 7, 1);

        System.out.println(dijkstra(startNode, endNode, adjacencyList));
    }
}
