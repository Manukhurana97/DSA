package com.example.dsa.NewCode.Graph;

import java.util.*;

// if a graph is a validate tree or not
public class GraphValidTree {

    class disjointSet {

        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        disjointSet(int n) {
            for (int i = 0; i < n; i++) {
                parent.add(Integer.MAX_VALUE);
                size.add(1);
            }
        }

        private int findParent(int i) {
            int node = parent.get(i);
            if (node != i) {
                parent.set(i, findParent(node));
            }

            return parent.get(i);
        }

        public void unionBySize(int u, int v) {
            int uParent = findParent(u);
            int vParent = findParent(v);

            if (uParent == vParent)
                return;

            int uSize = size.get(uParent);
            int vSize = size.get(vParent);

            if (uSize < vSize) {
                parent.set(uParent, vParent);
                size.set(vParent, uSize + vSize);
            } else {
                parent.set(vParent, uParent);
                size.set(uParent, uSize + vSize);
            }
        }
    }

    public boolean validTree(int n, int[][] edges) {

        disjointSet set = new disjointSet(n);

        for (var edge : edges) {
            if (edge[0] == edge[1])
                return false;
            else
                set.unionBySize(edge[0], edge[1]);
        }

        Set<Integer> duplicate = new HashSet<>();
        for (var i : set.parent) {
            if (duplicate.contains(i))
                return false;
            duplicate.add(i);
        }

        return true;
    }

    // using dfs
    public boolean validTree1(int n, int[][] edges) {

        List<List<Integer>> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }

        for (int[] edge : edges) {
            list.get(edge[0]).add(edge[1]);
            list.get(edge[1]).add(edge[0]);
        }

        boolean[] visited = new boolean[n];
        dfs(list, visited, 0);

        for (boolean v : visited) {
            if (!v)
                return false;
        }

        return true;
    }

    private void dfs(List<List<Integer>> adj, boolean[] visited, int i) {

        visited[i] = true;

        for (var neighbor : adj.get(i)) {
            if (!visited[neighbor]) {
                dfs(adj, visited, neighbor);
            }
        }
    }

}
