package com.example.dsa.NewCode.Graph;

import java.util.*;

/* 
 in CONSTANT time it tell if 2 element belongs to same component or not
 it has 2 functionality: find parent, union 
 union can be done by using, rank or size

 union will help to connect 2 nodes in disjoint set
*/
public class DisjointSet {

    List<Integer> rank = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DisjointSet(int n) {
        // make all the rank as 0 : not child
        // makr parent of all nodes to itself

        for (int i = 0; i < n; i++) {
            rank.add(0);
            parent.add(i);
        }
    }

    /*
     * find the parent of node and also do the compression of other node.
     */
    private int findParent(int i) {
        var node = parent.get(i);
        // if node is the parent of itself
        if (node == i)
            return node;

        // store the ultimate parent, path compression
        var ultParent = findParent(node);
        parent.set(node, ultParent); // updating the parent of the node to ultimate parent

        return node;
    }

    /*
     * union (u, v)
     * 1. find untimate parent of u & v : pu, pv
     * 2. find rank of pu, pv
     * 3. connect smaller rank to larger rank
     * 
     */
    private void unionByRank(int u, int v) {
        int ultU = findParent(u);
        int ultv = findParent(v);
        // if they belong to same component
        if (ultU == ultv)
            return;
        if (rank.get(ultU) < rank.get(ultv)) {
            // smaller to and attach to greater
            parent.set(ultU, ultv);
            // increse the rank of parent
            rank.set(ultv, rank.get(ultv) + 1);
        } else if (rank.get(ultU) > rank.get(ultv)) {
            parent.set(ultv, ultU);
            rank.set(ultU, rank.get(ultU) + 1);
        } else {
            parent.set(ultv, ultU);
            rank.set(ultU, rank.get(ultU) + 1);
        }
    }

    public static void main(String[] args) {
        DisjointSet set = new DisjointSet(8);
        set.unionByRank(1, 2);
        set.unionByRank(2, 3);
        set.unionByRank(4, 5);
        set.unionByRank(6, 7);
        set.unionByRank(5, 6);

        // find parent of 1 and 4
        System.out.println((set.findParent(1) == set.findParent(4)) ? "same" : "not same");
        set.unionByRank(3, 4);
        System.out.println((set.findParent(1) == set.findParent(4)) ? "same" : "not same");
    }

}
