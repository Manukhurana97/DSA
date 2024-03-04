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

        Queue<Node> queue = new LinkedList<>();
        boolean foundFirstIsland = false;

        for (int i = 0; i < n && !foundFirstIsland; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    dfs(i, j, grid, queue);
                    foundFirstIsland = true;
                    break;
                }
            }
        }

        int flips = 0;
        int[][] direction = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        while (!queue.isEmpty()) {
            int size = queue.size();
            flips += 1;

            for (int i = 0; i < size; i++) {
                var current = queue.poll();

                for (var dir : direction) {
                    int dr = current.r + dir[0];
                    int dc = current.c + dir[1];

                    if (isValid(dr, dc, grid.length) && grid[dr][dc] == 1)
                        return flips - 1;

                    if (isValid(dr, dc, grid.length) && grid[dr][dc] == 0) {
                        grid[dr][dc] = 2;
                        queue.add(new Node(dr, dc));
                    }
                }
            }
        }

        return -1;
    }

    private void dfs(int i, int j, int[][] grid, Queue<Node> queue) {
        if (!isValid(i, j, grid.length) || grid[i][j] != 1)
            return;

        grid[i][j] = 2;
        queue.add(new Node(i, j));

        dfs(i - 1, j, grid, queue);
        dfs(i, j - 1, grid, queue);
        dfs(i + 1, j, grid, queue);
        dfs(i, j + 1, grid, queue);
    }

    private boolean isValid(int r, int c, int n) {
        return r >= 0 && c >= 0 && r < n && c < n;
    }

}
