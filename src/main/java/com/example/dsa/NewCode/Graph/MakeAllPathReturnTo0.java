package com.example.dsa.NewCode.Graph;

import java.util.*;
import java.util.Map.Entry;

public class MakeAllPathReturnTo0 {

    // bellman ford : tle
    // public int minReorder(int n, int[][] connections) {

    // int parent[] = new int[n];
    // Arrays.fill(parent, Integer.MAX_VALUE);
    // parent[0] = 0;

    // int flips = 0;

    // for(int i=0;i<connections.length;i++){
    // for(int j=0;j<connections.length;j++){
    // int u = connections[j][0];
    // int v= connections[j][1];

    // if(parent[u] == Integer.MAX_VALUE && parent[v]==0){
    // parent[u] = 0;
    // }else if(parent[u] == 0 && parent[v] == Integer.MAX_VALUE){
    // flips++;
    // parent[v] = 0;
    // }
    // }
    // }

    // return flips;
    // }

    public int minReorder(int n, int[][] connections) {

        Map<Integer, List<int[]>> map = new HashMap<>();
        for (int[] connection : connections) {
            int u = connection[0];
            int v = connection[1];

            map.computeIfAbsent(u, k -> new ArrayList<>()).add(new int[] { v, 1 });
            map.computeIfAbsent(v, k -> new ArrayList<>()).add(new int[] { u, 0 });
        }

        boolean[] visited = new boolean[n];
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        visited[0] = true;

        int flip = 0;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            System.out.println(node);
            for (var neighbor : map.getOrDefault(node, Collections.emptyList())) {
                int neighborNode = neighbor[0];
                int direction = neighbor[1];
                if (!visited[neighborNode]) {
                    if (direction == 1)
                        flip++;

                    queue.add(neighborNode);
                    visited[neighborNode] = true;
                }
            }
        }

        return flip;
    }

    public static void main(String[] args) {
        MakeAllPathReturnTo0 obj = new MakeAllPathReturnTo0();

        int[][] arr = { { 4, 3 }, { 2, 3 }, { 1, 2 }, { 1, 0 } };
        System.out.println(obj.minReorder(5, arr));
    }

}
