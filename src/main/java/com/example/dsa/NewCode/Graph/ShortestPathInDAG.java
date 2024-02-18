package com.example.dsa.NewCode.Graph;

import java.util.ArrayList;
import java.util.Stack;

// perfrom a topo sort and 
public class ShortestPathInDAG {

    // to store to and weight
    static class Node {
        int v;
        int wt;

        Node(int v, int wt) {
            this.v = v;
            this.wt = wt;
        }
    }

    private static int shortestPathInDAG(int n, int m, int[][] edges, int source, int destination) {

        /*
         * create the input from matrix to adjency list ̥̥
         * u1: {(v1, weight), (v2, weight)}
         */
        ArrayList<ArrayList<Node>> input = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            input.add(new ArrayList<>());
        }

        for (int i = 0; i < edges.length; i++) {
            int u = edges[i][0];
            int v = edges[i][1];
            int wt = edges[i][2];

            input.get(u).add(new Node(v, wt));
        }

        /*
         * perform the topo sort inorder to get the element from least inbound to max
         * inbound in stack , so that we can get the node to start with .
         */
        int[] visited = new int[n];
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                topoSort(i, input, visited, stack);
            }
        }

        /* once get the inboud list, create a distance list with all value as max */
        int[] dist = new int[n];
        for (int i = 0; i < n; i++) {
            dist[i] = Integer.MAX_VALUE;
        }

        /* mark source as 0, going from v-v is 0 */
        // dist[0] = 0;
        dist[source] = 0;
        while (!stack.isEmpty()) {
            var current = stack.pop();
            for (var neighbour : input.get(current)) {
                int v = neighbour.v;
                int wt = neighbour.wt;

                // to reach from u to v, u current weight + weight(u->v)
                if (dist[current] + wt < dist[v]) {
                    dist[v] = wt + dist[current];
                }
            }
        }

        return dist[destination]; // return the destination distance

    }

    // toposort
    private static void topoSort(int i, ArrayList<ArrayList<Node>> input, int[] visited, Stack<Integer> stack) {

        visited[i] = 1;

        for (var neighbour : input.get(i)) {
            if (visited[neighbour.v] == 0) {
                topoSort(neighbour.v, input, visited, stack);
            }
        }
        stack.add(i);
    }

    public static void main(String[] args) {
        int n = 9; // Number of nodes
        int m = 13; // Number of edges

        int sourceNode = 0;
        int destinationNode = 8;

        int[][] edges = {
                { 0, 1, 2 },
                { 0, 2, 3 },
                { 1, 3, 1 },
                { 1, 4, 2 },
                { 2, 4, 1 },
                { 2, 5, 4 },
                { 3, 6, 3 },
                { 4, 6, 2 },
                { 4, 7, 1 },
                { 5, 7, 2 },
                { 6, 8, 3 },
                { 7, 8, 2 },
                { 8, 6, 1 } };
        int shortestDistance = shortestPathInDAG(n, m, edges, sourceNode, destinationNode);
        System.out.println(
                "Shortest distance from node " + sourceNode + " to node " + destinationNode + ": " + shortestDistance);

    }
}
