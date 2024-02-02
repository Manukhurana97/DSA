package com.example.dsa.NewCode.Graph;

import java.util.*;

public class PrintShortestPathUsingDijkastraAlgo {

    static class Node {
        int currentNode;
        int distanceTravelledTillNow;
        List<Integer> nodesTravelTillNow;

        Node(int currentNode, int distanceTravelledTillNow) {
            this.currentNode = currentNode;
            this.distanceTravelledTillNow = distanceTravelledTillNow;
        }

        Node(int currentNode, int distanceTravelledTillNow, List<Integer> nodesTravelTillNow) {
            this(currentNode, distanceTravelledTillNow);
            this.nodesTravelTillNow = nodesTravelTillNow;
        }

    }

    // in the node add the list to store the parent hierarchy and perform the
    // dijkstra also
    private static List<Integer> getShortestPath(int start, int end, List<List<List<Integer>>> adj) {

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(n -> n.distanceTravelledTillNow));
        queue.add(new Node(start, 0, Arrays.asList(start)));

        List<Integer> result = new ArrayList<>();
        int[] distance = new int[adj.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        while (!queue.isEmpty()) {
            var currentNode = queue.poll();

            for (int i = 0; i < adj.get(currentNode.currentNode).size(); i++) {
                int neighbor = adj.get(currentNode.currentNode).get(i).get(0);
                int neighborDistance = adj.get(currentNode.currentNode).get(i).get(1);

                if (distance[neighbor] > (currentNode.distanceTravelledTillNow + neighborDistance)) {
                    List<Integer> nodesTravelTillNow = new ArrayList<>(currentNode.nodesTravelTillNow);
                    nodesTravelTillNow.add(neighbor);

                    if (neighbor == end)
                        result = nodesTravelTillNow;

                    distance[neighbor] = (currentNode.distanceTravelledTillNow + neighborDistance);
                    queue.add(new Node(neighbor, (currentNode.distanceTravelledTillNow + neighborDistance),
                            nodesTravelTillNow));
                }
            }
        }

        return result.isEmpty() ? Arrays.asList(-1) : result;
    }

    // ------------------------------------------------------------------

    /*
     * create a parent array to keep the track of current node parent, and perform
     * the dijkestra algo
     */
    private static List<Integer> getShortestPath1(int start, int end, List<List<List<Integer>>> adj) {

        int[] parent = new int[adj.size()];
        parent[start] = start;

        int[] distance = new int[adj.size()];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[start] = 0;

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(n -> n.distanceTravelledTillNow));
        queue.add(new Node(start, 0));

        while (!queue.isEmpty()) {
            var node = queue.poll();
            var currentPoint = node.currentNode;
            var distanceTravelledTillNow = node.distanceTravelledTillNow;

            for (int i = 0; i < adj.get(currentPoint).size(); i++) {
                var neighbour = adj.get(currentPoint).get(i).get(0);
                var neighbourDiatance = adj.get(currentPoint).get(i).get(1);

                if (distance[neighbour] > distanceTravelledTillNow + neighbourDiatance) {
                    parent[neighbour] = currentPoint; // add parent of neighbours
                    distance[neighbour] = distanceTravelledTillNow + neighbourDiatance;
                    queue.add(new Node(neighbour, (distanceTravelledTillNow + neighbourDiatance)));
                }
            }
        }
        List<Integer> result = new LinkedList<>();
        result.add(end);
        for (int i = 0; i < parent.length; i++) {
            end = parent[end];
            result.add(0, end);
            if (end == start)
                return result;

        }

        return Arrays.asList(-1);
    }

    // ------------------------------ input -----------------------------

    private static void addEdge(List<List<List<Integer>>> graph, int start, int end, int weight) {
        graph.get(start).add(Arrays.asList(end, weight));
        graph.get(end).add(Arrays.asList(start, weight));
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
        addEdge(adjacencyList, 3, 6, 3);
        addEdge(adjacencyList, 4, 6, 6);
        addEdge(adjacencyList, 5, 7, 2);
        addEdge(adjacencyList, 6, 7, 1);

        System.out.println(getShortestPath(startNode, endNode, adjacencyList));
        System.out.println(getShortestPath1(startNode, endNode, adjacencyList));

    }
}
