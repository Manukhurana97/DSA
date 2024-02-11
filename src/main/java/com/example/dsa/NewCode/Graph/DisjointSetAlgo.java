package com.example.dsa.NewCode.Graph;

import java.util.*;

/* 
 in CONSTANT time it tell if 2 element belongs to same component or not
 it has 2 functionality: find parent, union 
 union can be done by using, rank or size

 union will help to connect 2 nodes in disjoint set
*/

// time : 4 alpas -> O(1)
public class DisjointSetAlgo {

    List<Integer> rank = new ArrayList<>();
    List<Integer> size = new ArrayList<>();
    List<Integer> parent = new ArrayList<>();

    DisjointSetAlgo(int n) {
        // make all the rank as 0 : not child
        // mark parent of all nodes to itself

        for (int i = 0; i < n; i++) {
            rank.add(0);
            size.add(1); // because everyone is parent of itself
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
     * * a: to make the tree hight minimum, we connect largest rank element with
     * smallest rank
     * * : time taken to find the parent is minimum
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

    /*
     * union (u, v)
     * 1. find untimate parent of u & v : pu, pv
     * 2. find rank of pu, pv
     * 3. connect smaller rank to larger rank
     * * a: to make the tree hight minimum, we connect largest rank element with
     * smallest rank
     * * : time taken to find the parent is minimum
     * 4. increase the size by size of v+ size of u
     */
    private void unionBySize(int u, int v) {

        int ultU = findParent(u);
        int ultv = findParent(v);
        if (ultU == ultv)
            return;
        if (size.get(ultU) < size.get(ultv)) {
            parent.set(ultU, ultv);
            size.set(ultv, size.get(ultv) + size.get(ultU));
        } else {
            parent.set(ultv, ultU);
            size.set(ultU, size.get(ultv) + size.get(ultU));
        }

    }

    public static void main(String[] args) {
        DisjointSetAlgo set = new DisjointSetAlgo(8);
        set.unionBySize(1, 2);
        set.unionBySize(2, 3);
        set.unionBySize(4, 5);
        set.unionBySize(6, 7);
        set.unionBySize(5, 6);

        // find parent of 1 and 4
        System.out.println((set.findParent(1) == set.findParent(4)) ? "same" : "not same");
        set.unionBySize(3, 4);
        System.out.println((set.findParent(1) == set.findParent(4)) ? "same" : "not same");
    }

}
