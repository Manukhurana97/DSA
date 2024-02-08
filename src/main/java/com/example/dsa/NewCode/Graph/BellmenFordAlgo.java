package com.example.dsa.NewCode.Graph;

import java.util.*;

/* asumption: the input is in any order
 * perform nth cycle and check if the source is not infinite and distance from u->v is less
 * (u, v, wt) : mark all distance as infinity
 * (3, 2, 6) : inf | inf | 9
 * (5, 3, 1) : inf | 3
 * (0, 1, 5) : 5 | 5
 * (1, 5, -3) : 2 | 2
 * (1, 2, -2) : 3 | 3
 * (3, 4, -2) : inf | 1
 * (2, 4, 3) : 5 | 1(from above)
 * 
 */
public class BellmenFordAlgo {

    private int[] BellmenFord(int V, List<List<Integer>> edges, int s) {
        int[] distance = new int[V];
        Arrays.fill(distance, Integer.MAX_VALUE);
        distance[s] = 0;

        for (int i = 0; i < V - 1; i++) {
            for (var it : edges) {
                int u = it.get(0);
                int v = it.get(1);
                int wt = it.get(2);

                if (distance[u] != Integer.MAX_VALUE && distance[v] > distance[u] + wt) {
                    distance[v] = distance[u] + wt;
                }
            }
        }

        // nth relaxation to check negative cycle,
        // if graph contain -ve cycle the it will never reach all the nodes

        for (var it : edges) {
            int u = it.get(0);
            int v = it.get(1);
            int wt = it.get(2);

            if (distance[u] != Integer.MAX_VALUE && distance[v] > distance[u] + wt) {
                return new int[] { -1 };
            }
        }

        return distance;

    }

    public static void main(String[] args) {
        List<List<Integer>> edges = new ArrayList<>();
        edges.add(Arrays.asList(0, 1, 2));
        edges.add(Arrays.asList(1, 2, -1));
        edges.add(Arrays.asList(2, 3, 3));
        edges.add(Arrays.asList(3, 1, -6));

        BellmenFordAlgo bellmanFordExample = new BellmenFordAlgo();

        int[] result = bellmanFordExample.BellmenFord(5, edges, 0);
        for (var i : result) {
            System.out.print(i + " ");
        }

    }

}
