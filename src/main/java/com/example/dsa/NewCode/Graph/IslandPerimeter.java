package com.example.dsa.NewCode.Graph;

import java.util.LinkedList;
import java.util.Queue;

public class IslandPerimeter {

    public int islandPerimeter(int[][] grid) {

        int i = 0, j = 0;

        for (i = 0; i < grid.length; i++) {
            for (j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == 1) {
                    return bfs(i, j, grid);
                }
            }
        }

        return 0;
    }

    private int bfs(int r, int c, int[][] grid) {

        int m = grid.length;
        int n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(r, c));

        int sides = 0; // result

        while (!queue.isEmpty()) {
            var current = queue.poll();
            sides += 4;
            visited[current.r][current.c] = true;

            int[] dr = { -1, 0, 1, 0 };
            int[] dc = { 0, -1, 0, 1 };

            for (int i = 0; i < 4; i++) {

                int nr = current.r + dr[i];
                int nc = current.c + dc[i];

                if (isValid(nr, nc, m, n) && grid[nr][nc] == 1) {
                    sides -= 1;
                    if (!visited[nr][nc]) {
                        queue.add(new Node(nr, nc));
                        visited[nr][nc] = true;
                    }
                }
            }
            System.out.println(sides + " " + current.r + "::" + current.c);
        }

        return sides;
    }

    private boolean isValid(int r, int c, int m, int n) {
        return !(r < 0 || c < 0 || r >= m || c >= n);
    }

    class Node {
        int r;
        int c;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public static void main(String[] args) {

        IslandPerimeter ip = new IslandPerimeter();
        // int[][] arr = { { 0, 1, 0, 0 }, { 1, 1, 1, 0 }, { 0, 1, 0, 0 }, { 1, 1, 0, 0
        // } };/
        // int[][] arr = { { 0 }, { 1 } };
        int[][] arr = { { 1, 1 }, { 1, 1 } };
        System.out.println(ip.islandPerimeter(arr));
    }

}
