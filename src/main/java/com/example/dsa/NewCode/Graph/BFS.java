package com.example.dsa.NewCode.Graph;

import java.util.*;

public class BFS {

    private static List<Integer> triverse(List<List<Integer>> graph, int v) {

        List<Integer> result = new ArrayList<>();
        Set<Integer> visited = new HashSet<>();
        visited.add(v - 1);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(v - 1);

        while (!queue.isEmpty()) {
            var i = queue.poll();
            result.add(i + 1);

            var lst = graph.get(i);
            for (var index : lst) {
                if (!visited.contains(index - 1)) {
                    visited.add(index - 1);
                    queue.add(index - 1);
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(2, 6));
        input.add(Arrays.asList(1, 3, 4));
        input.add(Arrays.asList(2));
        input.add(Arrays.asList(2, 5));
        input.add(Arrays.asList(4, 8));
        input.add(Arrays.asList(1, 7, 9));
        input.add(Arrays.asList(6, 8));
        input.add(Arrays.asList(7));
        input.add(Arrays.asList(6));

        System.out.println(triverse(input, 1));
    }

}

// ----1
// ---2.6
// -3.4.7.9
// ---5.8