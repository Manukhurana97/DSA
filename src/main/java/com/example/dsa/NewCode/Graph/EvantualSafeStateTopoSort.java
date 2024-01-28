package com.example.dsa.NewCode.Graph;

import java.util.*;

/* convert all inbound nodes into outbound notes 
    perform a topo sort,
    all the nodes that lead/points to exit node will come in result, and it a cycle exist it will skip all the nodes as it can never have indegree as 0
 */

public class EvantualSafeStateTopoSort {

    private static List<Integer> eventualSafeNodes(List<List<Integer>> input) {

        // convert the inbound to the outbound
        int n = input.size();
        List<List<Integer>> list = new ArrayList<>();
        int[] indegree = new int[n];

        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int inNodes = 0; inNodes < n; inNodes++) {
            // prev: i -> node, current: node -> 1
            for (int outNote : input.get(inNodes)) {
                list.get(outNote).add(inNodes);
                indegree[outNote]++;
            }
        }

        // get all the initial element with indegree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // remove all the elemnt whose indegree is 0 and remove the connections and add
        // the elemnt with inbound 0 after removing connections
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            var current = queue.remove();
            result.add(current);

            for (var neighbour : list.get(current)) {
                indegree[neighbour]--;
                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1));
        input.add(Arrays.asList(2));
        input.add(Arrays.asList(3, 4));
        input.add(Arrays.asList(4, 5));
        input.add(Arrays.asList(6));
        input.add(Arrays.asList(6));
        input.add(Arrays.asList(0));
        input.add(Arrays.asList(1, 9));
        input.add(Arrays.asList(10));
        input.add(Arrays.asList(8));
        input.add(Arrays.asList(9));

        System.out.println(eventualSafeNodes(input));
    }

}
