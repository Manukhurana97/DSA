package com.example.dsa.NewCode.Graph;

import java.util.*;

public class ShortestDistanceInBinaryMaze {

    static class Node {
        int distance;
        int cord[];

        Node(int distance, int[] cord) {
            this.distance = distance;
            this.cord = cord;
        }
    }

    /*
     * distance with each step will increase by one , if matrix 4*4 the we have
     * 1,1,1,1,2,2,2,2,3,3,3... , we dont need priority queue, simple queue can work
     * fine
     */
    private static int getSortestPath(int[][] arr, int[] start, int[] end) {

        // PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt(n ->
        // n.distance));
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0, start));

        int[][] distance = new int[arr.length][arr[0].length];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (arr[i][j] != 0)
                    distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[start[0]][start[1]] = 0;

        while (!queue.isEmpty()) {

            var currentNode = queue.poll();
            int r = currentNode.cord[0];
            int c = currentNode.cord[1];
            int d = currentNode.distance;

            if (r - 1 >= 0 && arr[r - 1][c] == 1 && distance[r - 1][c] > d + 1) {// up
                distance[r - 1][c] = d + 1;
                queue.add(new Node(d + 1, new int[] { r - 1, c }));
            }
            if (r + 1 < arr.length && arr[r + 1][c] == 1 && distance[r + 1][c] > d + 1) {// down
                distance[r + 1][c] = d + 1;
                queue.add(new Node(d + 1, new int[] { r + 1, c }));
            }
            if (c - 1 >= 0 && arr[r][c - 1] == 1 && distance[r][c - 1] > d + 1) {// left
                distance[r][c - 1] = d + 1;
                queue.add(new Node(d + 1, new int[] { r, c - 1 }));
            }
            if (c + 1 < arr[r].length && arr[r][c + 1] == 1 && distance[r][c + 1] > d + 1) {// right
                distance[r][c + 1] = d + 1;
                queue.add(new Node(d + 1, new int[] { r, c + 1 }));
            }
        }

        return distance[end[0]][end[1]] == Integer.MAX_VALUE ? -1 : distance[end[0]][end[1]];

    }

    public static void main(String[] args) {
        int[][] arr = { { 1, 1, 1, 1 }, { 1, 1, 0, 1 }, { 1, 1, 1, 1 }, { 1, 1, 0, 0 }, { 1, 0, 0, 0 } };

        // System.out.println(getSortestPath(arr, new int[] { 0, 0 }, new int[] { 0, 0
        // }));
        System.out.println(getSortestPath(arr, new int[] { 0, 0 }, new int[] { 2, 3, }));

    }

}
