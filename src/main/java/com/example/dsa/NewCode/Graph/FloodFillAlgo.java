package com.example.dsa.NewCode.Graph;

import java.util.*;

public class FloodFillAlgo {

    static class Node {
        int r;
        int c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static int[][] floodFill(int[][] image, int sr, int sc, int color) {

        int[][] visited = new int[image.length][image[sr].length];

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(sr, sc));

        floodFillBFS(image, queue, color, image[sr][sc], visited);

        return image;
    }

    private static void floodFillBFS(int[][] image, Queue<Node> queue, int color, int op, int[][] visited) {

        while (!queue.isEmpty()) {

            Node node = queue.poll();
            int r = node.r;
            int c = node.c;
            image[r][c] = color;
            visited[r][c] = 1;

            if (r - 1 >= 0 && image[r - 1][c] == op && visited[r - 1][c] == 0) {
                queue.add(new Node(r - 1, c));
            }
            if (c - 1 >= 0 && image[r][c - 1] == op && visited[r][c - 1] == 0) {
                queue.add(new Node(r, c - 1));
            }
            if (r + 1 < image.length && image[r + 1][c] == op && visited[r + 1][c] == 0) {
                queue.add(new Node(r + 1, c));
            }
            if (c + 1 < image[r].length && image[r][c + 1] == op && visited[r + 1][c] == 0) {
                queue.add(new Node(r, c + 1));
            }

        }

    }

    public static void main(String[] args) {
        // int[][] arr = { { 1, 1, 1 }, { 1, 1, 0 }, { 1, 0, 1 } };
        int[][] arr = { { 0, 0, 0 }, { 0, 0, 0 } };
        arr = floodFill(arr, 1, 1, 2);

        for (var i : arr) {
            for (var j : i) {
                System.out.print(j + " ");
            }
            System.out.println();
        }

    }
}
