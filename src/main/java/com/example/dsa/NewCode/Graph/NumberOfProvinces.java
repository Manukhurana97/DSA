package com.example.dsa.NewCode.Graph;

import java.util.ArrayList;
import java.util.List;

public class NumberOfProvinces {

    class DisjointSet {

        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        DisjointSet(int n) {
            for (int i = 0; i < n; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        public int getParent(int i) {
            var node = parent.get(i);
            if (node == i)
                return i;

            parent.set(i, getParent(node));
            return parent.get(i);
        }

        public void unionByRank(int u, int v) {
            int ultParentofU = parent.get(u);
            int ultParentofV = parent.get(v);

            if (ultParentofU == ultParentofV)
                return;

            if (size.get(ultParentofU) < size.get(ultParentofV)) {
                parent.set(ultParentofU, ultParentofV);
                size.set(ultParentofV, size.get(ultParentofU) + size.get(ultParentofV));
            } else {
                parent.set(ultParentofV, ultParentofU);
                size.set(ultParentofU, size.get(ultParentofU) + size.get(ultParentofV));
            }
        }
    }

    private int NumberOfProvinces(int V, List<List<Integer>> adj) {

        DisjointSet set = new DisjointSet(V);

        for (int i = 0; i < V; i++) {
            for (var j : adj.get(i)) {
                if (j == 1) {
                    // connection b/w i and j
                    set.unionByRank(i, j);
                }
            }
        }

        int count = 0;

        for (int i = 0; i < V; i++) {
            if (set.parent.get(i) == i)
                count++;
        }
        return count;
    }

    public static void main(String[] args) {
        List<List<Integer>> adjList = new ArrayList<>();
        adjList.add(List.of(1)); // Node 0 is connected to node 1
        adjList.add(List.of(0, 2)); // Node 1 is connected to nodes 0 and 2
        adjList.add(List.of(1)); // Node 2 is connected to node 1
        adjList.add(new ArrayList<>()); // Node 3 is not connected to any other node

        int numberOfNodes = 4;

        NumberOfProvinces provincesCounter = new NumberOfProvinces();
        int numberOfProvinces = provincesCounter.NumberOfProvinces(numberOfNodes, adjList);
        System.out.println("Number of provinces: " + numberOfProvinces);
    }
}
