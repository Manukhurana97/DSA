package com.example.dsa.NewCode.Graph;

import java.util.*;

public class NumberOfIslands {

    public int numIslands(char[][] grid) {

        int numberOfIslands = 0;

        for (int row = 0; row < grid.length; row++) {
            for (int col = 0; col < grid[row].length; col++) {
                if (grid[row][col] == '1') {
                    numberOfIslands += 1;
                    // bfs(grid, new Node(row, col));
                    dfs(grid, row, col);
                }
            }
        }

        return numberOfIslands;
    }

    private void bfs(char[][] grid, Node node) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);

        while (!queue.isEmpty()) {
            var currentNode = queue.poll();
            int r = currentNode.r;
            int c = currentNode.c;
            grid[r][c] = '2';

            if (r - 1 >= 0 && grid[r - 1][c] == '1')
                queue.add(new Node(r - 1, c));
            if (c - 1 >= 0 && grid[r][c - 1] == '1')
                queue.add(new Node(r, c - 1));
            if (r + 1 < grid.length && grid[r + 1][c] == '1')
                queue.add(new Node(r + 1, c));
            if (c + 1 < grid[r].length && grid[r][c + 1] == '1')
                queue.add(new Node(r, c + 1));
        }
    }

    private void dfs(char[][] grid, int r, int c) {
        if (r < 0 || c < 0 || r >= grid.length || c >= grid[r].length || grid[r][c] != '1')
            return;
        grid[r][c] = '0';

        dfs(grid, r - 1, c);
        dfs(grid, r, c - 1);
        dfs(grid, r + 1, c);
        dfs(grid, r, c + 1);
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

    }

}
