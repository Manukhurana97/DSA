package com.example.dsa.NewCode.Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/* using topo sort check if the graph has cycle or not */
public class DetectDirectedGraphIsCyclicKahnAlgo {

    private static boolean isCyclic(List<List<Integer>> grid) {
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

        int count = 0;

        while (!queue.isEmpty()) {
            var current = queue.poll();
            count++;

            // remove the current node connections
            for (int neighbours : grid.get(current)) {
                indegree[neighbours]--;

                if (indegree[neighbours] == 0) {
                    queue.add(neighbours);
                }
            }
        }

        /*
         * if the graph has the cycle , we can never have all the elemnt with indegree
         * 0,
         * list size can never be equals to input list size
         */

        return (count != grid.size());
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1, 2, 3));
        input.add(Arrays.asList(2));
        input.add(Arrays.asList(3));
        input.add(Arrays.asList(0));

        System.out.println(isCyclic(input));
    }

}
