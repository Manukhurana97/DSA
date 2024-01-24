package com.example.dsa.NewCode.Graph;

import java.util.*;;

public class RottenOrange {

    static class Node {
        int r;
        int c;

        Node(int row, int col) {
            r = row;
            c = col;
        }
    }

    public static int orangesRotting(int[][] grid) {

        int time = 0;
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> aux = new LinkedList<>();

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] == 2)
                    queue.add(new Node(i, j));

        while (!queue.isEmpty()) {
            var node = queue.poll();
            int r = node.r;
            int c = node.c;

            if (r - 1 >= 0 && grid[r - 1][c] == 1) {
                grid[r - 1][c] = 2;
                aux.add(new Node(r - 1, c));
            }
            if (c - 1 >= 0 && grid[r][c - 1] == 1) {
                grid[r][c - 1] = 2;
                aux.add(new Node(r, c - 1));
            }
            if (r + 1 < grid.length && grid[r + 1][c] == 1) {
                grid[r + 1][c] = 2;
                aux.add(new Node(r + 1, c));
            }
            if (c + 1 < grid[r].length && grid[r][c + 1] == 1) {
                grid[r][c + 1] = 2;
                aux.add(new Node(r, c + 1));
            }

            if (queue.isEmpty() && !aux.isEmpty()) {
                time += 1;
                queue.addAll(aux);
                aux.clear();
            }
        }

        for (int i = 0; i < grid.length; i++)
            for (int j = 0; j < grid[i].length; j++)
                if (grid[i][j] == 1)
                    return -1;

        return time;
    }

    public static void main(String[] args) {
        // int[][] grid = { { 2, 1, 1 }, { 0, 1, 1 }, { 0, 1, 1 } };
        // int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
        int[][] grid = { { 2, 1, 1 }, { 0, 1, 1 }, { 1, 0, 1 } };

        System.out.println(orangesRotting(grid));
    }

}
