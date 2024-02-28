package com.example.dsa.NewCode.Graph;

import java.util.*;

public class SwimInRisingWater {
    class Node {
        int r;
        int c;
        int dist;

        Node(int r, int c, int dist) {
            this.r = r;
            this.c = c;
            this.dist = dist;

        }
    }

    private boolean isValid(int r, int c, int[][] grid) {
        return !(r < 0 || c < 0 || r >= grid.length || c >= grid.length);
    }

    public int swimInWater(int[][] grid) {

        boolean[][] visited = new boolean[grid.length][grid.length];

        PriorityQueue<Node> queue = new PriorityQueue<>(Comparator.comparingInt((Node n) -> n.dist));
        queue.add(new Node(0, 0, grid[0][0]));

        int[][] directions = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };

        while (!queue.isEmpty()) {
            var current = queue.poll();
            if (current.r == grid.length - 1 && current.c == grid.length - 1)
                return current.dist;

            if (visited[current.r][current.c])
                continue;

            visited[current.r][current.c] = true;

            for (var dir : directions) {
                int nR = current.r + dir[0];
                int nC = current.c + dir[1];

                if (isValid(nR, nC, grid) && !visited[nR][nC]) {
                    int maxDist = (grid[nR][nC] > current.dist) ? grid[nR][nC] : current.dist;
                    queue.add(new Node(nR, nC, maxDist));
                }
            }
        }

        while (queue.size() > 1)
            queue.poll();

        return 0;
    }
}