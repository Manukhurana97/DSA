package com.example.dsa.NewCode.Graph;

import java.util.*;

public class NumberOfConnectedComponent {

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
                return node;

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

    public int countComponents(int n, int[][] edges) {

        List<List<Integer>> input = new ArrayList<>();
        for (int i = 0; i < n; i++)
            input.add(new ArrayList<>());

        for (var edge : edges)
            input.get(edge[0]).add(edge[1]);

        boolean[] visited = new boolean[n];
        int count = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                count++;
                dfs(i, visited, input);
            }
        }

        return count;
    }

    private void dfs(int i, boolean[] visited, List<List<Integer>> adj) {

        visited[i] = true;

        for (var neighbour : adj.get(i)) {
            if (!visited[neighbour]) {
                dfs(neighbour, visited, adj);
            }
        }

    }

    // using disjoint set

    public int countComponents1(int n, int[][] edges) {

        DisjointSet disjointSet = new DisjointSet(n);

        for (var edge : edges) {
            disjointSet.unionByRank(edge[0], edge[1]);
        }

        Set<Integer> set = new HashSet<>(disjointSet.parent);

        return set.size();
    }

    public static void main(String[] args) {

        NumberOfConnectedComponent component = new NumberOfConnectedComponent();

        int[][] arr = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
        System.out.println(component.countComponents(5, arr));
        System.out.println(component.countComponents1(5, arr));
    }
}
