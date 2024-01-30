package com.example.dsa.NewCode.Graph;

import java.util.*;

public class ShortestPathInUnDirectedGraph {

    private static Integer shortestPathDistance(List<List<Integer>> list, int source, int destination) {

        int[] distance = new int[list.size()];
        for (int i = 0; i < list.size(); i++)
            distance[i] = Integer.MAX_VALUE;
        distance[source] = 0;

        bfs(source, list, distance);

        var dest = distance[destination];
        return dest == Integer.MAX_VALUE ? -1 : dest;
    }

    private static void bfs(int current, List<List<Integer>> list, int[] dist) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(current);

        while (!queue.isEmpty()) {
            current = queue.poll();

            for (int neighbour : list.get(current)) {
                if (dist[current] + 1 < dist[neighbour]) {
                    dist[neighbour] = dist[current] + 1;
                    queue.add(neighbour);
                }

            }
        }
    }

    public static void main(String[] args) {
        List<List<Integer>> input = new ArrayList<>();
        input.add(Arrays.asList(1, 3));
        input.add(Arrays.asList(0, 2, 3));
        input.add(Arrays.asList(1, 6));
        input.add(Arrays.asList(0, 4));
        input.add(Arrays.asList(3, 5));
        input.add(Arrays.asList(4, 6));
        input.add(Arrays.asList(2, 5, 7, 8));
        input.add(Arrays.asList(6, 8));
        input.add(Arrays.asList(6, 7));

        System.out.println(shortestPathDistance(input, 0, 6));
    }

}
