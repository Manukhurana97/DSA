package com.example.dsa.NewCode.Graph;

import java.util.*;

public class NumberOfOperationsToMakeNetWorkConnected {

    class Dijkstra {

        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();
        int extraNode = 0;

        Dijkstra(int n) {
            for (int i = 0; i < n; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        private int findParent(int i) {
            int node = parent.get(i);
            if (i == node) {
                return node;
            }

            parent.set(node, findParent(node));

            return parent.get(i);
        }

        private void union(int i, int j) {
            int ultPI = findParent(i);
            int ultPJ = findParent(j);

            if (ultPI == ultPJ) {
                extraNode++;
                return;
            }

            if (size.get(ultPI) < size.get(ultPJ)) {
                parent.set(ultPI, ultPJ);
                size.set(ultPJ, size.get(ultPI) + ultPJ);
            } else {
                parent.set(ultPJ, ultPI);
                size.set(ultPI, size.get(ultPI) + ultPJ);
            }

        }
    }

    private int NumberOfConnectionRequired(List<List<Integer>> adj, int V) {
        Dijkstra set = new Dijkstra(V);

        for (var node : adj) {
            int u = node.get(0);
            int v = node.get(1);

            set.union(u, v);
        }

        int NoOfGraphs = 0;
        for (int i = 0; i < V; i++) {
            if (set.parent.get(i) == i && set.size.get(i) > 1) {
                NoOfGraphs += 1;
            }
        }

        int ans = NoOfGraphs - 1;
        return (set.extraNode - ans >= 0) ? ans : -1;
    }

    public static void main(String[] args) {
        NumberOfOperationsToMakeNetWorkConnected connected = new NumberOfOperationsToMakeNetWorkConnected();
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(0, 1));
        input.add(Arrays.asList(0, 2));
        input.add(Arrays.asList(0, 3));
        // input.add(Arrays.asList(1, 2));
        input.add(Arrays.asList(2, 3));
        input.add(Arrays.asList(4, 5));
        input.add(Arrays.asList(5, 6));
        input.add(Arrays.asList(7, 8));

        var result = connected.NumberOfConnectionRequired(input, 9);
        System.out.println(result);
    }
}
