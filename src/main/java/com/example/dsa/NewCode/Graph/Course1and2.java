package com.example.dsa.NewCode.Graph;

import java.util.*;

public class Course1and2 {

    private static int[] isPossible(int n, int m, List<List<Integer>> prerequisites) {
        ArrayList<ArrayList<Integer>> list = new ArrayList<>();

        // invert the input
        for (int i = 0; i < n; i++) {
            list.add(new ArrayList<>());
        }
        for (int i = 0; i < m; i++) {
            list.get(prerequisites.get(i).get(1)).add(prerequisites.get(i).get(0));
        }

        // get the indegree of all the nodes
        int[] indegree = new int[n];
        for (int i = 0; i < n; i++) {
            for (int nodes : list.get(i)) {
                indegree[nodes]++;
            }
        }

        // get all the initial elemrnt with indegree 0
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            if (indegree[i] == 0) {
                queue.add(i);
            }
        }

        // perform bfs and remove the connection one by one and reduce the indegree and
        // add to queue if indegree is 0
        int i = 0;
        int[] result = new int[n];
        while (!queue.isEmpty()) {
            var current = queue.poll();
            result[i++] = current;

            for (int neighbour : list.get(current)) {
                indegree[neighbour]--;

                if (indegree[neighbour] == 0) {
                    queue.add(neighbour);
                }
            }
        }

        return (i == n) ? result : new int[1];
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1, 0));
        input.add(Arrays.asList(2, 0));
        input.add(Arrays.asList(3, 0));
        input.add(Arrays.asList(3, 2));
        var result = isPossible(4, 4, input);
        for (int i : result)
            System.out.println(i);
    }
}
