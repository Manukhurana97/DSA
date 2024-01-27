package com.example.dsa.NewCode.Graph;

import java.util.*;

/*for linear ordering of vertices, such that if there is an edge b/w u&v, u appears before v in the ordering*/
/* extension of a topo sort (BFS)*/
public class KahnsAlgo {

    private static List<Integer> topoSort(List<List<Integer>> grid) {
        int[] indegree = new int[grid.size()];

        /* get the indegree of all the element */
        for (int i = 0; i < grid.size(); i++) {
            for (int current : grid.get(i)) {
                indegree[current]++;
            }
        }

        Queue<Integer> queue = new LinkedList<>();
        /* get initial element with indegree 0 */
        // since its a directed graph , we will have atleast 1 element with 0 indegree
        for (int i = 0; i < grid.size(); i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        List<Integer> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            var current = queue.poll();
            result.add(current);

            // remove the current node connections
            for (int neighbours : grid.get(current)) {
                indegree[neighbours]--;

                if (indegree[neighbours] == 0) {
                    queue.add(neighbours);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList());
        input.add(Arrays.asList());
        input.add(Arrays.asList(3));
        input.add(Arrays.asList(1));
        input.add(Arrays.asList(0, 1));
        input.add(Arrays.asList(0, 2));

        System.out.println(topoSort(input));
    }
}
