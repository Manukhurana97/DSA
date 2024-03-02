package com.example.dsa.NewCode.Graph;

import java.util.*;

public class MaxNumberOfIlands {
    public int maxAreaOfIsland(int[][] grid) {

        int maxArea = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];

        for (int r = 0; r < grid.length; r++) {
            for (int c = 0; c < grid[r].length; c++) {
                if (grid[r][c] == 1 && !visited[r][c]) {
                    maxArea = Math.max(maxArea, dfs(r, c, grid, visited));
                }
            }
        }

        return maxArea;
    }

    private int bfs(int r, int c, int[][] grid, boolean[][] visited) {

        int count = 0;
        int[][] delta = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(r, c));

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            count += 1;

            visited[current.r][current.c] = true;

            for (int i = 0; i < 4; i++) {
                int dr = current.r + delta[i][0];
                int dc = current.c + delta[i][1];
                if (isValid(dr, dc, grid) && grid[dr][dc] == 1 && !visited[dr][dc]) {
                    queue.add(new Node(dr, dc));
                    visited[dr][dc] = true;
                }
            }
        }

        return count;
    }

    private int dfs(int r, int c, int[][] grid, boolean[][] visited) {
        if (!isValid(r, c, grid) || grid[r][c] == 0 || visited[r][c])
            return 0;

        int count = 1;
        int[][] delta = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

        visited[r][c] = true;

        for (int i = 0; i < 4; i++) {
            int dr = r + delta[i][0];
            int dc = c + delta[i][1];
            count += dfs(dr, dc, grid, visited);
        }

        return count;

    }

    private boolean isValid(int r, int c, int[][] grid) {
        return !(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length);
    }

    class Node {
        int r;
        int c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }
}
