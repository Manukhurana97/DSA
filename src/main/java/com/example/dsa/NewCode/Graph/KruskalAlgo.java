package com.example.dsa.NewCode.Graph;

import java.util.*;

class DisJointSet {

    List<Integer> parent = new ArrayList<>();
    List<Integer> size = new ArrayList<>();

    DisJointSet(int n) {
        for (int i = 0; i < n; i++) {
            size.add(1);
            parent.add(i);
        }
    }

    // if the parent parent is same as i then return else make a recursive call till
    // node != i;
    public int findParent(int i) {

        var node = parent.get(i);
        if (node == i)
            return node;

        parent.set(node, findParent(node));
        return node;

    }

    public void unionBySize(int u, int v) {

        int ultParentU = findParent(u);
        int ultParentV = findParent(v);

        if (ultParentV == ultParentU) {
            return;
        }
        if (size.get(ultParentV) > size.get(ultParentU)) {
            parent.set(ultParentU, ultParentV);
            size.set(ultParentV, size.get(ultParentV) + size.get(ultParentU));
        } else {
            parent.set(ultParentV, ultParentU);
            size.set(ultParentU, size.get(ultParentV) + size.get(ultParentU));
        }
    }
}

public class KruskalAlgo {

    public record InnerKruskalAlgo(int wt, int v, int u) {
    }

    public static int spanningTree(int V, List<List<List<Integer>>> adj) {

        // iterate through all the nodes and store the nodes in list
        List<InnerKruskalAlgo> list = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            for (var curr : adj.get(i)) {
                int u = curr.get(0);
                int v = curr.get(1);
                int wt = curr.get(2);
                list.add(new InnerKruskalAlgo(wt, v, u));
            }
        }

        DisJointSet set = new DisJointSet(V); // create a object of disdoint set

        // sort all the element based on weights
        Collections.sort(list, Comparator.comparing(node -> node.wt));

        int sumWeight = 0; // total sum of weights

        // iterate throught each element in the list and check if parent is name same
        // (not forming a circular graph) the crete a graph and add the weights
        for (var currentNode : list) {
            int u = currentNode.u;
            int v = currentNode.v;
            int wt = currentNode.wt;

            // if parent are not same the create the union of nodes
            if (set.findParent(u) != set.findParent(v)) {
                sumWeight += wt;
                set.unionBySize(u, v);
            }
        }

        return sumWeight;
    }

    public static void main(String[] args) {

        List<List<List<Integer>>> adj = new ArrayList<>();
        adj.add(Arrays.asList(Arrays.asList(0, 1, 10)));
        adj.add(Arrays.asList(Arrays.asList(1, 3, 15)));
        adj.add(Arrays.asList(Arrays.asList(2, 3, 4)));
        adj.add(Arrays.asList(Arrays.asList(2, 0, 6)));
        adj.add(Arrays.asList(Arrays.asList(0, 3, 5)));

        int minWeight = KruskalAlgo.spanningTree(4, adj);
        System.out.println("Minimum Weight of Spanning Tree: " + minWeight);

    }
}
