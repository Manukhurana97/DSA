package com.example.dsa.NewCode.Graph;

import java.util.*;

// 0/1 matrix, find the nearest distance of 0 from any node.
public class DistanceOfNearestCellHaving0and1 {

    public static int[][] updateMatrix(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 0)
                    result[i][j] = 0;
                else {
                    int[][] visited = new int[mat.length][mat[0].length];
                    // visited[i][j] = 1;
                    result[i][j] = updateMatrixBFS(i, j, mat, visited);
                }
            }
        }
        return result;
    }

    private static int updateMatrixBFS(int r, int c, int[][] mat, int[][] visited) {
        Queue<Node> queue = new LinkedList<>();
        Queue<Node> aux = new LinkedList<>();
        queue.add(new Node(r, c));

        int distance = 0;

        while (!queue.isEmpty()) {
            Node current = queue.poll();
            c = current.c;
            r = current.r;

            if (mat[r][c] == 0)
                return distance;

            if (r - 1 >= 0 && visited[r - 1][c] == 0) {
                visited[r - 1][c] = 1;
                aux.add(new Node(r - 1, c));
            }
            if (c - 1 >= 0 && visited[r][c - 1] == 0) {
                visited[r][c - 1] = 1;
                aux.add(new Node(r, c - 1));
            }
            if (r + 1 < mat.length && visited[r + 1][c] == 0) {
                visited[r + 1][c] = 1;
                aux.add(new Node(r + 1, c));
            }
            if (c + 1 < mat[r].length && visited[r][c + 1] == 0) {
                visited[r][c + 1] = 1;
                aux.add(new Node(r, c + 1));
            }

            if (queue.isEmpty() && !aux.isEmpty()) {
                queue.addAll(aux);
                aux.clear();
                distance += 1;
            }
        }

        return distance;
    }

    static class Node {
        int r;
        int c;
        int index;

        Node(int r, int c) {
            this.r = r;
            this.c = c;
        }

        Node(int r, int c, int index) {
            this(r, c);
            this.index = index;
        }
    }

    public static int[][] updateMatrix1(int[][] mat) {
        int[][] result = new int[mat.length][mat[0].length];
        Queue<Node> queue = new LinkedList<>();
        int[][] visited = new int[mat.length][mat[0].length];

        for (int i = 0; i < mat.length; i++)
            for (int j = 0; j < mat[i].length; j++)
                if (mat[i][j] == 0)
                    queue.add(new Node(i, j, 0)); // get all the nodes with o index

        while (!queue.isEmpty()) {
            var node = queue.poll();
            int r = node.r;
            int c = node.c;
            int index = node.index;

            if (mat[r][c] == 1)
                result[r][c] = index;

            // move up, down, left, right
            if (r - 1 >= 0 && visited[r - 1][c] == 0) {
                visited[r - 1][c] = 1;
                queue.add(new Node(r - 1, c, index + 1));
            }
            if (c - 1 >= 0 && visited[r][c - 1] == 0) {
                visited[r][c - 1] = 1;
                queue.add(new Node(r, c - 1, index + 1));
            }
            if (r + 1 < mat.length && visited[r + 1][c] == 0) {
                visited[r + 1][c] = 1;
                queue.add(new Node(r + 1, c, index + 1));
            }
            if (c + 1 < mat[r].length && visited[r][c + 1] == 0) {
                visited[r][c + 1] = 1;
                queue.add(new Node(r, c + 1, index + 1));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        // int[][] arr = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
        // int[][] arr = { { 0, 0, 0 }, { 0, 1, 0 }, { 1, 1, 1 } };
        int[][] arr = { { 1, 1, 1, 1, 1, 1, 1, 0 } };
        arr = updateMatrix(arr);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + ", ");
            }
            System.out.println();
        }
    }
}
