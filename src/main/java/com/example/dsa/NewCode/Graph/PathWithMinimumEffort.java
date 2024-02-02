package com.example.dsa.NewCode.Graph;

import java.util.*;

public class PathWithMinimumEffort {

    static class Node {
        int effort;
        int[] coordinates;

        Node(int effort, int[] coordinates) {
            this.effort = effort;
            this.coordinates = coordinates;
        }
    }

    // find the absolute difference from moving from one node to another node, then
    // check if the error is max or not
    private static int getMinEffort(int[][] arr, int[] start, int[] end) {

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparing(node -> node.effort));
        queue.add(new Node(0, start));

        int[][] distance = new int[arr.length][arr[0].length];
        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(distance[i], Integer.MAX_VALUE);
        }
        distance[start[0]][start[1]] = 0;

        while (!queue.isEmpty()) {
            var node = queue.poll();
            int effort = node.effort;
            int r = node.coordinates[0];
            int c = node.coordinates[1];

            if (r - 1 >= 0) {
                int newEfforts = Math.max(Math.abs(arr[r][c] - arr[r - 1][c]), effort);
                if (distance[r - 1][c] > newEfforts) {
                    distance[r - 1][c] = newEfforts;
                    queue.add(new Node(newEfforts, new int[] { r - 1, c }));
                }
            }
            if (c - 1 >= 0) {
                int newEfforts = Math.max(Math.abs(arr[r][c] - arr[r][c - 1]), effort);
                if (distance[r][c - 1] > newEfforts) {
                    distance[r][c - 1] = newEfforts;
                    queue.add(new Node(newEfforts, new int[] { r, c - 1 }));
                }
            }

            if (r + 1 < arr.length) {
                int newEfforts = Math.max(Math.abs(arr[r][c] - arr[r + 1][c]), effort);
                if (distance[r + 1][c] > newEfforts) {
                    distance[r + 1][c] = newEfforts;
                    queue.add(new Node(newEfforts, new int[] { r + 1, c }));
                }
            }
            if (c + 1 < arr[r].length) {
                int newEfforts = Math.max(Math.abs(arr[r][c] - arr[r][c + 1]), effort);
                if (distance[r][c + 1] > newEfforts) {
                    distance[r][c + 1] = newEfforts;
                    queue.add(new Node(newEfforts, new int[] { r, c + 1 }));
                }
            }
        }

        return distance[end[0]][end[1]];

    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 2, 2 }, { 3, 8, 2 }, { 5, 3, 5 } };
        System.out.println(getMinEffort(arr, new int[] { 0, 0 }, new int[] { 2, 2 }));

        int[][] arr1 = { { 1, 2, 1, 1, 1 }, { 1, 2, 1, 2, 1 }, { 1, 2, 1, 2, 1 }, { 1, 1, 1, 2, 1 } };
        System.out.println(getMinEffort(arr1, new int[] { 0, 0 }, new int[] { 3, 4
        }));
    }
}
