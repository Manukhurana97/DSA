package com.example.dsa.NewCode.Graph;

import java.util.*;

class Node {
    int i;
    int j;
    int dist;

    Node(int i, int j, int dist) {
        this.i = i;
        this.j = j;
        this.dist = dist;
    }
}

public class WallsAndGate {

    public void wallsAndGates(int[][] rooms) {

        Queue<Node> queue = new LinkedList<>();
        Queue<Node> aux = new LinkedList<>();

        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    queue.add(new Node(i, j, 0));
                }
            }
        }

        int[][] delta = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1 } };
        while (!queue.isEmpty()) {

            var node = queue.poll();

            for (int i = 0; i < delta.length; i++) {
                int dr = node.i + delta[i][0];
                int dc = node.j + delta[i][1];

                if (isValid(dr, dc, rooms) && rooms[dr][dc] > node.dist + 1 && rooms[dr][dc] != -1) {
                    rooms[dr][dc] = node.dist + 1;
                    queue.add(new Node(dr, dc, node.dist + 1));

                }
            }

        }
    }

    private boolean isValid(int r, int c, int[][] rooms) {
        return !(r < 0 || c < 0 || r >= rooms.length || c >= rooms[r].length);
    }

    public static void main(String[] args) {
        WallsAndGate wallsAndGate = new WallsAndGate();
        int[][] arr = { { 2147483647, -1, 0, 2147483647 }, { 2147483647, 2147483647, 2147483647, -1 },
                { 2147483647, -1, 2147483647, -1 }, { 0, -1, 2147483647, 2147483647 } };
        wallsAndGate.wallsAndGates(arr);

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

}
