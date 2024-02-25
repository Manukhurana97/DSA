package com.example.dsa.NewCode.Graph;

import java.util.ArrayList;
import java.util.List;

public class RedundantConnection {
    class disjointSet {

        List<Integer> parent = new ArrayList<>();
        List<Integer> size = new ArrayList<>();

        disjointSet(int n) {
            for (int i = 0; i <= n; i++) {
                parent.add(i);
                size.add(1);
            }
        }

        public int findUltParent(int i) {
            var node = parent.get(i);
            if (node == i) {
                return i;
            }

            parent.set(i, findUltParent(node));
            return parent.get(i);
        }

        public void union(int i, int j) {
            int ip = findUltParent(i);
            int jp = findUltParent(j);

            if (ip == jp)
                return;

            int is = size.get(ip);
            int js = size.get(jp);
            if (is < js) {
                parent.set(ip, jp);
                size.set(jp, is + js);
            } else {
                parent.set(jp, ip);
                size.set(ip, is + js);
            }
        }

    }

    public int[] findRedundantConnection(int[][] edges) {

        disjointSet set = new disjointSet(edges.length);

        for (var edge : edges) {
            int uP = set.findUltParent(edge[0]);
            int vP = set.findUltParent(edge[1]);

            System.out.println(edge[0] + ":" + uP + " " + edge[1] + ":" + vP);
            System.out.println(set.parent);
            System.out.println(set.size);

            if (uP == vP) {
                return edge;
            } else {
                set.union(edge[0], edge[1]);
            }
        }

        return new int[2];

    }

    public static void main(String[] args) {
        RedundantConnection connection = new RedundantConnection();

        int[][] arr = { { 1, 5 }, { 3, 4 }, { 3, 5 }, { 4, 5 }, { 2, 4 } };
        var a = connection.findRedundantConnection(arr);
        System.out.println(a[0] + " " + a[1]);
    }
}
