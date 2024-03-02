package com.example.dsa.NewCode.Graph;

import java.util.*;

public class ShortestBridge {

    class Node {
        int r;
        int c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int shortestBridge(int[][] grid) {
        // find index of first island;

        int n = grid.length;

        int r = 0;
        int c = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    r = i;
                    c = j;
                    break;
                }

            }
        }

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(r, c));

        int[][] visited = new int[n][n];
        visited[r][c] = 1;

        int[][] direction = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        for (var dir : direction) {
            int dr = r + dir[0];
            int dc = c + dir[1];
            if (isValid(r, c, n)) {
                if (grid[dr][dc] == 0)
                    break;

                visited[dr][dc] = 1;
                queue.add(new Node(dr, dc));
            }
        }

        int numberOfFlips = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            numberOfFlips += 1;

            for (int i = 0; i < size; i++) {
                var current = queue.poll();
                if (visited[current.r][current.c] == 0 && grid[current.r][current.c] == 1)
                    return numberOfFlips;
                if (visited[current.r][current.c] == 0 && grid[current.r][current.c] == 0) {

                    visited[current.r][current.c] = 1;

                    for (var dir : direction) {
                        int dr = r + dir[0];
                        int dc = c + dir[1];
                        if (isValid(r, c, n) && visited[dr][dc] == 0) {

                            queue.add(new Node(dr, dc));
                        }
                    }

                }
            }
        }
        return numberOfFlips;
    }

    private boolean isValid(int r, int c, int n) {
        return !(r < 0 || c < 0 || r >= n || c >= n);
    }

}
